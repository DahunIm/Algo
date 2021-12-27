package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back1854 {

	public static ArrayList<Node>[] graph;
	public static ArrayList<Long>[] resultAry;
	public static int N, M, K, maxWei;
	public static boolean flag;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st= new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];	
		resultAry = new ArrayList[N + 1];

		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			resultAry[i] = new ArrayList<>();
		}

		maxWei = 0;
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sV = Integer.parseInt(st.nextToken());
			int eV = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[sV].add(new Node(eV, weight));
			maxWei = Math.max(maxWei, weight);
			
		}

		dijkstra(1);
		
		for(int i = 1 ; i <= N; i++ ) {
			if(resultAry[i].size() < K) sb.append("-1\n");
			else sb.append(resultAry[i].get(K-1) + "\n");
		}
		
		System.out.print(sb);
		br.close();
	}
	
	public static void dijkstra(int startV) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		long[] dist = new long[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.add(new Node(startV, 0));	
		
		while(!pq.isEmpty()) {
		
			Node cur = pq.poll();
			int curV = cur.V;
			long curWei = cur.wei;
			
			if(resultAry[curV].size() < K) resultAry[curV].add(curWei);
			else if(resultAry[curV].size() >= K) continue;

			for(Node next : graph[curV]) {
				if(resultAry[next.V].size() < K) 
					pq.add(new Node(next.V, curWei + next.wei));		
			}

		}
		
		
		
	}
	
	public static class Node implements Comparable<Node>{
		
		int V;
		long wei;
		
		public Node(int v, long wei) {
			V = v;
			this.wei = wei;
		}
		
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.wei, o.wei);
		}
		
		
		
	}
	

}
