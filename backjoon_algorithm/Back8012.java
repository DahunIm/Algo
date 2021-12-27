package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back8012 {

	public static ArrayList<Node>[] tree;
	public static boolean[] visited;
	public static int[] depth;
	public static Node[][] parents;
	public static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
	
		depth = new int[N+1];
		tree = new ArrayList[N+1];
		visited = new boolean[N+1];
		parents = new Node[N+1][19];
		result = 0;
		
		for(int i = 1 ; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j < 19; j++) {
				parents[i][j] = new Node(0, 0);
			}
		}
		
		
		for(int i = 0 ; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			tree[v1].add(new Node(v2, 0));
			tree[v2].add(new Node(v1, 0));			
		}	
		
		dfs(new Node(1, 0), 0);
		connect(N);
		
		int M = Integer.parseInt(br.readLine());
		
		int prevGo = 1;
		for(int i = 0 ; i < M; i++) {
			int numGo = Integer.parseInt(br.readLine());
			result += lca(new Node(prevGo, 0), new Node(numGo, 0));
			prevGo = numGo;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(result +"\n");
		System.out.print(sb);
		br.close();
	}
	
	public static void dfs(Node cur, int dep) {
		visited[cur.num] = true;
		depth[cur.num] = dep;
		
		for(Node next : tree[cur.num]) {
			if(visited[next.num]) continue;
			
			parents[next.num][1].num = cur.num;
			parents[next.num][1].weight = 1;
			dfs(next, dep + 1);			
		}
	}
	
	public static void connect(int N) {
		
		for(int i = 2 ; i < 19; i++) {
			for(int cur = 1; cur <= N; cur++) {
				if(parents[parents[cur][i-1].num][i-1].num == 0) continue;
				parents[cur][i].num = parents[parents[cur][i-1].num][i-1].num;
				parents[cur][i].weight = parents[cur][i-1].weight + parents[parents[cur][i-1].num][i-1].weight;
			}
		}
		
	}
	
	public static int lca(Node n1, Node n2) {
		
		int len = 0;
		
		if(depth[n1.num] > depth[n2.num]) {
			Node tmp = n1;
			n1 = n2;
			n2 = tmp;
		}
		
		for(int i = 18; i > 0; i--) {
			int jump = 1 << (i-1);
			if(depth[n2.num] - depth[n1.num] >= jump) {
				
				len += parents[n2.num][i].weight;
				n2 = parents[n2.num][i];
			}
		}
		
		if(n1.num == n2.num) return len;
		
		for(int i = 18; i > 0 ; i--) {
			if(parents[n1.num][i].num == parents[n2.num][i].num) continue;
			
			len += parents[n1.num][i].weight;
			len += parents[n2.num][i].weight;
			
			n1 = parents[n1.num][i];
			n2 = parents[n2.num][i];
		}
		len += parents[n1.num][1].weight;
		len += parents[n2.num][1].weight;
		
		return len;
		
	}
	
	
	static class Node {
		int num, weight;

		public Node(int num, int weight) {
			super();
			this.num = num;
			this.weight = weight;
		}
		
	}

}
