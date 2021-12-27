package backjoon1;

import java.util.Scanner;

public class hw55 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int Y = sc.nextInt();
		
		int[] ary = new int[X + 1];
		int num;
		for(int i = 1; i <= X; i++) {
			ary[i] = i;
		}
		
		
		for(int k = 1; k <= X; k++) {
			System.out.print(ary[k] + " ");
		}
		System.out.println();
	
	}

}
