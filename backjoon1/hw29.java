package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class hw29 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		int min = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());

		if(min == 1) {
			min += 1;
		}
		
		for(int i = min ; i <= max ; i++) {
			
			if(is_prime(i)) {
				bw.write(i + "\n");
			}
			
		}
		
		bw.flush();
		bw.close();
		
	}

	public static boolean is_prime(int num) {
		
		int gap = (int)Math.sqrt(num);
		
		for(int i = 2; i <= gap; i++) {
			
			if(num % i == 0) return false;
			
		}	
		
		return true;	
	}
	
}
