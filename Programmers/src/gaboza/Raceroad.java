package gaboza;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Raceroad {

	public static int board[][];
	public static int memo[][];
	public static int[] x_go = { 1, 0 , -1, 0};
	public static int[] y_go = { 0, 1 , 0 , -1};
	public static int[] direction = {0 , 1};	
	public static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		
		int[][] board = {{0, 0, 0, 0, 0},
		        {0, 1, 1, 1, 0},
		        {0, 0, 1, 0, 0},
		        {1, 0, 0, 0, 1},
		        {0, 1, 1, 0, 0}};
		memo = new int[board[0].length][board[0].length];
		
		System.out.println(board[0].length);
		for(int[] tmp: memo) Arrays.fill(tmp, Integer.MAX_VALUE);
		for(int i = 0; i < board[0].length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 1) memo[i][j] = -1;
			}
		}

		queue.add(-1);
		queue.add(0);
		queue.add(0);
		queue.add(0);
		
		memo[0][0] = 0;
		route(board);
		for(int i = 0 ; i < board[0].length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(memo[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(memo[board[0].length - 1][board[0].length - 1]);
		
		}
		
	public static void route(int[][] board) {
		
		int direct;
		int x;
		int y;
		int q_cost;
		int cost = 0;
		
		while(!queue.isEmpty()) {
			direct = queue.poll();
			x = queue.poll();
			y = queue.poll();
			q_cost = queue.poll();
			
			if(q_cost > memo[x][y]) continue;
			System.out.println(direct + " " + x + " " + y + " " + memo[x][y]);
			for(int i = 0 ; i < 4; i ++) {
				int next_x = x + x_go[i];
				int next_y = y + y_go[i];
				int tmp_i = i;
				if(next_x >= 0 && next_x < board[0].length && next_y >= 0 && next_y < board[0].length) {
					if(direct < 0) cost = 100;
					else if(direct == direction[tmp_i % 2]) cost = 100;
					else cost = 600;
					
					if(memo[next_x][next_y] >= memo[x][y] + cost && memo[next_x][next_y] >= 0) {
						memo[next_x][next_y] = memo[x][y] + cost;
						queue.add(direction[tmp_i % 2]);
						queue.add(next_x);
						queue.add(next_y);
						queue.add(memo[next_x][next_y]);
					}
					
				}
			}
		}
	}
}
