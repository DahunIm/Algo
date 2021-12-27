package backjoon_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Back20040 {

	public static int[] rank;
	public static int[] parent;
	public static boolean check;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		rank = new int[n];
		parent = new int[n];
		for(int i = 0; i < n; i++) parent[i] = i;
		Arrays.fill(rank, 1);
		check = true;
		for(int i = 0; i < m; i++) {
			int s_V = sc.nextInt();
			int e_V = sc.nextInt();
			
			union(s_V, e_V, i + 1);
		}
		if(sb.length() == 0) sb.append("0\n");
		System.out.print(sb);
		sc.close();
	}

	public static int find(int x) {
		
		if(x == parent[x]) return x;
		
		return parent[x] = find(parent[x]);
		
	}
	
	
	public static void union(int x, int y, int index){
		
		int a = find(x);
		int b = find(y);
		
		if(a == b && check) {
			sb.append(index + "\n");
			check = false;
		}
		else if( a == b) return;
		else {
			if(rank[a] < rank[b]) {
				
				parent[a] = b;
				rank[b] += rank[a];
				
			}
			else {
				
				parent[b] = a;
				rank[a] += rank[b];
			}		
		}	
	}
}
