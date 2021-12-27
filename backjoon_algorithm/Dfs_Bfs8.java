package backjoon_algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dfs_Bfs8 {
	
	public static int[][] cnt_ary;
	public static int X, Y, break_cnt;
	public static BufferedWriter bw;
	public static int[] x_go = { 0, 0, 1, -1};
	public static int[] y_go = { 1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		X = sc.nextInt();
		Y = sc.nextInt();
		int[][][] ary = new int[X+1][Y+1][2];
		cnt_ary = new int[X+1][Y+1];
		Queue<Integer> queue = new LinkedList<>();
		
		for(int k = 0; k <= Y; k++) {
			cnt_ary[0][k] = -1;
			ary[0][k][0] = -1;
			ary[0][k][1] = -1;
		}
		
		for(int i = 1; i <= X; i++ ) {
			cnt_ary[i][0] = -1;
			ary[i][0][0] = -1;
			ary[i][0][1] = -1;
			String tmp = sc.next();
			for(int j = 1; j <= tmp.length(); j++) {
				int tmp_num = Character.getNumericValue(tmp.charAt(j - 1));
				cnt_ary[i][j] = tmp_num;
			}
		}

		queue.add(1);
		queue.add(1);
		queue.add(0);
		
		bfs(ary, queue, 1, 1);
		
		bw.flush();
		bw.close();
		sc.close();
		
	}
	
	public static void bfs(int[][][] ary, Queue<Integer> queue, int x, int y) throws IOException {
		
		ary[1][1][0] = 1; 
		while(queue.size() != 0) {
			
			int x_index = queue.poll();
			int y_index = queue.poll();
			int break_num = queue.poll();
			
			if(x_index == X && y_index == Y) {
				bw.write(ary[x_index][y_index][break_num] + "\n");
				return;
			}
			
			for(int k = 0; k < 4; k++) {
				
				int nx = x_index + x_go[k];
				int ny = y_index + y_go[k];
				
				if(nx >= 1 && ny <= Y && nx <= X && ny >= 1) {
					
					if(cnt_ary[nx][ny] == 1 && break_num == 0 ) {
						ary[nx][ny][break_num + 1] = ary[x_index][y_index][break_num] + 1;
						queue.add(nx);
						queue.add(ny);
						queue.add(break_num + 1);
						
					}
					
					else if(cnt_ary[nx][ny] == 0 && ary[nx][ny][break_num] == 0){
						
						ary[nx][ny][break_num] = ary[x_index][y_index][break_num] + 1;
						queue.add(nx);
						queue.add(ny);
						queue.add(break_num);
					
					}
					
				
				}		
			}
		}
		bw.write("-1\n");
	}
}

