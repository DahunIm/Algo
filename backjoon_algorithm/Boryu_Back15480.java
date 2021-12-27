package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boryu_Back15480 {

	public static ArrayList<Integer>[] tree;
	public static int[][] parents;
	public static boolean[] visited;
	public static int[] depth;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int size = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[size + 1];
		visited = new boolean[size + 1];
		depth = new int[size+1];
		parents = new int[size+1][22];
		
		for(int i = 1; i <= size; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 1 ; i < size; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int num1 = Integer.parseInt(st.nextToken()); 
			int num2 = Integer.parseInt(st.nextToken());
			tree[num1].add(num2);
			tree[num2].add(num1);
		}
		
		int cmdLine = Integer.parseInt(br.readLine());
		dfs(1, 0);
		connect(size);
		
		for(int i = 1; i <= cmdLine; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int root = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			int result = lca(root, num1);
			
		}
		
		System.out.print(sb);
		br.close();
		
	}

	
	public static void dfs(int cur, int dep) {
		visited[cur] = true;
		depth[cur] = dep;
		
		for(int next : tree[cur]) {
			if(visited[next]) continue;
			
			parents[next][1] = cur;
			dfs(next, dep + 1);
		}
		
	}
	
	public static void connect(int N) {
		
		for(int i = 2; i < 22; i++) {
			for(int cur = 1; cur <= N; cur++) {
				parents[cur][i] = parents[parents[cur][i-1]][i-1];
			}
		}
	}
	
	public static int lca(int n1, int n2) {
		
		if(depth[n1] > depth[n2]) {
			int tmp = n1;
			n1 = n2;
			n2 = tmp;
		}
		
		for(int i = 21; i > 0; i--) {
			int jump = 1 << i-1;

			if(depth[n2] - depth[n1] >= jump) n2 = parents[n2][i];
		}
		
		if(n1 == n2) return n1;
		
		
		for(int i = 21; i > 0; i--) {
			if(parents[n1][i] == parents[n2][i]) continue;
			
			n1 = parents[n1][i];
			n2 = parents[n2][i];		
		}
		
		
		return parents[n1][1];
		
		
	}
	
	
	
	
}
