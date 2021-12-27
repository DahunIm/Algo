package backjoon1;

import java.util.Scanner;

public class hw40 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		find_sang(input);
		
		sc.close();
	}
	
	public static void find_sang(int num) {
		
		int min = num;
		int sang = 0;
		int tmp;
		for(int i = 1; i < num ; i++) {
			sang = i;
			tmp = i;
			while(true) {
				
				if(tmp / 10 == 0) {
					sang += tmp % 10; 
					break;
				}
				
				sang += tmp % 10;
				tmp /= 10;
				
			}
			
			if(sang == num && sang <= min) {
				min = i;
			}
			
		}
		
		if(num == min) {
			System.out.println("0");
		}
		else {
			System.out.println(min);
		}
	}

}
