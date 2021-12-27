package backjoon1;

import java.util.Scanner;

public class hw44 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int ary[] = new int[num];
		
		for(int i = 0; i < num ; i++) {
			
			ary[i] = sc.nextInt();
			
		}
		
		ary = sort(ary);
		for(int j = 0; j < ary.length; j++) {
			System.out.println(ary[j]);
		}
		sc.close();
	}
	
	public static int[] sort(int ary[]) {
		
		int min, tmp;
		
		for(int i = 0; i < ary.length; i++) {
			min = ary[i];
			for(int j = i + 1; j < ary.length; j++) {
				if(min > ary[j]) {
					tmp = ary[i];
					ary[i] = ary[j];
					ary[j] = tmp;
					min = ary[i];
				}
			}
		}
		
		
		
		return ary;
	}

}
