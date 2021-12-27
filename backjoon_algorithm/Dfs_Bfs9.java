package backjoon_algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dfs_Bfs9 {

	public static BufferedWriter bw;
	public static int[][] chess;
	public static int[] x_go = { -2, -1, 1, 2, 2, 1, -1, -2 };
	public static int[] y_go = { 1,  2,  2, 1, -1,-2,-2, -1 };
	public static void main(String[] args) throws IOException {

		Scanner sc= new Scanner(System.in);
		
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> queue = new LinkedList<>();
		int case_num = sc.nextInt();
		
		for(int i = 0; i < case_num ; i++) {
			queue.clear();
			int size = sc.nextInt();
			int start_x = sc.nextInt();
			int start_y = sc.nextInt();
			int end_x = sc.nextInt();
			int end_y = sc.nextInt();
			
			chess = new int[size][size];
			Boolean[][] visited = new Boolean[size][size];
			for(Boolean a[]:visited) Arrays.fill(a, false);
			
			bfs(queue, visited, start_x, start_y, end_x, end_y);
			
		}
		
		bw.flush();
		bw.close();
		sc.close();
	}

	
	public static void bfs(Queue<Integer> queue, Boolean[][] visited, int s_x, int s_y, int e_x, int e_y) throws IOException {
		
		queue.add(s_x);
		queue.add(s_y);
		
		chess[s_x][s_y] = 1;
		visited[s_x][s_y] = true;
		
		while(!queue.isEmpty()) {
			
			int loc_x = queue.poll();
			int loc_y = queue.poll();
			
			if(loc_x == e_x && loc_y == e_y) {
				bw.write(chess[e_x][e_y] - 1+ "\n");
				return;
			}
			
			for(int i = 0; i < 8; i++) {
				
				int nx = loc_x + x_go[i];
				int ny = loc_y + y_go[i];
				
				if(nx >= 0 && nx < chess.length && ny >= 0 && ny < chess.length) {
					
					if(chess[nx][ny] == 0 && !visited[nx][ny] ) {
						chess[nx][ny] = chess[loc_x][loc_y] + 1;
						queue.add(nx);
						queue.add(ny);
						visited[nx][ny] = true;
					}
					
				}
				
			}	
		}
	}
	
}
