package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Back4792 {

	public static Deque<Node> deq;
	public static int blueNumMax, blueNumMin, E;
	public static int parents[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
	
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			int V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken()); // 파란색 간선 갯수
			if(V == 0 && E == 0 && k == 0) break;
			
			deq = new ArrayDeque<>();
			parents = new int[V + 1];
			
			for(int i = 1; i <= V; i++) {
				parents[i] = i;
			}
					
			for(int i = 0 ; i < E; i++) {
				st = new StringTokenizer(br.readLine()," ");
				String col = st.nextToken();
				int sV = Integer.parseInt(st.nextToken());
				int eV = Integer.parseInt(st.nextToken());
				
				if(col.equals("B")) deq.addFirst(new Node(col, sV, eV));
				else if(col.equals("R")) deq.addLast(new Node(col, sV, eV));
			}
			
			flag = false;
			blueNumMax = 0;
			kruskal(flag);
			
			blueNumMin = 0;
			flag = true;
			
			for(int i = 1; i <= V; i++) {
				parents[i] = i;
			}
			
			kruskal(flag);
			
			if(k <= blueNumMax && k >= blueNumMin) sb.append("1\n");
			else sb.append("0\n");
			
		}
		
		System.out.print(sb);
		br.close();
	}
	
	public static void kruskal(boolean flag) {
		
		if(!flag) {
			for(int i = 0 ; i < E; i++) {
				
				Node cur = deq.removeFirst();
				deq.addLast(cur);
				
				int v1Root = find(cur.sV);
				int v2Root = find(cur.eV);
				
				if(v1Root == v2Root) continue;
				
				union(cur.sV, cur.eV);
				if(cur.color.equals("B")) blueNumMax++;
								
			}
		}
			
		else {
			for(int i = 0 ; i < E; i++) {
				
				Node cur = deq.removeLast();
				
				int v1Root = find(cur.sV);
				int v2Root = find(cur.eV);
				
				if(v1Root == v2Root) continue;
				
				union(cur.sV, cur.eV);
				if(cur.color.equals("B")) blueNumMin++;
				
				
			}
		}
		
	}
	
	
	
	
	public static int find(int v1) {
		
		if(parents[v1] == v1) return v1;
		
		else return parents[v1] = find(parents[v1]);
		
		
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
		int sV,eV;
		String color;

		public Node(String color, int sV, int eV) {
			this.color = color;
			this.sV = sV;
			this.eV = eV;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.sV, o.sV);
		}
		
	}

}
