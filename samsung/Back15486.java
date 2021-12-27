package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Back15486 {

	public static int[][] work;
	public static int[] memo;
	public static int line;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		line = Integer.parseInt(br.readLine());
		work = new int[2][line];
		memo = new int[line];
		
		for(int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			work[0][i] = T;
			work[1][i] = P;
			
		}
		
		bw.write(calc() + "\n");
		bw.flush();
		bw.close();
		br.close();
				
	}
	
	public static int calc() {
		
		int max = 0;
		
		if(work[0][0] <= line) {
			memo[work[0][0] - 1] = work[1][0];
		}
		
		for(int i = 1 ; i < line; i++) {
			if(max < memo[i-1]) max = memo[i-1];
			if(i + work[0][i] > line) continue;
			else {
				int index = i + work[0][i] - 1;
				if(max + work[1][i] > memo[index]) memo[index] = max + work[1][i];
			}
			
		}

		if(max < memo[memo.length - 1]) max = memo[memo.length- 1];
		return max;
	}

}
