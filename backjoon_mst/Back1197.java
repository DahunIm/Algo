package backjoon_mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back1197 {

	public static PriorityQueue<Node> minHeap = new PriorityQueue<>();
	public static int[] parents;
	public static int result;
	public static int V, E;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parents = new int[V + 1];
		
		for(int i = 0 ; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sV = Integer.parseInt(st.nextToken());
			int eV = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			
			minHeap.add(new Node(sV, eV, wei));			
		}
		result = 0;
		for(int i = 1 ; i <= V; i++) {
			parents[i] = i;
		}
		
		kruskal();
		StringBuilder sb = new StringBuilder();
		
		sb.append(result);
		System.out.println(result);
		br.close();
	}
	
	public static void kruskal() {
		
		for(int i = 0; i < E; i++) {
			
			Node curNode = minHeap.poll();
			int sV = curNode.sV;
			int eV = curNode.eV;
			int wei = curNode.wei;
			
			int rootSV = find(sV);
			int rootEV = find(eV);
			
			if(rootSV == rootEV) continue;
			
			union(sV, eV);
			result += wei;
			
		}
		
		
	}
	
	public static int find(int v1) {
		
		if(parents[v1] == v1) return v1;
		else {
			return parents[v1] = find(parents[v1]);
		}
		
	}
	
	public static void union(int v1, int v2) {
		
		int v1Root = find(v1);
		int v2Root = find(v2);
		
		if(v1Root != v2Root) {
			
			if(v1Root < v2Root) parents[v1Root] = v2Root;
			else parents[v2Root] = v1Root;
			
		}
	}
	
	
	
	
	static class Node implements Comparable<Node>{
		int sV ,eV, wei;

		public Node(int sV, int eV, int wei) {
			this.sV = sV;
			this.eV = eV;
			this.wei = wei;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.wei, o.wei);
		}
		
	}

}
