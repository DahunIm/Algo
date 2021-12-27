package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Back14501 {

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
		
		int tmp_result = 0;
		int max = 0;
		
		for(int i = 0 ; i < line; i++) {
			
			if(i + work[0][i] > line) continue;
			else {
				int index = i + work[0][i] - 1;
				tmp_result = 0;
				for(int j = 0; j < i; j++) {
					if(tmp_result < memo[j]) tmp_result = memo[j];
				}
				if(tmp_result + work[1][i] > memo[index]) memo[index] = tmp_result + work[1][i];
			}
			
		}
	
		for(int i = 0 ; i < line; i++) {
			if(max < memo[i]) max = memo[i];
		}
		return max;
	}

}
