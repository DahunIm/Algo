package backjoon_algorithm;

// 잘보자 이것도 !!!!!!!

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra1 {

	public static ArrayList<edge_weigh>[] graph;
	public static Boolean[] visited;
	public static int[] dist;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int start_V = sc.nextInt();
		
		dist = new int[V + 1];
		visited = new Boolean[V + 1];
		
		graph = new ArrayList[V + 1];
		for(int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i <= V ; i++) {
			visited[i] = false;
		}
		Arrays.fill(dist, Integer.MAX_VALUE);

		
		for(int i = 1; i <= E; i++) {
			int s_V = sc.nextInt();
			int e_V = sc.nextInt();
			int weigh = sc.nextInt();
			graph[s_V].add(new edge_weigh(e_V, weigh));
		}
		dijkstra(start_V);
		
		for(int i = 1; i <= V; i++) {
			if(!visited[i]) sb.append("INF\n");
			else sb.append(dist[i] + "\n");
		}
		
		System.out.println(sb);
		sc.close();
	}

	public static void dijkstra(int start_V) {
		
		PriorityQueue<edge_weigh> pq = new PriorityQueue<>();
		dist[start_V] = 0;
		visited[start_V] = true;
		pq.add(new edge_weigh(start_V, 0));

		while(!pq.isEmpty()) {
			
			edge_weigh current = pq.poll();
			int dest = current.dest_V;
			visited[dest] = true;
			
			for(edge_weigh edge: graph[dest]) {
				if(!visited[edge.dest_V] && (dist[edge.dest_V] > dist[dest] + edge.weight)) {
					dist[edge.dest_V] = dist[dest] + edge.weight;
					pq.add(new edge_weigh(edge.dest_V, dist[edge.dest_V]));
				}	
			}
		}
	}
	
	public static class edge_weigh implements Comparable<edge_weigh> {
		int dest_V;
		int weight;
		
		public edge_weigh(int dest_V, int weight) {
			this.dest_V = dest_V;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(edge_weigh o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
