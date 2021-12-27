package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back14499 {

	public static int[][] map;
	public static int N, M;
	public static int[] x_go = {0, 0 , -1 , 1};
	public static int[] y_go = {1, -1, 0, 0};
	public static int[] dice = new int[6];
	public static StringTokenizer st;
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		calc(K, x, y);
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}

	
	public static void calc(int K, int s_x, int s_y) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int x, y;
		x = s_x;
		y = s_y;
		for(int i = 0; i < K; i++) {

			int move = Integer.parseInt(st.nextToken());
			int nx = x + x_go[move - 1];
			int ny = y + y_go[move - 1];
			
			if(nx < 0 || nx >= N || ny <0 || ny>=M) continue;
			
			switch(move) {
			case 1:
				dice_rot(0, 1);
				dice_rot(2, 0);
				dice_rot(2, 5);
				if(map[nx][ny] == 0) map[nx][ny] = dice[0];
				else {
					dice[0] = map[nx][ny];
					map[nx][ny] = 0;
				}
				bw.write(dice[5] + "\n");
				break;
				//µ¿
			case 2:
				dice_rot(0, 1);
				dice_rot(1, 5);
				dice_rot(2, 5);
				if(map[nx][ny] == 0) map[nx][ny] = dice[0];
				else {
					dice[0] = map[nx][ny];
					map[nx][ny] = 0;
				}
				bw.write(dice[5] + "\n");
				break;
				//¼­
			case 3:
				dice_rot(0, 3);
				dice_rot(0, 4);
				dice_rot(4, 5);
				if(map[nx][ny] == 0) map[nx][ny] = dice[0];
				else {
					dice[0] = map[nx][ny];
					map[nx][ny] = 0;
				}
				bw.write(dice[5] + "\n");
				break;
				//ºÏ
			case 4:
				dice_rot(0, 3);
				dice_rot(3, 4);
				dice_rot(3, 5);
				if(map[nx][ny] == 0) map[nx][ny] = dice[0];
				else {
					dice[0] = map[nx][ny];
					map[nx][ny] = 0;
				}
				bw.write(dice[5] + "\n");
				break;
				//³²
			}
			
			x = nx;
			y = ny;
			
		}
		
	}
	
	public static void dice_rot(int v1, int v2) {
		
		int tmp = dice[v1];
		dice[v1] = dice[v2];
		dice[v2] = tmp;
		
	}
}
