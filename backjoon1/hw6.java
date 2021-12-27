package backjoon1;

import java.util.Scanner;

public class hw6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int num[] = new int[10];
		int result = num1 * num2 * num3;
		String s = Integer.toString(result);
		
		for(int j = 0; j < s.length() ; j++) {
			switch(Character.getNumericValue(s.charAt(j))){
				case 0:
					num[0] += 1;
					break;
				case 1:
					num[1] += 1;
					break;
				case 2:
					num[2] += 1;
					break;
				case 3:
					num[3] += 1;
					break;
				case 4:
					num[4] += 1;
					break;
				case 5:
					num[5] += 1;
					break;
				case 6:
					num[6] += 1;
					break;
				case 7:
					num[7] += 1;
					break;
				case 8:
					num[8] += 1;
					break;
				case 9:
					num[9] += 1;
					break;
			}
		}
		for(int i = 0; i <= 9; i++ ) {
			System.out.println(num[i]);
		}
	}
}
