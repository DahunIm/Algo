package backjoon1;

import java.util.Scanner;

public class hw18 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		sc.nextLine();
		
		int i = 0, group = 0;
		while(i < num) {
			
			String st = sc.nextLine();
			if(find_group(st)) group++;
			
			i++;
		}
		System.out.println(group);
	}
	
	
	
	public static boolean find_group(String st) {
		
		int ary[] = new int[26];
		
		ary[(int)st.charAt(0)-97]++;
		
		for(int i = 1; i< st.length(); i++) {
			if(ary[(int)st.charAt(i) - 97] == -1) {
				return false;
			}
			else {
				if(st.charAt(i) == st.charAt(i-1)) {
				
					ary[(int)st.charAt(i) - 97]++;
				
				}
			
				else {
				
					ary[(int)st.charAt(i-1) - 97] = -1;
					ary[(int)st.charAt(i) - 97]++;
				}
			
			}
		}
		
		return true;
		
	}
}
