package backjoon1;

import java.util.Scanner;

public class hw15 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		int num[] = new int[26];
		String st = sc.nextLine();
		
		st = st.toUpperCase();
		
		for(int i = 0 ; i < st.length(); i++) {
			
			num[(int)st.charAt(i) - 65]++;
		
		}
		
		int max_index = find_max(num);
		
		if(find_dup(num, max_index)) {
			System.out.println("?");
		}
		else {
			System.out.println((char)(max_index+ 65));
		}
		
		
	}
	
	public static int find_max(int num[]) {
		
		int max = 0;
		int max_index = 0;
		
		for(int i = 0; i < num.length; i++ ) {
			
			if(max < num[i]) {
				max = num[i];
				max_index = i;
			}
			
		}
		
		return max_index;
		
	}
	
	public static boolean find_dup(int num[],int max_index) {
		
		for(int i = 0; i < num.length; i++ ) {
			
			if( i != max_index && num[max_index] == num[i] ) {
				return true;
			}
			
		}
		return false;
		
	}
}
