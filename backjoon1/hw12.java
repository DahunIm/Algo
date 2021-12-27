package backjoon1;

import java.util.Scanner;

public class hw12 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int gat = hansu(num);
		
		System.out.println(gat);
	
	}

	
	
	
	public static int hansu(int num) {
		
		int result = 0;
		
		for(int i = 1 ; i <= num ; i++) {
			String s = Integer.toString(i);
			
			if(check(s)) result++;
			
		}
		
		
		return result;
	}
	
	public static boolean check(String num) {
		
		int ary[] = new int[num.length()];
		if(num.length() < 3) return true;
		
		else {
			
			for(int i = 0; i<num.length(); i++) {
				
				ary[i] = Character.getNumericValue(num.charAt(i));
				
			}
			
			for(int j = 1; j<num.length() - 1 ; j++) {
				
				if(ary[j - 1] - ary[j] != ary[j] - ary[j + 1]) {
					return false;
				}
			
			}
			
			return true;
		}
			
	}
}
