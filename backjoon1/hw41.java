package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hw41 {
	
	public static int ary[][];
	
	public static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		ary = new int[2][num];
		
		for(int i = 0 ; i < num ; i++) {
			
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			ary[0][i] = weight;
			ary[1][i] = height;
			
			
		}
		calc_rank();
		
	}
	
	public static void calc_rank() throws IOException {
		
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int rank[] = new int[ary[0].length];
		int tmp;
		Arrays.fill(rank, 1);
		
		for(int i = 0; i < ary[0].length - 1; i++) {
			for(int j = i + 1; j < ary[0].length; j++) {
				
				if(ary[0][i] < ary[0][j] && ary[1][i] < ary[1][j]) {
					
					rank[i]++;
					
				}
				
				else if(ary[0][i] > ary[0][j] && ary[1][i] > ary[1][j]) {
					
					rank[j]++;
					
				}
			}
		}
		
		for(int k = 0; k < rank.length - 1; k++) {
			bw.write(rank[k] + " ");
		}
		
		bw.write(rank[rank.length - 1] + "\n");
		bw.flush();
		bw.close();
	}

}
