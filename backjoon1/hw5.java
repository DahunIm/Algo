package backjoon1;

import java.io.IOException;
import java.util.Scanner;

public class hw5 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int cycle = 0;
		int st_num = sc.nextInt();
		int now_num = -1;
		int tmp_num, num1, num2 = 0;
		while(st_num != now_num) {
			cycle++;
			if(cycle == 1) {
				now_num = st_num;
				tmp_num = st_num;
				if(st_num < 10) {
					now_num *= 10;
				}
				num1 = tmp_num / 10;
				num2 = tmp_num % 10;
			}
			
			else {
				num1 = now_num / 10;
				num2 = now_num % 10;
			}
			
			now_num = num2 * 10 + ((num1 + num2) % 10); 
		}
		
		System.out.println(cycle);
		sc.close();
	}
}
	