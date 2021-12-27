package backjoon_algorithm;
/*
 * 아이디어 떠울리기가 어려운디 ㅜㅜ
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Back2565 {

	public static int[][] ary;
	public static int[] memo;
	public static int[] max_ary;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int num = Integer.parseInt(br.readLine());
		
		ary = new int[num+1][2];
		memo = new int[num+1];
		max_ary = new int[num + 1];

		for(int i = 1; i <= num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a_num = Integer.parseInt(st.nextToken());
			int b_num = Integer.parseInt(st.nextToken());
			ary[i][0] = a_num;
			ary[i][1] = b_num;
		}
		
		Arrays.sort(ary, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
	
		});
		Arrays.fill(memo, 1);
		Arrays.fill(max_ary, 1);
		
		int max = 0;
		for(int i = 1; i <= num ; i++) {
			for(int j = i + 1; j <= num; j++) {
				
				if(ary[i][1] < ary[j][1]) {
					memo[i] = max_ary[i] + 1;
					if(max_ary[i] + 1 > max_ary[j]) max_ary[j] = max_ary[i] + 1;
				}
			}
			if(max < max_ary[i]) max = max_ary[i];
		}
 		
		bw.write(num - max+ "\n");
		bw.flush();
		bw.close();
		br.close();	
	}
}
