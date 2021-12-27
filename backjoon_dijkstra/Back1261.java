package backjoon_dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back1261{
	
	public static int[] x_go = {0, 1, 0, -1};
	public static int[] y_go = {1, 0 , -1 , 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine()," ");
		
		int M = Integer.parseInt(st.nextToken()); // Y
		int N = Integer.parseInt(st.nextToken()); // X
		int[][] graph = new int[N][M];
		
		for(int i = 0 ; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M ; j++) {
				graph[i][j] = Character.getNumericValue(input.charAt(j));
			}
		}
		
		sb.append(dijkstra(graph));
		System.out.println(sb);
		br.close();
	}
	
	
	public static int dijkstra(int[][] graph) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		int xLen = graph.length;
		int yLen = graph[0].length;
		boolean[][] visited = new boolean[xLen][yLen];
		int[][] dist = new int[xLen][yLen];
		for(int[] distTmp: dist) {
			Arrays.fill(distTmp, Integer.MAX_VALUE);
		}
		
		pq.add(new Node(0,0,0));
		
		while(!pq.isEmpty()) {
			
			Node cur = pq.poll();
			int curX = cur.x;
			int curY = cur.y;
			int curSize = cur.size;
			
			if(curX == xLen-1 && curY == yLen -1) return curSize;
			if(visited[curX][curY] == true) continue;
			
			visited[curX][curY] = true;
			
			for(int i = 0 ; i < 4; i++) {
				int nx = curX + x_go[i];
				int ny = curY + y_go[i];
				
				if(nx >= 0 && nx < xLen && ny >= 0 && ny < yLen && !visited[nx][ny]) {
					if(graph[nx][ny] == 0) {
						pq.add(new Node(nx, ny, cur.size));
					}
					else {
						pq.add(new Node(nx, ny, cur.size+1));
					}
				}
			}
			
			
			
		}
		return 0;
		
	}
	
	
	
	public static class Node implements Comparable<Node>{
		
		int x;
		int y;
		int size;
		
		public Node(int x, int y, int size){
			this.x = x;
			this.y = y;
			this.size = size;
		}
		
		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.size, n.size);
		}

	}
}