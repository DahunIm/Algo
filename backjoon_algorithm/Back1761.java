package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back1761 {

	public static ArrayList<Node>[] tree;
	public static Node[][] parents;
	public static boolean[] visited;
	public static int[] depth;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N + 1];
		for(int i = 1; i <= N ; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 1 ; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sV = Integer.parseInt(st.nextToken());
			int eV = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			
			tree[sV].add(new Node(eV, wei));
			tree[eV].add(new Node(sV, wei));
		}
		
		parents = new Node[N + 1][19];
		visited = new boolean[N+1];
		depth = new int[N+1];
		
		for(int i = 0 ; i <= N; i++) {
			for(int j = 0 ; j < 19; j++) {
				parents[i][j] = new Node(0,0);
			}
		}
		
		
		int M = Integer.parseInt(br.readLine());
		
		dfs(new Node(1, 0), 0);
		connect(N);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int startV = Integer.parseInt(st.nextToken());
			int endV = Integer.parseInt(st.nextToken());
			sb.append(lca(new Node(startV, 0),new Node(endV, 0)) + "\n");
		}
		
		System.out.print(sb);
		br.close();
		
	}
	
	public static void dfs(Node cur, int dep) {
		visited[cur.num] = true;
		depth[cur.num] = dep;
		
		for(Node next : tree[cur.num]) {
			if(visited[next.num]) continue;
			parents[next.num][1].num = cur.num;
			parents[next.num][1].wei = next.wei;
			dfs(next, dep + 1);		
		}
			
	}
	
	
	public static void connect(int N) {
		
		for(int i = 2; i <= 18; i++) {
			for(int cur = 1; cur <= N; cur++) {
				if(parents[parents[cur][i-1].num][i-1].num == 0) continue;
				parents[cur][i].num = parents[parents[cur][i-1].num][i-1].num;
				parents[cur][i].wei = parents[cur][i-1].wei + parents[parents[cur][i-1].num][i-1].wei;
			}
		}	
	}
	
	public static int lca(Node v1, Node v2) {
		int v1Num = 0;
		int v2Num = 0;
		
		if(depth[v1.num] > depth[v2.num]) {
			Node tmp = v1;
			v1 = v2;
			v2 = tmp;
		}
		
		for(int i = 18; i > 0; i--) {
			int jump = 1 << i-1;
			if(depth[v2.num] - depth[v1.num] >= jump) {
				v2Num += parents[v2.num][i].wei;
				v2 = parents[v2.num][i];
			}
		}
		
		if(v1.num == v2.num) return v1Num + v2Num;
		
		for(int i = 18; i > 0; i--) {
			
			if(parents[v1.num][i].num == parents[v2.num][i].num) continue;
			
			v1Num += parents[v1.num][i].wei;
			v2Num += parents[v2.num][i].wei;
			v1 = parents[v1.num][i];
			v2 = parents[v2.num][i];
		}
		
		v1Num += parents[v1.num][1].wei;
		v2Num += parents[v2.num][1].wei;
		return v1Num + v2Num;	
	}
	
	
	
	static class Node {
		
		int num, wei;

		public Node(int num, int wei) {
			this.num = num;
			this.wei = wei;
		}
		
		
	}

}
