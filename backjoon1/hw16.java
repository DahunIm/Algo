package backjoon1;

import java.util.Scanner;

public class hw16 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String st = sc.nextLine();
		
		int total_sec = 0;
		
		for(int i = 0 ; i < st.length(); i++) {
			
			total_sec += char_to_second(st.charAt(i));
			
		}
		System.out.println(total_sec);
		
		
		
		
	}
	
	public static int char_to_second(char ch) {
		
		int result_second = 0;
		
		switch(ch) {
			case 'A': case 'B': case'C':
				result_second = 3;
				break;
			case 'D': case 'E': case'F':
				result_second = 4;
				break;
			case 'G': case 'H': case'I':
				result_second = 5;
				break;
			case 'J': case 'K': case'L':
				result_second = 6;
				break;
			case 'M': case 'N': case'O':
				result_second = 7;
				break;
			case 'P': case 'Q': case'R': case'S':
				result_second = 8;
				break;
			case 'T': case 'U': case'V':
				result_second = 9;
				break;
			case 'W': case 'X': case'Y': case'Z':
				result_second = 10;
				break;
			default:
				break;
		
		}
		
		return result_second;
	}

}
