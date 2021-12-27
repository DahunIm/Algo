package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back5719 {
	
	public static ArrayList<Node>[] graph;
	public static ArrayList<Integer>[] nodePath;
	public static boolean[][] check; 
	public static int[] path;
	public static int[] dist;
	public static int N, M;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0) break;
			
			graph = new ArrayList[N];
			dist = new int[N];
			nodePath = new ArrayList[N];
			check = new boolean[N][N];
			
			for(int i = 0 ; i < N ; i++) {
				graph[i] = new ArrayList<>();
				nodePath[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine()," ");
			int startV = Integer.parseInt(st.nextToken());
			int endV = Integer.parseInt(st.nextToken());
			
			for(int i = 0 ; i < M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int sV = Integer.parseInt(st.nextToken());
				int eV = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				graph[sV].add(new Node(eV, weight));
			}

			dijkstra(startV, endV);
			back(startV, endV);
			dijkstra(startV, endV);
			
			if(dist[endV] == Integer.MAX_VALUE)  sb.append("-1\n");
			else sb.append(dist[endV] + "\n");
		}
		
		System.out.print(sb);
		br.close();
		
	}
	
	public static void dijkstra(int startV, int endV) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[startV] = 0;
		pq.add(new Node(startV, 0));
		
		while(!pq.isEmpty()) {
			
			Node curNode = pq.poll();
			int curV = curNode.V;
			int curwei = curNode.wei;
			
			if(dist[curV] < curwei) continue;
			
			for(Node next : graph[curV]) {
				if(!check[curV][next.V]) {
					if(dist[next.V] > curwei + next.wei) {
						dist[next.V] = curwei + next.wei;
						nodePath[next.V].clear();
						nodePath[next.V].add(curV);
						pq.add(new Node(next.V, dist[next.V]));
					}
					else if(dist[next.V] == curwei + next.wei) {
						nodePath[next.V].add(curV);
						
						
					}
				}
			}
		}	
	}
	
	public static void back(int sV, int V) {
		
		if(sV == V) return;
		
		for(int n : nodePath[V]) {
			
			if(!check[n][V]) {
				check[n][V] = true;
				back(sV, n);
			}
		}
	
	}
	
	public static class Node implements Comparable<Node>{
		
		int V;
		int wei;
		
		public Node(int V, int wei) {
			this.V = V;
			this.wei = wei;
		}
		
		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.wei, n.wei);
		}
		
	}
}