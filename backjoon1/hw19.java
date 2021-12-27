package backjoon1;

import java.util.Scanner;

public class hw19 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int bungi = 1, soon = C -(A + B);
		int tmp = C;
		
		if( B >= C) {
			System.out.println("-1");
		}
		
		else {
			while(B < C && soon <= 0) {
			
				soon += (C - B);
				bungi++;
			
			}
		

			System.out.println(bungi);
		}
	}

}
