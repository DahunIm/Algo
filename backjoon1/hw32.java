package backjoon1;

import java.util.Scanner;

public class hw32 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int garo = w-x >= x ? x : w-x;
		int sero = h-y >= y ? y : h-y;
		
		int result = garo - sero >= 0 ? sero : garo; 
		
		System.out.println(result);
		
	}

}
