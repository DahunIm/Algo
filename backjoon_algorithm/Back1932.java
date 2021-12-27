package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back1932 {

	public static int[][] ary;
	public static int[][] memo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		ary = new int[num][num];
		memo = new int[num][num];
		
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j <= i; j++) {
				int val = Integer.parseInt(st.nextToken());
				ary[i][j] = val;
			}
			
		}
		memo[0][0] = ary[0][0];
		memo[1][0] = ary[0][0] + ary[1][0];
		memo[1][1] = ary[0][0] + ary[1][1];
		
		int max = calc(num-1, 0);
		
		for(int i = 2; i <= num; i++) {
			if(max < calc(num-1, i - 1)) max = memo[num-1][i-1]; 
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int calc(int num, int index) {
		
		
		if(memo[num][index] == 0) {
			
			if(index == 0) {
				memo[num][index] = calc(num - 1, index) + ary[num][index];
			}
			else if(index == num) {
				memo[num][index] = calc(num -1, index - 1) + ary[num][index];
			}
			else {
				memo[num][index] = Math.max(calc(num-1, index - 1), calc(num-1, index)) + ary[num][index];
			}
				
		}
		
		return memo[num][index];
	}
}
