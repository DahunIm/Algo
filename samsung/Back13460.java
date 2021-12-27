package samsung;

/* 알아두자 !! */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back13460 {
	
	public static int[][] ary;
	public static boolean[][][][] visited;
	public static int[] x_go = {0, -1, 0, 1};
	public static int[] y_go = {-1, 0, 1, 0};
	public static int count = 0;
	public static int N, M;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M][N][M];

		ary = new int[N][M];
		String tmp = "";
		int start_rx = 0, start_ry = 0;
		int start_bx = 0, start_by = 0;

		for(int i = 0; i < N ; i++) {
			tmp = br.readLine();
			for(int j = 0; j < M ; j++) {
				char tmp_char = tmp.charAt(j);
				switch(tmp_char) {
				case '#':
					ary[i][j] = -10;
					break;
				case 'B':
					ary[i][j] = -2;
					start_bx = i;
					start_by = j;
					break;
				case 'R':
					ary[i][j] = -1;
					start_rx = i;
					start_ry = j;
					break;
				case 'O':
					ary[i][j] = 1;
					break;
				}
			}
		}
		
		int answer = bfs(start_rx, start_ry, start_bx, start_by);
		if(answer == 0) bw.write("-1\n");
		else bw.write(answer + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	public static int bfs(int rx, int ry, int bx, int by) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int answer = 0;
		queue.add(rx);
		queue.add(ry);
		queue.add(bx);
		queue.add(by);
		queue.add(0);
		visited[rx][ry][bx][by] = true;
		int now_rx, now_ry, now_bx, now_by, now_count;
		while(!queue.isEmpty()) {
			now_rx = queue.poll();
			now_ry = queue.poll();
			now_bx = queue.poll();
			now_by = queue.poll();
			now_count = queue.poll();
			
			if(ary[now_bx][now_by] == 1 || now_count > 10) continue;
			if(ary[now_rx][now_ry] == 1) return now_count;
			int n_rx, n_ry, n_bx, n_by;
			
			for(int i = 0; i < 4; i++) {		
					n_rx = now_rx;
					n_ry = now_ry;
					while(true) {
						if(ary[n_rx][n_ry] != -10 && ary[n_rx][n_ry] != 1) {
							n_rx += x_go[i];
							n_ry += y_go[i];
						}
						else {
							if(ary[n_rx][n_ry] == -10) {
								n_rx -= x_go[i];
								n_ry -= y_go[i];
							}
							break;
						}
					}	
					
					n_bx = now_bx;
					n_by = now_by;
					while(true) {
						if(ary[n_bx][n_by] != -10 && ary[n_bx][n_by] != 1) {
							n_bx += x_go[i];
							n_by += y_go[i];
						}
						else {
							if(ary[n_bx][n_by] == -10) {
								n_bx -= x_go[i];
								n_by -= y_go[i];
							}
							break;
						}
					}
					
					if(n_rx == n_bx && n_ry == n_by && ary[n_rx][n_ry] != 1) {
						int r_len = Math.abs(now_rx - n_rx) + Math.abs(now_ry - n_ry);
						int b_len = Math.abs(now_bx - n_bx) + Math.abs(now_by - n_by);
						if(r_len > b_len) {
							n_rx -= x_go[i];
							n_ry -= y_go[i];
						}
						else {
							n_bx -= x_go[i];
							n_by -= y_go[i];
						}
					}
					
					if(!visited[n_rx][n_ry][n_bx][n_by]) {
						visited[n_rx][n_ry][n_bx][n_by] = true;
						queue.add(n_rx);
						queue.add(n_ry);
						queue.add(n_bx);
						queue.add(n_by);
						queue.add(now_count + 1);
					}	
				}
		}	
		return answer;		
	}
	
}