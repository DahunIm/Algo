package backjoon_algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class stack3 {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < num ; i++) {
			
			String s = br.readLine();
			check_input(s);
			
		}
		bw.flush();
		bw.close();
		
	}

	public static void check_input(String s) throws IOException {
		
		int left = 0, right = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(left - right < 0) {
				bw.write("NO" + "\n");
				return;
			}
			
			if(s.charAt(i) == '(') {
				left++;
			}
			else if(s.charAt(i) == ')') {
				right++;
			}
	
		}
		if(left - right != 0) {
			bw.write("NO" + "\n");
		}
		else {
			bw.write("YES" + "\n");
		}
		
	}
}
