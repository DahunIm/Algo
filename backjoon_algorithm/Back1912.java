package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back1912 {

	public static int[] ary;
	public static int[] memo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		ary = new int[num + 1];
		memo = new int[num + 1];		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= num; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		memo[1] = ary[1];
		
		for(int i = 0; i < num; i++) {
			if(memo[i] > 0) memo[i+1] = memo[i] + ary[i + 1];
			else memo[i+1] = ary[i+1];
		}
		int max = -1001;
		
		for(int i = 1; i <= num; i++) {
			if(max < memo[i]) max = memo[i];
		}
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
