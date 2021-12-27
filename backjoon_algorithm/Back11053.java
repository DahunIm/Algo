package backjoon_algorithm;
/*
 * 이분 탐색도 가능합니다 알아두기!!
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back11053 {

	public static int[] ary;
	public static int[][] memo;
	public static int[] num_max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int num = Integer.parseInt(br.readLine());
		ary = new int[num + 1];
		memo = new int[num + 1][num + 1];
		num_max = new int[num + 1];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i <= num; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i <= num; i++) {
			for(int j = i + 1; j <= num; j++) {
				if(ary[i] < ary[j]) {
					memo[i][j] = num_max[i] + 1;
					if(num_max[j] < num_max[i] + 1) num_max[j] = num_max[i] + 1;
				}
			}	
		}
	
		bw.write(find_max(num) + 1 + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static int find_max(int num) {
		int max = 0;
		for(int i = 1; i <= num; i++) {
			if(max < num_max[i]) max = num_max[i];
			
		}
		
		return max;
	}
}
