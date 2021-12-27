package backjoon_algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dfs_Bfs4 {
	
	public static int[][] cnt_ary;
	public static int X, Y;
	public static BufferedWriter bw;
	public static int[] x_go = { 0, 0, 1, -1};
	public static int[] y_go = { 1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		X = sc.nextInt();
		Y = sc.nextInt();
		int[][] ary = new int[X+1][Y+1];
		cnt_ary = new int[X+1][Y+1];
		Boolean[][] visited = new Boolean[X+1][Y+1];
		Queue<Integer> queue = new LinkedList<>();
		for(Boolean a[]:visited) Arrays.fill(a, false);
		
		for(int i = 1; i <= X; i++ ) {
			String tmp = sc.next();
			for(int j = 1; j <= tmp.length(); j++) {
				ary[i][j] = Character.getNumericValue(tmp.charAt(j - 1));
			}
		}

		queue.add(1);
		queue.add(1);
		
		cnt_ary[1][1] = 1;
		bfs(ary, visited, queue, 1, 1);
		
		bw.write(cnt_ary[X][Y] + "\n");
		bw.flush();
		bw.close();
		sc.close();
		
	}
	
	public static void bfs(int[][] ary, Boolean[][] visited, Queue<Integer> queue, int x, int y) {
		
		visited[x][y] = true;
		
		while(queue.size() != 0) {
			
			int x_index = queue.poll();
			int y_index = queue.poll();
			
			if(x_index == X && y_index == Y) return;
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
					cnt_ary[x_index + x_go[i]][y_index + y_go[i]] = cnt_ary[x_index][y_index] + 1;
				}
				
				i++;
				
			}
		}
	}
	public static int q_check(int[][] ary, Boolean[][] visited, int x, int y) {
		
		int result = 0;
		if(ary[x-1][y] == 1 && !visited[x-1][y]) result += 1;
		if(x < X) {
			if(ary[x+1][y] == 1 && !visited[x+1][y]) result += 10;
		}
		if(ary[x][y-1] == 1 && !visited[x][y-1]) result += 100;
		if(y < Y) {
			if(ary[x][y+1] == 1 && !visited[x][y+1]) result += 1000;
		}
		
		return result;
	}
}
