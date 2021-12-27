package backjoon_algorithm;
/*
 * ¾êµµ ºÁ Æ²¸²
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back1463 {

	public static int[] memo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		memo = new int[num + 1];
		
		calc(num);

		bw.write(memo[num] + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}

	
	public static int calc(int num) {
		
		if(num == 1) return 0;
			
		if(memo[num] == 0) {
			if(num % 3 == 0) {
				if(num % 2 ==0) {
					memo[num] = Math.min(calc(num / 3) + 1, Math.min(calc(num /2) + 1, calc(num - 1) + 1));
				}
				else {
					memo[num] =  Math.min(calc(num / 3) + 1, calc(num - 1) + 1);
				}
			}
			else if(num % 2 == 0) memo[num] = Math.min(calc(num / 2) + 1, calc(num - 1) + 1);
			else memo[num] = calc(num -1) + 1;
		}
		return memo[num];
	}	
}
