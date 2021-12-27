package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class hw30 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true) {
		String s = br.readLine();

		int num = Integer.parseInt(s);
		if(num == 0) {
			break;
		}
		bw.write(is_prime_num(num) + "\n");
		
		}
		bw.flush();
		bw.close();
		
	}

	public static int is_prime_num(int num) {
		
		int count = 0;
		
	
		
		for(int i = num + 1; i <= 2 * num; i++) {
			
			if(is_prime(i)) count++;
			
		}	
		
		return count;	
	}

	public static boolean is_prime(int num) {
		
		int gap = (int)Math.sqrt(num);
		
		if( num == 1) {
			return false;
		}
		
		for(int i = 2; i <= gap; i++) {
			
			if(num % i == 0) return false;
			
		}	
		
		return true;	
	}
	
}