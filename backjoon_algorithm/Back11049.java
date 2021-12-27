package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back11049 {

	public static int[][] ary;
	public static int[][] mem;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		ary = new int[num +1][2];
		mem = new int[num + 1][num + 1];
		
		for(int i = 1; i <= num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			ary[i][0] = Integer.parseInt(st.nextToken());
			ary[i][1] = Integer.parseInt(st.nextToken());

		}	

		for(int i = 1; i <= num; i++) {	
			for(int start = 1; start + i <= num; start++) {
				int end = start + i;
				mem[start][end] = Integer.MAX_VALUE;
					for(int mid = start; mid < end; mid++) {
						mem[start][end] = Math.min(mem[start][end], mem[start][mid] + mem[mid + 1][end] + ary[start][0] * ary[mid][1] * ary[end][1]);

				}
			}
		}
		bw.write(mem[1][num] +"\n");
		bw.flush();
		bw.close();
		br.close();
		
	}

}
