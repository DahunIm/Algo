package backjoon_algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Dfs_Bfs1 {

	public static int count;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		 Scanner sc = new Scanner(System.in);
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 int v_num = sc.nextInt();
		 int e_num = sc.nextInt();
		 ArrayList<Integer>[] ary = (ArrayList<Integer>[]) new ArrayList[v_num + 1];
		 for(int i = 0; i <= v_num; i++) {
			 ary[i] = new ArrayList<>();
		 }
		 
		 for(int i = 1; i <= e_num ; i++) {
			 int v1 = sc.nextInt();
			 int v2 = sc.nextInt();
			 
			 ary[v1].add(v2);
			 ary[v2].add(v1);
		 }
		 Boolean[] visited = new Boolean[v_num + 1];
		 for(int i = 1; i <= v_num; i++) {
			 visited[i] = false;
			 Collections.sort(ary[i]);
		 }
		 count = 0;
		 dfs(ary, visited, 1);
		 
		 bw.write((count - 1) + "\n");
		 bw.flush();
		 bw.close();
		 sc.close();
	}
	
	public static void dfs(ArrayList<Integer>[] ary, Boolean[] visited, int v) {
		
		if(visited[v]) return;
		
		count++;
		visited[v] = true;
		
		for(int tmp : ary[v]) {
			dfs(ary, visited, tmp);
		}
	}

}
