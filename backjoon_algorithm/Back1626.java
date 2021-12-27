package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back1626 {

	public static int[] parents;
	public static int[][] parent;
	public static costNode[][] cost;
	public static ArrayList<mstNode>[] tree;
	public static PriorityQueue<Node> pq;
	public static ArrayList<Node> unUsedEdge;
	public static int V, E, count;
	public static boolean[] visited;
	public static int[] depth;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb  = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V + 1];
		visited = new boolean[V + 1];
		unUsedEdge = new ArrayList<>();
		parent = new int[V+1][22];
		cost = new costNode[V+1][22];
		depth = new int[V+1];
		tree = new ArrayList[V + 1];
		
		for(int i = 1; i <= V ; i++) {
			parents[i] = i;
		}
		
		for(int i = 0 ; i <= V; i++) {
			for(int j = 0 ; j < 22; j++) {
				cost[i][j] = new costNode(-1, -1);
			}
		}

		for(int i = 1; i <= V; i++) {
			tree[i] = new ArrayList<>();
		}
		
		pq = new PriorityQueue<>();
		
		for(int i = 0 ; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sV = Integer.parseInt(st.nextToken());
			int eV = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			pq.add(new Node(sV, eV, wei));
		}
		count = 0;
		int firstVal = kruskal();
		for(int i = 2 ; i <= V ; i++) {
			if(count != V-1) {
				sb.append("-1\n");
				System.out.print(sb);
				br.close();
				return;
			}		
		}
		
		Arrays.fill(visited, false);
		
		dfs(new mstNode(1,0), 0);
		connect(V);
		
		int num = Integer.MAX_VALUE;
		int tmp = 0;
		for(Node edge : unUsedEdge) {		
			tmp = lca(edge.sV, edge.eV, edge.wei);
			if(tmp == -1) continue;
			num = Math.min(num, edge.wei - tmp);
		}
		
		if(num == Integer.MAX_VALUE) 
			sb.append("-1\n");		
		else 
			sb.append(firstVal + num + "\n");
			
		System.out.print(sb);
		br.close();
		
	}
	
	
	public static void dfs(mstNode cur, int dep) {
		visited[cur.num] = true;
		depth[cur.num] = dep;
		
		for(mstNode next: tree[cur.num]) {
			if(visited[next.num]) continue;
			
			parent[next.num][1]= cur.num;
			cost[next.num][1].first = next.weight;
			dfs(next, dep+1);
		}
		
	}
	
	public static void connect(int N) {
		
		for(int i = 2; i < 22; i++) {
			for(int cur = 1; cur <= N; cur++) {
				if(parent[parent[cur][i-1]][i-1]== 0) continue;
				parent[cur][i]= parent[parent[cur][i-1]][i-1];
				int firstNum1 = cost[cur][i-1].first;
				int firstNum2 = cost[parent[cur][i-1]][i-1].first;
				int secondNum1 = cost[cur][i-1].second;
				int secondNum2 = cost[parent[cur][i-1]][i-1].second;
				
				if(firstNum1 > firstNum2) {
					cost[cur][i].first = firstNum1;
					if(firstNum2 > secondNum1) {
						cost[cur][i].second = firstNum2;
					}
					else {
						cost[cur][i].second = secondNum1;
					}
					
				}
				else if(firstNum1 < firstNum2) {
					cost[cur][i].first = firstNum2;
					if(firstNum1 > secondNum2) {
						cost[cur][i].second = firstNum1;
					}
					else {
						cost[cur][i].second = secondNum2;
					}
				}
				else {
					cost[cur][i].first = firstNum1;
					cost[cur][i].second = secondNum1 > secondNum2 ? secondNum1 : secondNum2;
				}
			}
		}
		
	}
	
	
	public static int lca(int n1, int n2, int dist) {
		
		int max = -1;
		
		if(depth[n1] > depth[n2]) {
			int tmp = n1;
			n1 = n2;
			n2 = tmp;
		}
		
		for(int i = 21; i > 0 ; i--) {
			int jump = 1 << i-1 ;
			if(depth[n2] - depth[n1] >= jump) {
				if(cost[n2][i].first == dist) {
					if(cost[n2][i].second == dist) {
						n2 = parent[n2][i];
						continue;
					}
					max = Math.max(max, cost[n2][i].second);
				}
				else {
					max = Math.max(max, cost[n2][i].first);
				}
				n2 = parent[n2][i];	
			}
		}
		
		if(n1 == n2) return max;
		
		for(int i = 21 ; i > 0 ; i--) {
			if(parent[n1][i] == parent[n2][i]) continue;
			
			int fn1 = cost[n1][i].first;
			int sn1 = cost[n1][i].second;
			int fn2 = cost[n2][i].first;
			int sn2 = cost[n2][i].second;
			max = Math.max(max, calcNum( fn1, sn1, fn2, sn2, dist));
			
			n1 = parent[n1][i];
			n2 = parent[n2][i];			
			
		}
		
		max = Math.max(max, calcNum(cost[n1][1].first, cost[n1][1].second, cost[n2][1].first, cost[n2][1].second, dist));		
		
		return max;
		
	}

	public static int calcNum(int fn1, int sn1, int fn2, int sn2, int dist) {
		
		int result = -1;
		
		int[] tmp = new int[4];
		
		tmp[0] = fn1;
		tmp[1] = sn1;
		tmp[2] = fn2;
		tmp[3] = sn2;
		
		for(int i = 0; i < 4 ; i++) {
			if(tmp[i] < dist) {
				result = Math.max(result, tmp[i]);
			}
		}
		
		return result;
	}
	
	public static int kruskal() {
		
		int resultSum = 0;
		count = 0;
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cursV = curNode.sV;
			int cureV = curNode.eV;
			int curWei = curNode.wei;
			
			int rootsV = find(cursV);
			int rooteV = find(cureV);
			
			if(rootsV == rooteV) {
				unUsedEdge.add(curNode);
				continue;
			}
			
			union(cursV, cureV);
			tree[cursV].add(new mstNode(cureV, curWei));
			tree[cureV].add(new mstNode(cursV, curWei));
			count++;
			resultSum += curWei;		
			if(count == V-1) break;
		}
		
		while(!pq.isEmpty()) {
			unUsedEdge.add(pq.poll());
		}
		
		return resultSum;
		
	}	
	
	
	public static int find(int v) {
		if(v == parents[v]) return v;
		else return parents[v] = find(parents[v]);
		
	}
	
	
	public static void union(int v1, int v2) {
		int v1Root = find(v1);
		int v2Root = find(v2);
		
		if(v1Root != v2Root) {
			
			if(v1Root < v2Root) parents[v2Root] = v1Root;
			else parents[v1Root] = v2Root;
	
		}
		
	}
	
	public static class costNode{
		int first;
		int second;
		
		public costNode(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
		
		
	}
	
	public static class mstNode{
		int num;
		int weight;
		
		public mstNode(int num, int weight) {
			super();
			this.num = num;
			this.weight = weight;
		}
		
	}
	
	
	public static class Node implements Comparable<Node>{
		
		int sV;
		int eV;
		int wei;
		
		public Node(int sV, int eV, int wei) {
			this.sV = sV;
			this.eV = eV;
			this.wei = wei;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.wei, o.wei);
		}
	
	}
}
