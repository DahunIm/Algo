package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class hw37 {

	public static char ary[][];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input = Integer.parseInt(br.readLine());
		
		ary = new char[input][input];
		
		for(char a[]:ary) {
			Arrays.fill(a, ' ');
		}
		
		star(0,0,input);
		
		
		for(int i = 0; i < input; i++) {
			for(int j = 0; j < input ; j++) {
				
				bw.write(ary[i][j]);
				
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void star(int x, int y, int len){
		
		
		if(len == 1) {			
			
			ary[x][y] = '*';
			return;
		}
		
		int size = len / 3;
		
		for(int i = 0; i < 3; i ++) {
			for(int j = 0; j < 3 ; j++) {
				if(i == 1 && j == 1) {
					continue;
				}
				else {
					star(x + (i*size), y + (j*size), size);
				}
			}
		}
		
	}
}
