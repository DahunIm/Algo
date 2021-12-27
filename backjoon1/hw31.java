package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class hw31 {

	public static void main(String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int part_num, part_num1;
		for(int i = 0; i < num ; i++) {
			
			int input = Integer.parseInt(br.readLine());
			
			if(input % 2 != 0) {
				continue;
			}
			
			part_num = gold_num(input);
			part_num1 = Math.abs(input - part_num);
			
			bw.write(part_num + " " + part_num1 + "\n");
			
		}
		
		bw.flush();
		bw.close();
	}

	
	public static int gold_num(int num) {
		
		int num1, num2;
		int result = 0;
		int gap = num;
		for(int i = 2; i <= num / 2; i++) {
			
			if(is_prime(i) && is_prime(Math.abs(num - i))) {
				if(gap > Math.abs(num - i * 2))
				result = i;
			}
			
		}
		
		return result;
	}
	
	
	public static boolean is_prime(int num) {
		
		int gap = (int)Math.sqrt(num);
		
		for(int i = 2; i <= gap; i++) {
			
			if(num % i == 0) return false;
			
		}	
		
		return true;	
	}

}


