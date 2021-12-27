package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back1956 {

	public static int[][] graph;
	public static int V, E;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new int[V][V];
		for(int a[] : graph) Arrays.fill(a, Integer.MAX_VALUE);
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s_V = Integer.parseInt(st.nextToken());
			int e_V = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			graph[s_V-1][e_V-1] = dis;
			
		}
		
		
		int result = warshall(0);
		
		
		StringBuilder sb = new StringBuilder();
		
		if(result == Integer.MAX_VALUE) sb.append("-1\n");
		else sb.append(result + "\n");
		
		System.out.print(sb);
	}
	
	public static int warshall(int start) {

		int min = Integer.MAX_VALUE;

		for(int joong = 0; joong < V; joong++) {
			for(int i = 0; i < V; i++) {
				for(int j = 0; j < V; j++) {
					if(graph[i][joong] == Integer.MAX_VALUE || graph[joong][j] == Integer.MAX_VALUE) continue;
					if(graph[i][j] > graph[i][joong] + graph[joong][j]) graph[i][j] = graph[i][joong] + graph[joong][j];				
				}
			}		
		}
		
		for(int i = 0; i < V; i++) {
			min = Math.min(min, graph[i][i]);
		}

		
		return min;
	}

}
