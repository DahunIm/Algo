package backjoon_algorithm;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Back1976 {

	public static StringBuilder sb;
	public static int[] way;
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		way = new int[n + 1];
		Arrays.fill(way, -1);
		
		for(int i = 1; i <= n ; i++) {
			for(int j = 1; j <= n; j++) {
				int a = sc.nextInt();
				
				if(a == 1) union(i, j);			
			}
		}
		
		int prev = sc.nextInt();
		boolean check = true;
		
		sb = new StringBuilder();
		
		for(int i = 1; i <m ; i++) {
			int tmp = sc.nextInt();
			if(!check_way(prev, tmp)) {
				sb.append("NO\n");
				check = false;
				break;
			}
			prev = tmp;
		}
		
		if(check) sb.append("YES\n");
		
		System.out.print(sb);
		sc.close();
		
	}
	
	
	
	public static int find(int a) {
		
		if(way[a] < 0) {
			return a;
		}
		
		else {		
			int tmp = find(way[a]);
			way[a] = tmp;
			return tmp;	
		}		
	}
	
	public static Boolean check_way(int a, int b) {
		
		if(find(a) == find(b)) return true;
		
		return false;
	
	}
	
	public static void union(int a, int b) {
		
		a = find(a);
		b = find(b);
		
		if(a == b) return;
		
		if(way[a] < way[b]) {	
			way[a] += way[b];
			way[b] = a;	
		}
		else {
			way[b] += way[a];
			way[a] = b;
		}
	}
}
