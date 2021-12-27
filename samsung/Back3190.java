package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Back3190 {

	public static int[] x_go = {0, 1, 0, -1};
	public static int[] y_go = {1, 0, -1, 0};
	public static Map<Integer, String> rot_map = new HashMap<Integer, String>();
	public static int ary[][];
	public static int N;
	
	public static int time = 0;
	public static int snake_len = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		ary = new int[N][N];
		
		for(int i = 0 ; i < K ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			ary[x-1][y-1] = -1;
		}
		
		int L = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken());
			String rotate = st.nextToken();
			rot_map.put(time, rotate);
		}
		
		ary[0][0] = 1;
		
		calc(0,0);
		
		bw.write(time + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	
	public static void calc(int s_x, int s_y) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s_x);
		queue.add(s_y);
		queue.add(0);
		
		Queue<Integer> tail_q = new LinkedList<Integer>();
		
		while(!queue.isEmpty()){
			
			int head_x = queue.poll();
			int head_y = queue.poll();
			int go_index = queue.poll();
			time++;
			
			tail_q.add(head_x);
			tail_q.add(head_y);
			
			if(rot_map.containsKey(time - 1)) {
				String rot = rot_map.get(time - 1);
				if(rot.equals("D")) go_index = ((go_index+1)+4) % 4;
				else if(rot.equals("L")) go_index = ((go_index-1)+4) % 4;
			}
			
			int nx = head_x + x_go[go_index];
			int ny = head_y + y_go[go_index];
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) return;
			else {
				if(ary[nx][ny] == 0) {
					int tail_x = tail_q.poll();
					int tail_y = tail_q.poll();
					ary[tail_x][tail_y] = 0;
				}
				else if(ary[nx][ny] == 1) return;
				
				queue.add(nx);
				queue.add(ny);
				queue.add(go_index);
				ary[nx][ny] = 1;
			}
		}
		
		
	}

}
