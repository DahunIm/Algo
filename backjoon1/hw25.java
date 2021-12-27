package backjoon1;

import java.util.Scanner;

public class hw25 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int weight = sc.nextInt();
		int x3 = 0, x5 = 0;
		int i = weight / 5;
		
		while(i >= 0) {
			
			if((weight - i * 5) % 3 == 0) {
				x5 = i;
				x3 = (weight - i * 5) / 3;
				break;
			}
			

			i--;
			
		}
		if(x3 == 0 && x5 == 0) {
			System.out.println("-1");
		}
		else {
			System.out.println(x3 + x5);
			
		}
	}

}
