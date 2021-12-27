package backjoon_algorithm;
/*
 * 개어렵네 진짜 ㅡㅡ;
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back9251 {

	static char[] aa;
	static char[] bb;
	static int[][] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String a = br.readLine();
		String b = br.readLine();

		memo = new int[a.length() + 1][b.length() + 1];
		aa = a.toCharArray();
		bb = b.toCharArray();

		for(int i = 1; i <= aa.length; i++) {
			for(int j = 1; j <= bb.length; j++) {
				if(aa[i-1] == bb[j-1]) memo[i][j] = memo[i-1][j-1] + 1;
				else memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
			}
		}

		bw.write(memo[a.length()][b.length()] + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}

}
