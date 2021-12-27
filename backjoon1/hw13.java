package backjoon1;

import java.util.Arrays;
import java.util.Scanner;

public class hw13 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String st = sc.nextLine();
		
		int ary[] = new int[26];
		Arrays.fill(ary, -1);
		
		for(int i = 0; i < st.length(); i++) {
			
			char tmp_ch = st.charAt(i);
			int index = (int)tmp_ch - 97;
			if(ary[index] == -1) ary[index] = i;
			
		}
	
		System.out.print(ary[0]);
		for(int i = 1 ; i < ary.length; i++) {
		
			System.out.print(" " + ary[i]);
		}
		
	}
	
}
