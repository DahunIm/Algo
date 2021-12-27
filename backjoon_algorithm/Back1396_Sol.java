package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back1396_Sol {

	public static int V, E;
	public static int[] parent;
	public static int[] nVal;
	public static int[] weiAry;
	public static boolean[] visited;
	public static int[] depth;
	public static int[][] parents;
	public static ArrayList<Integer>[] tree;
	public static PriorityQueue<kruNode> ary;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken()); 
		E = Integer.parseInt(st.nextToken()); 
		
		nVal = new int[V + E + 1];
		parent = new int[V + E + 1];
		ary = new PriorityQueue<>();
		depth = new int[V + E + 1];
		visited = new boolean[V + E + 1];
		parents = new int[V+E+1][22];
		tree = new ArrayList[V + E + 1];
		weiAry = new int[V + E + 1];
		
		for(int i = 1; i <= V+ E; i++) {
			parent[i] = i;
			nVal[i] = 1;
		}
		
		for(int i =1; i <= V + E; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sV = Integer.parseInt(st.nextToken());
			int eV = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			ary.add(new kruNode(sV, eV, wei));
		}
	
		kruskal();
		
		for(int i = V+ E; i > 0; i--) {
			if(!visited[i]) dfs(i, 0);
		}
		connect();

		int qNum = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < qNum; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sV = Integer.parseInt(st.nextToken());
			int eV = Integer.parseInt(st.nextToken());

			if(find(sV) != find(eV)) {
				sb.append("-1\n");
				continue;
			}
			
			int lcaNum = lca(sV, eV);
			sb.append(weiAry[lcaNum] + " " + nVal[lcaNum] + "\n");		
		}
		System.out.print(sb);
		br.close();
	}
	
	public static void kruskal() {

		int index = V + 1;
		
		while(!ary.isEmpty()) {
			
			kruNode nowNode = ary.poll();
			int sV = nowNode.sV;
			int eV = nowNode.eV;
			int wei = nowNode.wei;
			
			if(find(sV) == find(eV)) continue;
				
			nVal[index] = nVal[find(sV)] + nVal[find(eV)]; 
			weiAry[index] = wei;
			tree[index].add(find(sV));
			tree[index].add(find(eV));

			
			union(index, sV);
			union(index, eV);
			index++;

		}
			
	}
	
	public static void dfs(int cur, int prev) {
		visited[cur] = true;
		
		for(int next: tree[cur]) {
			if(next == prev) continue;
			
			parents[next][1]= cur;
			depth[next] = depth[cur] + 1;
			dfs(next, cur);
		}
		
	}
	
	public static void connect() {
		
		for(int i = 2; i < 22; i++) {
			for(int cur = 1; cur <= V + E; cur++) {
				if(parents[parents[cur][i-1]][i-1] == 0) continue;
				parents[cur][i]= parents[parents[cur][i-1]][i-1];
				
			}
		}
		
	}
	
	public static int lca(int n1, int n2) {
		
		if(depth[n1] > depth[n2]) {
			int tmp = n1;
			n1 = n2;
			n2 = tmp;
			
		}
		
		for(int i = 21; i > 0 ; i--) {
			int jump = 1 << (i-1);
			if(depth[n2] - depth[n1] >= jump) {

				n2 = parents[n2][i];
				
			}
		}
		
		if(n1 == n2) return n2;
		
		for(int i = 21; i > 0 ; i--) {
			if(parents[n1][i]== parents[n2][i]) continue;
			
			n1 = parents[n1][i];
			n2 = parents[n2][i];
		}
	
		return parents[n1][1];
	}
	

	
	public static int find(int v1) {
		if(parent[v1] == v1) return v1;
		else return parent[v1] = find(parent[v1]);
	}
	
	public static void union(int v1, int v2) {
		
		int v1Root = find(v1);
		int v2Root = find(v2);
		
		if(v1Root == v2Root) return;

		if(v1Root < v2Root) parent[v1Root] = v2Root;
		else parent[v2Root] = v1Root;
		
	}
	
	static class Node{
		int num, weight;

		public Node(int num, int weight) {
			super();
			this.num = num;
			this.weight = weight;
		}
		
	}
	
	static class kruNode implements Comparable<kruNode>{
		
		int sV;
		int eV;
		int wei;
		
		public kruNode(int sV, int eV, int wei) {
			super();
			this.sV = sV;
			this.eV = eV;
			this.wei = wei;
		}
		
		@Override
		public int compareTo(kruNode o) {
			return Integer.compare(this.wei, o.wei);
		}
		
		
	}
}
