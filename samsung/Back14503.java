package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back14503 {

	public static int[][] graph;
	public static int[] x_go = {-1, 0 , 1, 0};
	public static int[] y_go = {0, 1, 0, -1};
	public static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int s_x = Integer.parseInt(st.nextToken());
		int s_y = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ;j++) {
				int a = Integer.parseInt(st.nextToken());
				if( a == 1) a++;
				graph[i][j] = a;
			}
		}
		
		bw.write(calc(s_x, s_y, dir , 1) + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static int calc(int s_x, int s_y, int dir, int s_count) {
		
		int result = 0;
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(s_x);
		queue.add(s_y);
		queue.add(dir);
		queue.add(s_count);
		graph[s_x][s_y] = 1;

		while(!queue.isEmpty()) {
			
			int x = queue.poll();
			int y = queue.poll();
			int dir_index = queue.poll();
			int count = queue.poll();
			int val = 0;
			int check = 1;
			
			while(val < 4) {
				int next_index = (dir_index - (val + 1) + 4) % 4;
				int nx = x + x_go[next_index] ;
				int ny = y + y_go[next_index];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(graph[nx][ny] == 0) {
						graph[nx][ny] = 1;
						count++;
						queue.add(nx);
						queue.add(ny);
						queue.add(next_index);
						queue.add(count);
						check = 0;
						break;
					}
				}				
				val++;
			}
			if( check == 1 ) {
				int next_index = ((dir_index - 2) + 4) % 4;
				int nx = x + x_go[next_index];
				int ny = y + y_go[next_index];
				if(graph[nx][ny] == 2) {
					result = count;
					break;
				}
				queue.add(nx);
				queue.add(ny);
				queue.add(dir_index);
				queue.add(count);
			}
			
			
		}
		
		return result;
		
	}
/*
	public class Edge implements Comparable<Edge>{
		
		int x;
		int y;
		int dir;
		int count;
		
		public Edge(int x, int y, int dir, int count) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.count = count;
		}
		
		@Override
		public static int CompareTo(Edge o) {
			return 
		}
	}
	*/
}
