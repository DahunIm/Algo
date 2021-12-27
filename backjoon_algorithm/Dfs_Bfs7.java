package backjoon_algorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dfs_Bfs7 {

	public static BufferedWriter bw;
	public static int MAX = 100001;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		int[] ary = new int[MAX];
		Boolean[] visited = new Boolean[MAX];
		
		Arrays.fill(visited, false);
		bfs(ary, visited, start, end);
		
		
		bw.flush();
		bw.close();
		sc.close();
	}
	
	public static void bfs(int[] ary, Boolean[] visited, int start, int end) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		ary[start] = 0;
		visited[start] = true;
		while(!queue.isEmpty()) {
			
			int num = queue.poll();
			
			if(num == end) {
				bw.write(ary[num] + "\n");
				return;
			}
			
			if(num-1 >= 0 && !visited[num-1]) {
				queue.add(num - 1);
				visited[num - 1] = true;
				ary[num - 1] = ary[num] + 1;
			}
			if(num + 1 < MAX && !visited[num+1]) {
				queue.add(num + 1);
				visited[num + 1] = true;
				ary[num + 1] = ary[num] + 1;
			}
			if(num * 2 < MAX && !visited[num * 2]) {
				queue.add(num * 2);
				visited[num * 2] = true;
				ary[num * 2] = ary[num] + 1;
			}
		}
	}
}
