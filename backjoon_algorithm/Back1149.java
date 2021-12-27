package backjoon_algorithm;
/*
  다시보자!!!!!!!!!!!!
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back1149 {

	public static BufferedWriter bw;
	public static int[][] cost_ary;
	public static int[][] memo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int house = Integer.parseInt(br.readLine());
	
		cost_ary = new int[house+1][3];
		memo = new int[house+1][3];
		for(int i = 0; i < house; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < 3; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				cost_ary[i][j] = num;
			}
			
		}
		
		memo[0][0] = cost_ary[0][0];
		memo[0][1] = cost_ary[0][1];
		memo[0][2] = cost_ary[0][2];
		bw.write(Math.min(calc(house -1, 0), Math.min(calc(house-1, 1), calc(house-1, 2))) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}

	public static int calc(int num, int index) {
		
		
		if(memo[num][index] == 0) {
			if(index == 0) {
				memo[num][index] = Math.min(calc(num -1, 1), calc(num -1, 2)) + cost_ary[num][0];
			}
			else if(index == 1) {
				memo[num][index] = Math.min(calc(num -1, 0), calc(num -1, 2)) + cost_ary[num][1];
			}
			else if(index == 2) {
				memo[num][index] = Math.min(calc(num -1, 0), calc(num -1, 1)) + cost_ary[num][2];
			}
		
		}
		
		return memo[num][index];
	}
}
