package backjoon_algorithm;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Back3176 {

	public static ArrayList<Node>[] tree;
	public static Node[][] parents;
	public static int[] depth;
	public static boolean[] visited;
	public static int N;
	public static int resultMax, resultMin;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		parents = new Node[N+1][19];
		tree = new ArrayList[N+1];
		depth = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i = 0 ; i <= N; i++) {
			for(int j = 0 ; j < 19; j++) {
				parents[i][j] = new Node(0, 0, 0);
			}
		}
		
		for(int i = 1 ; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < N-1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sV = Integer.parseInt(st.nextToken());
			int eV = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			tree[sV].add(new Node(eV, wei, wei));
			tree[eV].add(new Node(sV, wei, wei));
		}
		
		int num = Integer.parseInt(br.readLine());
		
		dfs(new Node(1, 0, 0), 0);
		
		connect();
		
		for(int i = 0 ; i < num; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sV = Integer.parseInt(st.nextToken());
			int eV = Integer.parseInt(st.nextToken());
			lca(new Node(sV, 0, 0), new Node(eV, 0 ,0));
			sb.append(resultMin + " " + resultMax + "\n");
			
		}
		
		System.out.println(sb);
		br.close();
		
	}
	
	
	public static void dfs(Node cur, int dep) {
		visited[cur.num] = true;
		depth[cur.num] = dep;
		
		for(Node next : tree[cur.num]) {
			if(visited[next.num]) continue;
			parents[next.num][1].num = cur.num;
			parents[next.num][1].max = next.max;
			parents[next.num][1].min = next.min;
			dfs(next, dep+1);
		}
	
	}
	
	public static void connect() {
		
		for(int i = 2; i < 19; i++) {
			for(int cur = 1; cur <= N; cur++) {
				if(parents[parents[cur][i-1].num][i-1].num == 0) continue;
				parents[cur][i].num = parents[parents[cur][i-1].num][i-1].num;
				parents[cur][i].max = Math.max(parents[cur][i-1].max, parents[parents[cur][i-1].num][i-1].max);
				parents[cur][i].min = Math.min(parents[cur][i- 1].min, parents[parents[cur][i-1].num][i-1].min);
			}
		}
		
	}
	
	public static void lca(Node v1, Node v2) {
		int max = 0;
		int min = Integer.MAX_VALUE;
		if(depth[v1.num] > depth[v2.num]) {
			Node tmp = v1;
			v1 = v2;
			v2 = tmp;			
		}
		
		for(int i = 18; i > 0; i--) {
			int jump = 1 << i-1;
			if(depth[v2.num] - depth[v1.num] >= jump) {
				max = Math.max(max, parents[v2.num][i].max);
				if(parents[v2.num][i].min != 0)
					min = Math.min(min, parents[v2.num][i].min);
				v2 = parents[v2.num][i];		
			}
		}
		
		if(v1.num == v2.num) {
			max = Math.max(max, Math.max(v1.max, v2.max));
			if(v2.min != 0 && v1.min != 0)
				min = Math.min(min, Math.min(v1.min, v2.min));
			resultMax = max;
			resultMin = min;
			return;
		}
		
		for(int i = 18; i > 0; i--) {
			if(parents[v1.num][i].num == parents[v2.num][i].num) continue;
			
			max = Math.max(max, Math.max(parents[v1.num][i].max, parents[v2.num][i].max));
			min = Math.min(min, Math.min(parents[v1.num][i].min, parents[v2.num][i].min));
			v1 = parents[v1.num][i];
			v2 = parents[v2.num][i];
					
		}
		
		max = Math.max(max, Math.max(parents[v1.num][1].max, parents[v2.num][1].max));
		min = Math.min(min, Math.min(parents[v1.num][1].min, parents[v2.num][1].min));
		resultMax = max;
		resultMin = min;
		
	}
	

	
	static class Node {
		int num, max, min;

		public Node(int num, int max, int min) {
			super();
			this.num = num;
			this.max = max;
			this.min = min;
		}
			
	}
}
