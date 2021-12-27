package backjoon_algorithm;
/*
 * Napsack 기초 확인만 하자
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back12865 {

	public static int[] wei_ary;
	public static int[] val_ary;
	public static int[] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		int line_num = Integer.parseInt(st.nextToken());
		int max_weight = Integer.parseInt(st.nextToken());
		
		wei_ary = new int[line_num + 1];
		val_ary = new int[line_num + 1];
		memo = new int[max_weight + 1];
		
		for(int i =1 ; i <= line_num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			wei_ary[i] = Integer.parseInt(st.nextToken());
			val_ary[i] = Integer.parseInt(st.nextToken());	
		}
		
		for(int i = 1; i <= line_num; i++) {
			int weight = wei_ary[i];
			int val = val_ary[i];
			for(int j = max_weight; j >= weight; j--) {
				memo[j] = Math.max(memo[j], memo[j - weight] + val);
			}
		}
		
		int max = 0;
		for(int i = 1; i <= max_weight; i++) {
			if(max < memo[i]) max = memo[i];
		}
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();	
	}
}
