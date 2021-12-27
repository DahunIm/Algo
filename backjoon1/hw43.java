package backjoon1;

import java.util.Scanner;

public class hw43 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		find_six(num);
		sc.close();
	}

	
	public static void find_six(int num) {
		
		int count = 0;
		int i = 666;
		while(true) {
			
			if(check_six(i)) {
				count++;
			}
			if(count == num) {
				System.out.println(i);
				break;
			}
			
			i++;
		}
		
	}
	
	public static boolean check_six(int num) {
		
		String s = Integer.toString(num);
		
		int count = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '6' ) {
				count++;
			}
			else {
				count = 0;
			}
			
			if(count == 3) {
				return true;
			}
		}

		return false;
	}
}
