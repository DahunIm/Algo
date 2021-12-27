package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back1396 {

	public static int V, E;
	public static int[] parent;
	public static boolean[] visited;
	public static int[] depth;
	public static Node[][] parents;
	public static ArrayList<Node>[] tree;
	public static PriorityQueue<kruNode> ary;
	public static ArrayList<kruNode> mstNode;
	public static ArrayList<Node>[] pathList;
	public static int[] nVal;
	public static int lcaNum;
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken()); 
		E = Integer.parseInt(st.nextToken()); 
		parent = new int[V + 1];
		tree = new ArrayList[V + 1];
		parents = new Node[V+1][22];
		depth = new int[V + 1];
		visited = new boolean[V + 1];
		ary = new PriorityQueue<>();
		pathList = new ArrayList[V + 1];
		mstNode = new ArrayList<>();
		nVal = new int[V + E + 1];
		
		for(int i = 1; i <= V+ E; i++) {
			nVal[i] = 1;
		}
		
		for(int i =1; i <= V; i++) {
			tree[i] = new ArrayList<>();
			pathList[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i <= V; i++) {
			for(int j = 0 ; j < 22; j++) {
				parents[i][j] = new Node(0, 0);
			}
		}
		
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
		}	
		
		for(int i = 0 ; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sV = Integer.parseInt(st.nextToken());
			int eV = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			ary.add(new kruNode(sV, eV, wei));
		}
	
		kruskal();
		setConnected();
		
		int size = mstNode.size();
		for(int i = 0 ; i < size; i++) {
			kruNode tmpNode = mstNode.get(i);
			path(tmpNode.sV, tmpNode.eV, tmpNode.wei);
		}
		
		for(int i = 1; i <= V; i++) {
			if(!visited[i]) dfs(new Node(i, 0), 0);
		}
		connect(V);
		
		int qNum = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < qNum; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sV = Integer.parseInt(st.nextToken());
			int eV = Integer.parseInt(st.nextToken());
			
			int result = -1;
			if(parent[sV] == parent[eV]) result = lca(new Node(sV, 0),new Node(eV, 0));
			sb.append(result + " ");
			if(result != -1 ) sb.append(checkPath(sV, result));
			
			sb.append("\n");
		}
		
		System.out.print(sb);
		br.close();
		
	}
	
	public static int checkPath(int sV, int wei) {
		
		int count = 1;
		int root = parent[sV];
		
		for(Node now : pathList[root]) {
			if(now.weight > wei) break;
			count++;
		}
		
		return count;
		
	}
	
	public static void dfs(Node cur, int dep) {
		visited[cur.num] = true;
		depth[cur.num] = dep;
		
		for(Node next: tree[cur.num]) {
			if(visited[next.num]) continue;
			
			parents[next.num][1].num = cur.num;
			parents[next.num][1].weight = next.weight;
			dfs(next, dep+1);
		}
		
	}
	
	public static void connect(int N) {
		
		for(int i = 2; i < 22; i++) {
			for(int cur = 1; cur <= N; cur++) {
				if(parents[parents[cur][i-1].num][i-1].num == 0) continue;
				parents[cur][i].num = parents[parents[cur][i-1].num][i-1].num;
				parents[cur][i].weight = Math.max(parents[cur][i-1].weight, parents[parents[cur][i-1].num][i-1].weight);
			
			}
		}
		
	}
	
	public static int lca(Node n1, Node n2) {
		
		int max = -1;
		
		if(depth[n1.num] > depth[n2.num]) {
			Node tmp = n1;
			n1 = n2;
			n2 = tmp;
			
		}
		
		for(int i = 21; i > 0 ; i--) {
			int jump = 1 << (i-1);
			if(depth[n2.num] - depth[n1.num] >= jump) {
				
				max = Math.max(max, parents[n2.num][i].weight);
				n2 = parents[n2.num][i];
				
			}
		}
		
		if(n1.num == n2.num) return max;
		
		for(int i = 21; i > 0 ; i--) {
			if(parents[n1.num][i].num == parents[n2.num][i].num) continue;
			
			max = Math.max(max, parents[n1.num][i].weight);
			max = Math.max(max, parents[n2.num][i].weight);
			n1 = parents[n1.num][i];
			n2 = parents[n2.num][i];
		}
		
		lcaNum = parents[n1.num][1].num;
		max = Math.max(max, parents[n1.num][1].weight);
		max = Math.max(max, parents[n2.num][1].weight);
	
		return max;
	}
	
	
	public static void setConnected() {
		
		for(int i = 1; i <= V; i++) {
			parent[i] = find(i);		
		}
	}
	
	public static void kruskal() {
		
		int count = 0;
		
		
		while(!ary.isEmpty()) {
			
			kruNode nowNode = ary.poll();
			int sV = nowNode.sV;
			int eV = nowNode.eV;
			int wei = nowNode.wei;
			
			if(union(sV, eV)) {
				
				tree[sV].add(new Node(eV, wei));
				tree[eV].add(new Node(sV, wei));
				mstNode.add(new kruNode(sV, eV, wei));
				count++;
			}
			
			else continue;
			
			if(count == V - 1) break;
			
		}
			
	}
	
	public static void path(int sV, int eV, int wei) {
		
		int tmpwei = wei;
		int root = find(sV);
		
		if(!pathList[sV].isEmpty()) {
			tmpwei = Math.max(pathList[root].get(pathList[root].size()-1).weight, tmpwei);
		}			
		pathList[root].add(new Node(eV, tmpwei));		
		
	}
	
	public static int find(int v1) {
		if(parent[v1] == v1) return v1;
		else return parent[v1] = find(parent[v1]);
	}
	
	public static boolean union(int v1, int v2) {
		
		int v1Root = find(v1);
		int v2Root = find(v2);
		
		if(v1Root == v2Root) return false;

		if(v1Root < v2Root) parent[v2Root] = v1Root;
		else parent[v1Root] = v2Root;
		
		return true;
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
