package backjoon_algorithm;

import java.util.Scanner;

public class warshall1 {
	
	public static int INF = 987654321;
	public static long[][] ary;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int line = sc.nextInt();
		
		ary = new long[num][num];
		
		for(int i = 0 ; i < line; i++) {
			
			int s_V = sc.nextInt();
			int e_V = sc.nextInt();
			int distan = sc.nextInt();
			
			if(ary[s_V-1][e_V-1] != 0) ary[s_V-1][e_V-1] = Math.min(distan, ary[s_V-1][e_V-1]); 
			else ary[s_V-1][e_V-1] = distan;
			
		}
		warshall(num);
		sc.close();
	}
	
	public static void warshall(int num) {
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j< num; j++) {
				if(i != j && ary[i][j] == 0) ary[i][j] = INF;	
			}
		}
		
		for(int joong = 0; joong < num; joong++) {
			for(int i = 0; i < num; i++) {
				for(int j = 0; j < num; j++) {
					if(i == j || ary[i][joong] == INF || ary[joong][j] == INF) continue;
					if(ary[i][j] > ary[i][joong] + ary[joong][j]) {
						ary[i][j] = ary[i][joong] + ary[joong][j];
					}	
				}
			}	
		}
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				if(ary[i][j] == INF) ary[i][j] = 0;
				System.out.print(ary[i][j] + " ");
			}
			System.out.println();
		}	
	}
}
