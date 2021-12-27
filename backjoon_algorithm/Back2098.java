package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back2098 {

	public static int max;
	public static int[][] origin;
	public static long[][] memo;
	public static int resultBit; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		max = Integer.parseInt(br.readLine());
		origin = new int[max][max];
		memo = new long[max][1 << max];
		resultBit = (1 << max) - 1;
		
		for(int i = 0 ; i < max; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < max; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(long[] tmp: memo) {
			Arrays.fill(tmp, Integer.MAX_VALUE);
		}
		
		long result = dfs(0, 1);
		if(result == Integer.MAX_VALUE) sb.append("0\n");
		else sb.append(result + "\n");
		System.out.print(sb);
		br.close();
		
	}
	
	public static long dfs(int node, int nowBit) {
		
		// 탈출
		if(nowBit == resultBit) {
			if(origin[node][0] == 0) return Integer.MAX_VALUE;
			else return origin[node][0];
		}
		
		// 들림
		if(memo[node][nowBit] != Integer.MAX_VALUE) return memo[node][nowBit];
		
		
		// 순회 안한 노드 순회
		for(int i = 0 ; i < max; i++) {
			if(origin[node][i] == 0) continue;
			if((nowBit & (1 << i)) == (1 << i)) continue;
			
			memo[node][nowBit] = Math.min(memo[node][nowBit], origin[node][i] + dfs(i, nowBit | (1 << i))/* dfs 다음 노드 순회*/);
			
		}

		return memo[node][nowBit];
	}

}
