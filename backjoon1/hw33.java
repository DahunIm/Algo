package backjoon1;

import java.util.Scanner;

public class hw33 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num_x1 = sc.nextInt();
		int num_y1 = sc.nextInt();
		int num_x2 = sc.nextInt();
		int num_y2 = sc.nextInt();
		int num_x3 = sc.nextInt();
		int num_y3 = sc.nextInt();
		int num_x4, num_y4;
		if(num_x1 == num_x2) {
			
			num_x4 = num_x3;
		}
		else {
			num_x4 = num_x1 == num_x3 ? num_x2 : num_x1;
		}
		
		if(num_y1 == num_y2) {
			num_y4 = num_y3;
		}
		else {

			num_y4 = num_y1 == num_y3 ? num_y2 : num_y1;
		}
		
		System.out.println(num_x4 + " " + num_y4);
		
		sc.close();
	}

}
