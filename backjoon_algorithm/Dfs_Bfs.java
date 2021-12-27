package backjoon_algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dfs_Bfs {
	
	public static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] ary = (ArrayList<Integer>[]) new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			ary[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= M ; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			ary[v1].add(v2);
			ary[v2].add(v1);
		}
		
		Boolean[] visited = new Boolean[N+1];
		for(int i = 1; i < visited.length; i++) {
			visited[i] = false;
			Collections.sort(ary[i]);
		}
		dfs(ary,visited, V);
		bw.write("\n");
		
		for(int i = 1; i < visited.length; i++) {
			visited[i] = false;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		bfs(ary, visited, V, queue);
		
		bw.write("\n");
		bw.flush();
		bw.close();
		sc.close();
	}

	public static void dfs(ArrayList<Integer>[] ary, Boolean[] visited, int v) throws IOException {
		
		if(visited[v]) return;
		
		bw.write(v + " ");
		visited[v] = true;
		
		for(int tmp : ary[v]) {
			dfs(ary,visited,tmp);
		}
	}
	
	public static void bfs(ArrayList<Integer>[] ary, Boolean[] visited, int v, Queue<Integer> queue) throws IOException {
		
		visited[v] = true;
		while(queue.size() != 0) {
			v = queue.poll();
			bw.write(v + " ");
			
			int i = 0;
			while(!ary[v].isEmpty() && i < ary[v].size()) {
				if(!visited[ary[v].get(i)]) {
					visited[ary[v].get(i)] = true;
					queue.add(ary[v].get(i));
				}
				i++;
			}
		}
	}
	
}
