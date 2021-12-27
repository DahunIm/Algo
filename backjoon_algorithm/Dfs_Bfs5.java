package backjoon_algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dfs_Bfs5 {

	public static BufferedWriter bw;
	public static int[][] ary;
	public static int[] x_go = { 0, 0, 1, -1 };
	public static int[] y_go = { 1, -1, 0, 0 };
	public static int count, x , y, zeros;
	public static int[][] count_ary;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		y = sc.nextInt();
		x = sc.nextInt();
		ary = new int[x+1][y+1];
		Boolean[][] visited = new Boolean[x+1][y+1];
		count_ary = new int[x+1][y+1];
		Queue<Integer> queue = new LinkedList<>();
		
		for(Boolean a[]: visited) Arrays.fill(a, false);
		for(int tmp[]: ary) Arrays.fill(tmp, -1);
		
		count = 0;	
		zeros = 0;
		int tmp;
		for(int i = 1; i<= x; i++) {
			for(int j = 1; j <= y; j++) {
				tmp = sc.nextInt();
				ary[i][j] = tmp;
				if(tmp == 1) {
					count_ary[i][j] = 1;
					visited[i][j] = true;
					queue.add(i);
					queue.add(j);
				}
				else if(tmp == -1) {
					visited[i][j] = true;
					count_ary[i][j] = -1;
				}
				else zeros++;
			}
		}

		bfs(ary, visited, queue);
		
		int result = ary_check(x, y);
		if(result == 0) bw.write("-1\n");
		else bw.write(result -1 + "\n");
		bw.flush();
		bw.close();
		sc.close();
		
	}
	
	public static int ary_check(int x, int y) {
		int max = 0;
		for(int i = 1; i <= x; i++) {
			for(int j = 1; j <= y; j++) {
				if(count_ary[i][j] == 0) return 0;
				if(count_ary[i][j] > max) max = count_ary[i][j];
			}
		}
		
		return max;
	}
	
	public static void bfs(int[][] ary, Boolean[][] visited, Queue<Integer> queue) {
		
		while(queue.size() != 0) {
			
			int x_index = queue.poll();
			int y_index = queue.poll();
			
			if(zeros == 0) return;
			int i = 0;
			int tmp_check = q_check(ary,visited, x_index, y_index);
			String tmp = Integer.toString(tmp_check);
			if(tmp.length() < 4) {
				while(tmp.length() != 4) {
					String zeros = "0";
					tmp = zeros.concat(tmp);
				}
			}
			while(i < tmp.length()) {
				if(tmp.charAt(i) == '1') {
					visited[x_index + x_go[i]][y_index + y_go[i]] = true;
					queue.add(x_index + x_go[i]); 
					queue.add(y_index + y_go[i]);
					count_ary[x_index + x_go[i]][y_index + y_go[i]] = count_ary[x_index][y_index] + 1;
					zeros--;
				}
				
				i++;
				
			}
		}
	}
	public static int q_check(int[][] ary, Boolean[][] visited, int X, int Y) {
		
		int result = 0;
		if(ary[X-1][Y] == 0 && !visited[X-1][Y]) result += 1;
		if(X < x) {
			if(ary[X+1][Y] == 0 && !visited[X+1][Y]) result += 10;
		}
		if(ary[X][Y-1] == 0 && !visited[X][Y-1]) result += 100;
		if(Y < y) {
			if(ary[X][Y+1] == 0 && !visited[X][Y+1]) result += 1000;
		}
		
		return result;
	}
}
