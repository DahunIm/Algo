package backjoon_algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Dfs_Bfs3 {

	public static int count;
	public static int count_out;
	public static int X, Y;
	public static BufferedWriter bw;

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int line_num = sc.nextInt();
		count_out = 2;
		for(int i = 0; i < line_num; i++) {
			count = 0;
			X = sc.nextInt();
			Y = sc.nextInt();
			int bae_num = sc.nextInt();
			
			int[] tmp = new int[2];
			int[][] ary = new int[X+1][Y+1];
			Boolean[][] visited = new Boolean[X+1][Y+1];
			for(Boolean a[]: visited) Arrays.fill(a, false);
			
			for(int j = 0; j < bae_num; j++) {
				
				int x_index = sc.nextInt();
				int y_index = sc.nextInt();
				
				ary[x_index + 1][y_index+1] = 1;
			}
			while(!ary_is_empty(ary)) {
				count++;
				tmp = search_index(ary);
				dfs(ary, visited, tmp[0], tmp[1]);
			}
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
		sc.close();
	}
	
	public static void dfs(int[][] ary, Boolean[][] visited, int x, int y) {
		
		if(visited[x][y] || ary[x][y] == 0 ) return;
		
		visited[x][y] = true;
		ary[x][y] = count_out;
		
		dfs(ary, visited, x-1, y);
		dfs(ary, visited, x, y-1);
		if(x < X) dfs(ary, visited, x+1, y);
		if(y < Y) dfs(ary, visited, x, y+1);
			
	}
	
	public static int[] search_index(int[][] ary) {
		
		int[] index_ary = new int[2];
		
		for(int i = 1; i <= X; i++) {
			for(int j = 1; j <= Y; j++) {
				if(ary[i][j] == 1) {
					index_ary[0] = i;
					index_ary[1] = j;
					return index_ary;
				}
			}
		}
		return index_ary;	
	}
	
	public static Boolean ary_is_empty(int[][] ary) {
		
		for(int i = 1; i <= X; i++) {
			for(int j = 1; j <= Y; j++) {
				if(ary[i][j] == 1) {
					return false;
				}
			}
		}
		
		return true;
	}
}