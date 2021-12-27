package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hw53 {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static int ary[];
	public static boolean ary_c[];
	public static int n,m;
	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		ary = new int[n];
		ary_c = new boolean[n];
		Arrays.fill(ary_c, false);
		dfs(0);
		bw.flush();
		bw.close();
		
	}

	public static void dfs(int num) throws IOException {
		
		if(num == m) {
			for(int i = 0; i < m; i++) {
				bw.write(ary[i] + " ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i = 1; i <=n; i++ ) {
			
			if(!ary_c[i-1]) {
				ary_c[i-1] = true;
				ary[i-1] = i;
				dfs(num + 1);
				ary_c[i-1] = false;
			}
		}
	}
}
