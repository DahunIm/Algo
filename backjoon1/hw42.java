package backjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hw42 {

	public static char ary[][];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ary = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < m ; j++) {
				ary[i][j] = tmp.charAt(j);
			}
		}
			
		calc_chess(n, m);
			
	}
		
	
	public static void calc_chess(int n, int m) {
		
		int tmp;
		int min = 64;
		int white, black;
		for(int i = 0; i <= n - 8; i++) {
			for(int j = 0; j <= m - 8; j++) {
				white = calc_w(i,j);
				black = calc_b(i,j);
				tmp = white > black ? black : white;
				if(tmp < min) {
					min = tmp;
				}
			}
		}
		
		System.out.println(min);
	}
	
	public static int calc_w(int x, int y) {
		int count = 0;
		int row = 1, col = 1;
		for(int i = x; i < x + 8; i++) {
			col = 1;
			for(int j = y; j < y + 8 ; j++ ) {
				if( ((row + col) % 2 == 0 && ary[i][j] == 'B') || ((row + col) % 2 != 0 && ary[i][j] == 'W')) {
					count++;
				}
				col++;
			}
			row++;
		}
		return count;
	}
	
	public static int calc_b(int x, int y) {
		int count = 0;
		int row = 1, col = 1;
		for(int i = x; i < x + 8; i++) {
			col = 1;
			for(int j = y; j < y + 8 ; j++ ) {
				if( ((row + col) % 2 == 0 && ary[i][j] == 'W') || ((row + col) % 2 != 0 && ary[i][j] == 'B')) {
					count++;
				}
				col++;
			}
			row++;
		}
		return count;
	}
}
