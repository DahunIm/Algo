package backjoon_algorithm;
/*
 * 다시보자!!!!!!!
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back2579 {

	public static int[] stair;
	public static int[] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		stair = new int[301];
		memo = new int[301];
		
		for(int i = 1; i <= num; i++) {
			int val = Integer.parseInt(br.readLine());
			stair[i] = val;		
		}
		
		
		memo[1] = stair[1];
		memo[2] = stair[1] + stair[2];
		memo[3] = Math.max(stair[1] + stair[3] , stair[2] + stair[3]);
		
		for(int i = 4; i <= num; i++) {
			
			memo[i] = Math.max(memo[i-3] + stair[i-1] + stair[i], memo[i-2] + stair[i]);
			
		}
		
		bw.write(memo[num] + "\n");
		bw.flush();
		bw.close();
		br.close();	
	}

}
