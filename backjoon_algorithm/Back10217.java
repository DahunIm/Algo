package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back10217 {

	public static ArrayList<Edge>[] graph;
	public static int[][] cost_ary;
	public static int N, M;
	public static int INF = 987654321;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		int case_num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < case_num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[N + 1];
			for(int z = 1; z <= N; z++) {
				graph[z] = new ArrayList<>();
			}

			cost_ary = new int[N + 1][M + 1];
			
			for(int j = 1; j <= K ; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int s_V = Integer.parseInt(st.nextToken());
				int e_V = Integer.parseInt(st.nextToken());
				int V_cost =Integer.parseInt(st.nextToken());
				int distan =Integer.parseInt(st.nextToken());
				graph[s_V].add(new Edge(e_V, V_cost, distan));
			}
			
			int result = dijkstra(1, N);

			if(result == INF) sb.append("Poor KCM\n");
			else sb.append(result + "\n");
			
		}
		System.out.print(sb);
		br.close();
	}
	
	public static int dijkstra(int start, int end) {
		
		for(int a[]: cost_ary) Arrays.fill(a, INF);
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
	
		pq.add(new Edge(start, 0, 0));
		cost_ary[1][0] = 0;
		
		while(!pq.isEmpty()) {
			
			Edge Current = pq.poll();
			int now_V = Current.dest_V;
			int now_cost = Current.cost;
			int now_weight = Current.weight;
			
			if(now_V == end) break;
	
			for(Edge tmp: graph[now_V]) {
				
				if( M < tmp.cost + now_cost ) continue;
				if(cost_ary[tmp.dest_V][tmp.cost + now_cost] <= now_weight + tmp.weight) continue;
				else if(cost_ary[tmp.dest_V][now_cost + tmp.cost] > now_weight + tmp.weight) {	
					cost_ary[tmp.dest_V][now_cost + tmp.cost] = now_weight + tmp.weight;
	                 for(int j = tmp.cost + now_cost; j <= M; j++){
	                       if(cost_ary[tmp.dest_V][j] > now_weight + tmp.weight) cost_ary[tmp.dest_V][j] = now_weight + tmp.weight;
	                  }
					pq.add(new Edge(tmp.dest_V, tmp.cost + now_cost, now_weight + tmp.weight));
				}
			}
			
		}
		
		int max = INF;
		for(int i = 0; i <= M; i++) {
			max = Math.min(max, cost_ary[N][i]);
		}
		
		return max;
		
	}

	
	public static class Edge implements Comparable<Edge>{
		
		int dest_V;
		int cost;
		int weight;
		
		public Edge(int dest_V, int cost, int weight){
			this.dest_V = dest_V;
			this.cost = cost;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			
			if(this.weight == o.weight) return Integer.compare(this.cost, o.cost);
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
}

