package backjoon_algorithm;

// 몇번 더 보자!!
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra3 {

	public static BufferedWriter bw;
	public static StringTokenizer st;
	public static ArrayList<Edge>[] graph;
	public static Boolean[] visited;
	public static int[] dist;
	public static int gyo_V1, gyo_V2;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int case_num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < case_num ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken()); 
			int E = Integer.parseInt(st.nextToken());
			int dest_num = Integer.parseInt(st.nextToken());
			ArrayList<Integer> mok_ary = new ArrayList<>();
			
			graph = new ArrayList[V + 1];
			dist = new int[V + 1];
			visited = new Boolean[V + 1];
			for(int j = 1; j <= V; j++) {
				graph[j] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			int start_V = Integer.parseInt(st.nextToken()); 
			gyo_V1 = Integer.parseInt(st.nextToken());
			gyo_V2 = Integer.parseInt(st.nextToken());
			
			for(int k = 1; k <= E; k++) {
				st = new StringTokenizer(br.readLine(), " ");
				int V1 = Integer.parseInt(st.nextToken()); 
				int V2 = Integer.parseInt(st.nextToken());
				int weigh = Integer.parseInt(st.nextToken());
				
				graph[V1].add(new Edge(V2, weigh));
				graph[V2].add(new Edge(V1, weigh));
			}
			
			for(int z = 1; z <= dest_num; z++) {
				mok_ary.add(Integer.parseInt(br.readLine()));
			}
			Collections.sort(mok_ary);
			for(int tmp_dest : mok_ary) {
				int result_1 = dijkstra(start_V, gyo_V1) + dijkstra(gyo_V1, gyo_V2) + dijkstra(gyo_V2, tmp_dest);
				int result_2 = dijkstra(start_V, gyo_V2) + dijkstra(gyo_V2, gyo_V1) + dijkstra(gyo_V1, tmp_dest);
				if(Math.min(result_1, result_2) == dijkstra(start_V, tmp_dest)) bw.write(tmp_dest + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int dijkstra(int start, int end) {
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.add(new Edge(start, 0));
		dist[start] = 0;
		visited[start] = true;
		
		while(!pq.isEmpty()) {
			
			Edge current = pq.poll();
			int dest = current.dest;
			visited[dest] = true;
			
			for(Edge e : graph[dest]) {
				if(visited[e.dest] == false && dist[e.dest] > dist[dest] + e.weight) {
					dist[e.dest] = dist[dest] + e.weight;
					pq.add(new Edge(e.dest, dist[e.dest]));
				}
			}
		}
		return dist[end];
	}
	
	public static class Edge implements Comparable<Edge>{
		
		int dest;
		int weight;
		
		public Edge(int dest, int weight) {
			
			this.dest = dest;
			this.weight = weight;
			
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

}
