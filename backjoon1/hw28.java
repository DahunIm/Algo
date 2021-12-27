package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class hw28 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int div_num;
		
		while(num != 1) {
		
			div_num = divide_num(num);
			
			num /= div_num;
			
			bw.write(div_num + "\n");
		}
		
		bw.flush();
		bw.close();
		
				
		
		
	}

	public static int divide_num(int num) {
		
		int result = 0;
		
		for(int i = 2; i <= num ; i++) {
			
			if(num % i == 0) {
				result = i;
				break;
			}
		}
		
		
		return result;
	}
	
}
