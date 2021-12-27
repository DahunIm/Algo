package backjoon_dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back1238 {

	public static int N, M, X;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		int dist[] = new int[N+1];
		ArrayList<Node>[] graph = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sV = Integer.parseInt(st.nextToken());
			int eV = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			graph[sV].add(new Node(eV, wei));
		}
		
		long max = 0;
		for(int i = 1; i <= N; i++) {
			
			max = Math.max(max, (dijkstra(graph, i, X) + dijkstra(graph, X, i)));
			
		}
		StringBuilder sb = new StringBuilder();
		sb.append(max + "\n");
		System.out.print(sb);
		br.close();
	}
	
	public static long dijkstra(ArrayList<Node>[] graph, int start, int end) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		int[] dist = new int[N+1];
		boolean visited[] = new boolean[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			
			Node cur = pq.poll();
			int nowX = cur.sX;
			int wei = cur.wei;
			
			if(nowX == end) return wei;
			if(visited[nowX] == true) continue;
			
			visited[nowX] = true;
			
			for(Node next : graph[nowX]) {
				if(dist[next.sX] > dist[nowX] + next.wei) {
					dist[next.sX] = dist[nowX] + next.wei;
					pq.add(new Node(next.sX, dist[next.sX]));
				}
			}			
		}
		return 0;	
	}
	
	public static class Node implements Comparable<Node>{
		
		int sX;
		int wei;
		
		public Node(int sX, int wei) {
			this.sX = sX;
			this.wei = wei;
		}
		
		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.wei, n.wei);
		}
	}

}
