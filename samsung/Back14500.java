package samsung;
 // DFS로 풀면 된대

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Back14500 {

	public static int[] x_go = { 1, 0, -1, 0 };
	public static int[] y_go = { 0, 1, 0, -1 };
	public static int[][] graph;
	public static int N, M;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < M ; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		
		for(int i = 0; i < N ; i++) {
			for( int j = 0; j < M ; j++) {
				max = Math.max(max, search(i, j));
			}
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static int search(int x, int y) {
		int result = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		queue.add(y);
		queue.add(1);
		queue.add(graph[x][y]);
		
		while(!queue.isEmpty()) {
			
			int n_x = queue.poll();
			int n_y = queue.poll();
			int now_count = queue.poll();
			int now_val = queue.poll();
			
			if(now_count == 4) {
				result = Math.max(result, now_val);
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				
				int nx = n_x + x_go[i];
				int ny = n_y + y_go[i];
				
				if(nx < N && nx >= 0 && ny >= 0 && ny < M ) {			
					queue.add(nx);
					queue.add(ny);
					queue.add(now_count + 1);	
					queue.add(now_val + graph[nx][ny]);
				}			
			}
		}
		
		result = Math.max(result, square(x, y));

		return result;
	}
	
	public static int square(int x, int y) {
		int result = 0;
		
		if(x < N-1 && y < M-1) {
			for(int i = x; i < x+2; i++) {
				for(int j = y; j < y+2; j++) {
					result += graph[i][j];
				}
			}
		}
		return result;
	}

}
