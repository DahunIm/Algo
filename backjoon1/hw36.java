package backjoon1;

import java.util.Scanner;

public class hw36 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		int result = pibo(input);
		//int result = factorial(input);
			
		System.out.println(result);
		sc.close();
	}
	
	public static int pibo(int num) {
		
		if(num == 0) {
			return 0;
		}
		else if(num == 1) {
			return 1;
		}

		return (pibo(num-1) + pibo(num-2));
		
	}
	/*
	public static int factorial(int num) {
		
		if(num == 0) {
			return 1;
		}
		
		return num * factorial(num - 1);
	}
	*/
	
}
