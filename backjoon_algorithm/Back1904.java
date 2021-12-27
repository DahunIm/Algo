package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back1904 {

	public static BufferedWriter bw;
	public static int[] memo = new int[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		memo[1] = 1;
		memo[2] = 2;
		if( num == 1) bw.write("1\n");
		else if (num == 2) bw.write("2\n");
		else {
			int result = tile(num);
			bw.write(result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	
	public static int tile(int num) throws IOException {

		for(int tmp = 3; tmp <= num; tmp++) {
			memo[tmp] = memo[tmp - 1] + memo[tmp - 2];
			memo[tmp] %= 15746;
		}
		return memo[num] % 15746;	
	}

}
