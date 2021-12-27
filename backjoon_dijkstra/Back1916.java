package backjoon_dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back1916 {

	public static boolean[] visited;
	public static long[] dist;
	public static ArrayList<Node>[] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		dist = new long[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		graph = new ArrayList[N + 1];
		for(int i = 0 ; i <= N ; i++) {
			graph[i] = new ArrayList<Node>();	
		}
		
		for(int i = 0 ; i < M ; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int sV = Integer.parseInt(st.nextToken());
			int eV = Integer.parseInt(st.nextToken());
			long cost = Integer.parseInt(st.nextToken());
			
			graph[sV].add(new Node(eV, cost));
		
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		sb.append(dijkstra(start, end));
		
		System.out.println(sb);
		br.close();
	}
	
	public static long dijkstra(int start, int end) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>(); 
		pq.add(new Node(start , 0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.eV;
			
			if(cur == end) break;
			if(visited[cur] == true) continue;
			
			visited[cur] = true;
			
			for(Node now : graph[cur]) {
				if(dist[now.eV] > dist[cur] + now.weigh) {
					dist[now.eV] = dist[cur] + now.weigh;
					pq.add(new Node(now.eV, dist[now.eV]));
				}
			}
			
		}
		
		return dist[end];
	}

	
	public static class Node implements Comparable<Node>{
		
		int eV;
		long weigh;
		
		public Node(int eV, long weigh) {
			this.eV = eV;
			this.weigh = weigh;
		}
		
		
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.weigh, o.weigh);
		}
		
	}
}
