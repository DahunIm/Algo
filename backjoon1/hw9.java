package backjoon1;

import java.util.Scanner;

public class hw9 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		int score_ary[] = new int[num];
		int i = 0;
		while(i < num) {
			
			String test = sc.nextLine();
			//System.out.println(test);
			score_ary[i] = score(test);
			i++;
		}
		
		for(int j = 0; j < num; j++) {
			System.out.println(score_ary[j]);
		}
		
	}

	
	
	public static int score(String test) {
		
		int sc = 0;
		int yeon = 1;
		
		for(int i = 0; i < test.length(); i++) {
			
			if(test.charAt(i) == 'O') {
				sc += yeon;
				yeon++;
			}
			else {
				yeon = 1;
			}
			
		}
		
		return sc;
	}

}
