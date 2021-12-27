package backjoon1;

import java.util.Scanner;

public class hw35 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int ary[] = new int[num];
		for(int i = 0 ; i < num ; i++) {
			
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			
			double len = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
			
			if(x1 == x2 && y1 == y2) {
				if(r1 == r2) ary[i] = -1;
				else ary[i] = 0;	
			}
			
			else {
				if(len > (double)(r1 + r2)) ary[i] = 0;
				else if(len == (double)(r1 + r2)) ary[i] = 1;
				else {
					if(len == (double)Math.abs(r1 - r2)) ary[i] = 1;
					else if(len < (double)Math.abs(r1 - r2)) ary[i] = 0;
					else ary[i] = 2;
				}	
			}
		}
		for(int j = 0 ; j < ary.length ; j++) {
			System.out.println(ary[j]);
		}
	}

}
