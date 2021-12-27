package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Dfs_Bfs10 {

	public static BufferedWriter bw;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int case_num = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i < case_num; i++) {
			queue.clear();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			@SuppressWarnings("unchecked")
			ArrayList<Integer>[] ary = (ArrayList<Integer>[]) new ArrayList[V + 1];
			for(int k = 0; k <= V; k++) {
				ary[k] = new ArrayList<>();
			}
			int[] color = new int[V+1];
			
			for(int j = 0; j < E ; j++) {
				StringTokenizer st_edge = new StringTokenizer(br.readLine(), " ");
			
				int s_edge = Integer.parseInt(st_edge.nextToken());
				int e_edge = Integer.parseInt(st_edge.nextToken());
				ary[s_edge].add(e_edge);
				ary[e_edge].add(s_edge);
			}
			int tmp_num = 0;
			for(int z = 1; z < V; z++) {
				
				if(color[z] == 0) {
					tmp_num = bfs(queue, ary, color, z);
					if(tmp_num == -1) {
						bw.write("NO\n");
						break;
					}
				}
				
			}
			if(tmp_num == 0) bw.write("YES\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int bfs(Queue<Integer> queue, ArrayList<Integer>[] ary, int[] color, int start) {
		
		color[start] = 1;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			
			int nowV = queue.poll();
			
			for(int tmpV : ary[nowV]) {
				
				if(color[tmpV] == 0) {
					if(color[nowV] == 1) {
						color[tmpV] = 2;
						queue.add(tmpV);
					}
					else if(color[nowV] == 2) {
						color[tmpV] = 1;
						queue.add(tmpV);
					}
				}
				
				else if(color[nowV] + color[tmpV] != 3) return -1;
				
			}			
		}
		return 0;
	}

}
