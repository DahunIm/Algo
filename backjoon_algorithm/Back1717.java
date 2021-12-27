package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back1717 {

	public static StringBuilder sb;
	public static int[] parent;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		parent = new int[n + 1];
		Arrays.fill(parent, -1);
		
		for(int i = 0; i < m; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(cmd == 0) union(a, b);
			else if( cmd == 1) check_node(a, b);
	
		}
		System.out.print(sb);
	}
	
	public static int find(int a) {
		
		if(parent[a] < 0) {
			return a;
		}
		else {
			int tmp = find(parent[a]);
			parent[a] = tmp;
			return tmp;
		}
	}
	
	public static void check_node(int a, int b) {
		
		if(find(a) == find(b)) sb.append("YES\n");
		else sb.append("NO\n");
		
	}
	
	public static void union(int a, int b) {
		
		int x = find(a);
		int y = find(b);
		
		if(x == y) {
			return;
		}
		
		if(parent[x] < parent[y]) {
			parent[x] += parent[y];
			parent[y] = x;
		}
		
		else {
			parent[y] += parent[x];
			parent[x] = y;
		}
	}
	
}
