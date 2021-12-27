package gaboza;

public class Gazua22 {

	public static void main(String[] args) {
		
		
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int x_move[] = {-1, 0, 1, -2, 0, 2, -1, 1};
		int y_move[] = {0, 1, 0, 0, 2, 0, 1, 1};
		
		int[] answer = new int[places.length];
		
		int[][] wait_ary = new int[5][5];
		int index = 0;
		char place = '\0';
		String wait_tmp = "";
		
		for(int i = 0; i < places.length; i++) {
			wait_tmp = "";
			for(int j = 0; j < places.length; j++) {
				wait_tmp += places[i][j];
			}
			index = 0;
			for(int k = 0; k < places.length; k++) {
				for(int m = 0; m < places.length; m++) {
					place = wait_tmp.charAt(index);
					if(place == 'P') wait_ary[k][m] = 1;
					else if(place == 'O') wait_ary[k][m] = 0;
					else if(place == 'X') wait_ary[k][m] = -1;
					index++;
				}
			}
			
			
			answer[i] = check_place(wait_ary, x_move, y_move);
			
		}
		
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]+ " ");
		}
		System.out.println();
		
		
	}
	
	public static int check_place(int[][] wait_ary, int[] x_move, int[] y_move) {
		int result = 1;
		int tmp_nx = 0;
		int tmp_ny = 0;
		for(int i = 0; i < wait_ary.length; i++) {
			for(int j = 0; j < wait_ary.length; j++) {
				if(wait_ary[i][j] == 1) {
					for(int tmp = 0; tmp < x_move.length; tmp++) {
						int nx = i + x_move[tmp];
						int ny = j + y_move[tmp];
						if(nx >= 0 && nx < wait_ary.length && ny >= 0 && ny < wait_ary.length && wait_ary[nx][ny] == 1)
							if(tmp >= 0 && tmp < 3) {
								if(wait_ary[nx][ny] == 1) return 0;						
							}
							else if(tmp >=3 && tmp < 6) {
								tmp_nx = i + x_move[tmp - 3];
								tmp_ny = j + y_move[tmp - 3];
								if(wait_ary[nx][ny] + wait_ary[tmp_nx][tmp_ny] + wait_ary[i][j] >= 2) return 0;
							}
							else if(tmp == 6) {
								if(wait_ary[nx][ny-1] + wait_ary[nx+ 1][ny] != -2) return 0;
							}
							else {
								if(wait_ary[nx][ny-1] + wait_ary[nx - 1][ny] != -2) return 0;
							}
					}		
				}
			}
		}	
		return result;
	}
	
}


