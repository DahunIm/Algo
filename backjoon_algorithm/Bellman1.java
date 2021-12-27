package backjoon_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bellman1 {

	public static ArrayList<Edge>[] graph;
	public static long[] dist;
	public static StringBuilder sb;
	static int INF = 987654321;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		Boolean result = null;
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		dist = new long[N + 1];
		Arrays.fill(dist, INF);
		
		graph = new ArrayList[N + 1];
		
		for(int i = 1; i <= N ; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 1 ; i <= M; i++) {
			
			int s_V = sc.nextInt();
			int e_V = sc.nextInt();
			int weigh = sc.nextInt();
			
			graph[s_V].add(new Edge(e_V, weigh));
			
		}
		
		result = Bellmanford(1);
		
		if(result) {
			for(int i = 2; i <= N; i++) {
				if(dist[i] == INF) sb.append("-1\n");
				else sb.append(dist[i] + "\n");
			}
		}
		
		System.out.print(sb);
		
		sc.close();
	}

	public static Boolean Bellmanford(int start) {
		
		Boolean check = false;
		
		dist[start] = 0;
		
		for(int j = 1; j < dist.length -1; j++) {
			for(int i = 1; i < dist.length; i++) {
				if(dist[i] == INF) continue;
				for(Edge tmp_V : graph[i]) {
					if( dist[tmp_V.dest_V] > dist[i] + tmp_V.weight) {
						dist[tmp_V.dest_V] = dist[i] + tmp_V.weight;
					}
				}
			}
		}
		
		for(int i = 1; i < dist.length; i++) {
			if(dist[i] == INF) continue;
			for(Edge tmp_V : graph[i]) {
				if( dist[tmp_V.dest_V] > dist[i] + tmp_V.weight) {
					check = true;
				}
			}
		}
		
		if(check) {
			sb.append("-1\n");
			return false;
		}
		
		return true;
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
