package backjoon_dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back1753 {

	public static boolean[] visited;
	public static int[] distance;
	public static ArrayList<Node>[] graph;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		

		graph = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		distance = new int[V+1];
		visited = new boolean[V+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(visited, false);
		distance[start] = 0;
		visited[0] = true;
		
		for(int i = 0 ; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s_v = Integer.parseInt(st.nextToken());
			int e_v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[s_v].add(new Node(w, e_v));
		}
		
		dijkstra(start);
		
		for(int i = 1; i <= V; i++) {
			if(distance[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(0, start));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int cur_V = cur.e_v;
			
			if(visited[cur_V] == true) continue;
			visited[cur_V] = true;
			
			for(Node tmp: graph[cur_V]) {
				if(distance[tmp.e_v] > distance[cur_V] + tmp.weight) {
					distance[tmp.e_v] = distance[cur_V] + tmp.weight;
					queue.add(new Node(distance[tmp.e_v], tmp.e_v));
				}
			}
		}
	}
	
	public static class Node implements Comparable<Node>{
		private int weight;
		private int e_v;
		
		public Node(int weight, int e_v){
			this.weight = weight;
			this.e_v = e_v;
		}
		
		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.weight, node.weight);
		}
	}

}
