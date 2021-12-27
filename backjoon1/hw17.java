package backjoon1;

import java.util.Scanner;

public class hw17 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String cro_st = sc.nextLine();
		
		int i = 0;
		int cro_num = 0;
		int index;
		while(i<cro_st.length()) {
			
			
			index = find_index(cro_st, i);
			
			cro_num++;
			
			i = index;
			
		}
		
		System.out.println(cro_num);
	}
	
	public static int find_index(String cro, int index) {
		if(index == cro.length()-1) {
			return index + 1;
		}
		
		switch(cro.charAt(index)) {
			case 'c':
				if(cro.charAt(index + 1) == '=' || cro.charAt(index + 1) == '-') return (index + 2);		
				else return(index + 1);	
			case 'd':
				if(index < cro.length() - 2 && (cro.charAt(index + 1) == 'z' && cro.charAt(index + 2) == '=')) return (index + 3);
				else if(cro.charAt(index + 1) == '-') return(index + 2);
				else return(index + 1);
			case 'l':
				if(cro.charAt(index + 1) == 'j') return(index + 2);
				else return(index + 1);
			case 'n':
				if(cro.charAt(index + 1) == 'j') return(index + 2);
				else return(index + 1);
			case 's':
				if(cro.charAt(index + 1) == '=') return(index + 2);
				else return(index + 1);
			case 'z':
				if(cro.charAt(index + 1) == '=') return(index + 2);
				else return(index + 1);
			default:
				return(index + 1);
		}
	}

}
