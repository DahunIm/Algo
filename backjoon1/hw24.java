package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class hw24 {

	public static void main(String[] args) throws IOException {
		
		int f_ary[][] = new int[15][14];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		f_ary = make_ary(f_ary);
		int num = Integer.parseInt(br.readLine());
		
		int i = 0;
		
		while(i < num) {
			int result;
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			result = f_ary[k][n-1];
			
			bw.write(result + "\n");
			i++;
		}
		bw.flush();
		bw.close();
	}

	
	public static int[][] make_ary(int ary[][]){
		
		for(int i = 0; i < ary.length; i++) {
			ary[i][0] = 1; 
		}
		
		for(int j = 0; j < ary[0].length; j++) {
			ary[0][j] = j+1;
		}
		
		for(int i = 1; i < ary.length; i++) {
			for(int j = 1; j < ary[0].length;j++) {
				
				ary[i][j] =  ary[i-1][j] + ary[i][j-1];
			}
			
			
		}
		
		
		return ary;
	}
}
