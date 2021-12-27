package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra2 {

	public static ArrayList<Edge>[] graph;
	public static int[] dist;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int first = 0, second = 0, third = 0;
		int first_2 = 0, second_2 = 0, third_2 = 0;
		dist = new int[N + 1];

		graph = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <=E ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start_V = Integer.parseInt(st.nextToken());
			int end_V = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			graph[start_V].add(new Edge(end_V, distance));
			graph[end_V].add(new Edge(start_V, distance));
			
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int mid_V1 = Integer.parseInt(st.nextToken());
		int mid_V2 = Integer.parseInt(st.nextToken());
		
		dijkstra(1);
		if(dist[dist.length - 1] != Integer.MAX_VALUE) {
			first = dist[mid_V1];
			first_2 = dist[mid_V2];
			dijkstra(mid_V1);
			second = dist[mid_V2];
			dijkstra(mid_V2);
			third = dist[dist.length - 1];
			dijkstra(mid_V2);
			second_2 = dist[mid_V1];
			dijkstra(mid_V1);
			third_2 = dist[dist.length - 1];
		}
		
		int result = first + second + third;
		int result_2 = first_2 + second_2 + third_2;
		if(result == 0) sb.append("-1");
		else if(result >= result_2)sb.append(result_2);
		else sb.append(result);
		
		System.out.println(sb);

	}

	public static void dijkstra(int start) {
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		dist[start] = 0;
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()){
			
			Edge current = pq.poll();
			int dest = current.dest_V;
			
			for(Edge edge: graph[dest]) {
				if((dist[edge.dest_V] > dist[dest] + edge.weight)) {
					dist[edge.dest_V] = dist[dest] + edge.weight;
					pq.add(new Edge(edge.dest_V, dist[edge.dest_V]));
				}
			}			
			
		}
		
		
	}
	
	public static class Edge implements Comparable<Edge>{
		
		int dest_V;
		int weight;
		
		public Edge(int dest_V, int weight){
			this.dest_V = dest_V;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	
	}
}
