package backjoon_algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Dfs_Bfs2 {

	public static int count;
	public static int in_count;
	public static int size;
	public static BufferedWriter bw;

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		size = sc.nextInt();
		
		int[][] ary = new int[size+1][size+1];
		Boolean[][] visited = new Boolean[size + 1][size + 1];
		ArrayList<Integer> result = new ArrayList<>();
		int[] tmp = new int[2];
		
		for(int i = 0; i <=size; i++) {
			visited[0][i] = false;
			visited[i][0] = false;
		}
		
		for(int i = 1 ; i <= size; i++) {
			String s = sc.next();
			for(int j = 1; j <= size; j++) {
				ary[i][j] = Character.getNumericValue(s.charAt(j-1));
				visited[i][j] = false;
			}	
		}
		
		count = 1;
		while(!ary_is_empty(ary)) {
			in_count = 0;
			count++;
			tmp = search_index(ary);
			dfs(ary, visited, tmp[0], tmp[1]);
			result.add(in_count);
		}	
		bw.write(count - 1 + "\n");
		Collections.sort(result);
		for(Integer item: result) {
			bw.write(item + "\n");
		}
		bw.flush();
		bw.close();
		sc.close();
	}
	
	public static void dfs(int[][] ary, Boolean[][] visited, int x, int y) {
		
		if(visited[x][y] || ary[x][y] == 0 ) return;
		
		visited[x][y] = true;
		ary[x][y] = count;
		in_count++;
		
		dfs(ary, visited, x-1, y);
		dfs(ary, visited, x, y-1);
		if(x < size) dfs(ary, visited, x+1, y);
		if(y < size) dfs(ary, visited, x, y+1);
		
		
	}
	
	public static Boolean ary_is_empty(int[][] ary) {
		
		for(int i = 1; i <= size; i++) {
			for(int j = 1; j <= size; j++) {
				if(ary[i][j] == 1) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static int[] search_index(int[][] ary) {
		
		int[] index_ary = new int[2];
		
		for(int i = 1; i <= size; i++) {
			for(int j = 1; j <= size; j++) {
				if(ary[i][j] == 1) {
					index_ary[0] = i;
					index_ary[1] = j;
					return index_ary;
				}
			}
		}
		return index_ary;	
	}
}
