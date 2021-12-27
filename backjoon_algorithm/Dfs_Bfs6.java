package backjoon_algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dfs_Bfs6 {

	public static BufferedWriter bw;
	public static int[][][] ary;
	public static int[] x_go = { 0, 0, 0, 0, 1, -1 };
	public static int[] y_go = { 0, 0, 1, -1, 0, 0 };
	public static int[] z_go = { -1, 1, 0, 0, 0, 0 };
	public static int count, x , y, z, zeros;
	public static int[][] count_ary;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		y = sc.nextInt();
		x = sc.nextInt();
		z = sc.nextInt();
		ary = new int[x+1][y+1][z+1];
		Boolean[][][] visited = new Boolean[x+1][y+1][z+1];
		count_ary = new int[x+1][y+1];
		Queue<Integer> queue = new LinkedList<>();
		
		for(Boolean a[][]: visited) {
			for(Boolean tmp_v[]: a) {
				Arrays.fill(tmp_v, false);
			}
		}
		for(int tmp[][]: ary) {
			for(int[] row: tmp) {
				Arrays.fill(row, -1);
			}
		}
		
		count = 0;	
		zeros = 0;
		int tmp;
		for(int k = 1; k <= z; k++) {
			for(int i = 1; i<= x; i++) {
				for(int j = 1; j <= y; j++) {
					tmp = sc.nextInt();
					ary[i][j][k] = tmp;
					if(tmp == 1) {
						count_ary[i][j] = 1;
						visited[i][j][k] = true;
						queue.add(i);
						queue.add(j);
						queue.add(k);
					}
					else if(tmp == -1) {
						visited[i][j][k] = true;
						count_ary[i][j] = -1;
					}
					else zeros++;
				}
			}
		}
		bfs(ary, visited, queue);
		
		int result = ary_check(x, y, z);
		if(result == 0) bw.write("-1\n");
		else bw.write(result -1 + "\n");
		bw.flush();
		bw.close();
		sc.close();
	}
	
	public static int ary_check(int x, int y, int z) {
		int max = 0;
		for(int k = 1; k <= z; k++) {
			for(int i = 1; i <= x; i++) {
				for(int j = 1; j <= y; j++) {
					if(ary[i][j][k] == 0) return 0;
					if(ary[i][j][k] > max) max = ary[i][j][k];
				}
			}
		}
		return max;
	}
	
	public static void bfs(int[][][] ary, Boolean[][][] visited, Queue<Integer> queue) {
		
		while(queue.size() != 0) {
			
			int x_index = queue.poll();
			int y_index = queue.poll();
			int z_index = queue.poll();
			
			if(zeros == 0) return;
			int i = 0;
			int tmp_check = q_check(ary,visited, x_index, y_index, z_index);
			String tmp = Integer.toString(tmp_check);
			if(tmp.length() < 6) {
				while(tmp.length() != 6) {
					String zero = "0";
					tmp = zero.concat(tmp);
				}
			}
			while(i < tmp.length()) {
				if(tmp.charAt(i) == '1') {
					visited[x_index + x_go[i]][y_index + y_go[i]][z_index + z_go[i]] = true;
					queue.add(x_index + x_go[i]); 
					queue.add(y_index + y_go[i]);
					queue.add(z_index + z_go[i]);
					ary[x_index + x_go[i]][y_index + y_go[i]][z_index + z_go[i]] = ary[x_index][y_index][z_index] + 1;
					zeros--;
				}
				
				i++;
				
			}
		}
	}
	public static int q_check(int[][][] ary, Boolean[][][] visited, int X, int Y, int Z) {
		
		int result = 0;
		if(ary[X-1][Y][Z] == 0 && !visited[X-1][Y][Z]) result += 1;
		if(X < x) {
			if(ary[X+1][Y][Z] == 0 && !visited[X+1][Y][Z]) result += 10;
		}
		if(ary[X][Y-1][Z] == 0 && !visited[X][Y-1][Z]) result += 100;
		if(Y < y) {
			if(ary[X][Y+1][Z] == 0 && !visited[X][Y+1][Z]) result += 1000;
		}
		if(Z < z) {
			if(ary[X][Y][Z+1] == 0 && !visited[X][Y][Z+1]) result += 10000;
		}
		if(ary[X][Y][Z-1] == 0 && !visited[X][Y][Z-1]) result += 100000;
		
		return result;
	}
}
