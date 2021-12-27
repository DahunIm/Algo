package backjoon_algorithm;
/*
 * DFS + DP 잘 알아두자...
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back1520 {

	public static int[][] ary;
	public static int[][] mem;
	public static int x, y;
	public static int[] nx = { 0, 1, 0, -1};
	public static int[] ny = { 1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		ary = new int[x + 1][y + 1];
		mem = new int[x + 1][y + 1];
		for(int[] tmp: mem) Arrays.fill(tmp, -1);
		for(int i = 1; i <= x; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= y; j++ ) {
				ary[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bw.write(calc(1,1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int calc(int a, int b) {
		
		mem[a][b] = 0;
		
		for(int i = 0; i < 4; i++) {
			
			int mx = a + nx[i];
			int my = b + ny[i];
		
			if(1 <= mx && mx <= x && 1 <= my && my <= y) {
				
				if(ary[a][b] > ary[mx][my]) {
					if(mx == x && my == y) mem[a][b] += 1;
					if(mem[mx][my] >= 0) mem[a][b] += mem[mx][my];
					else mem[a][b] += calc(mx, my);
				}
				
				
				
			}
		}
		
		return mem[a][b];
	}
	
}
	