package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class hw38 {
	
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int input = Integer.parseInt(br.readLine());
		int gap = 1;
		for(int i = 0 ; i < input; i++) {
			gap *= 2;
		}
		gap -= 1;

		bw.write(gap + "\n");
		hanoi(1,2,3,input);
		
		bw.close();
	}

	
	public static void hanoi(int from, int m, int to, int num) throws IOException {
		
		if(num == 0) {
			return;
		}
	
		hanoi(from, to, m, num-1);
		bw.write(from + " " + to + "\n");
		hanoi(m, from, to, num-1); 
	}
}
