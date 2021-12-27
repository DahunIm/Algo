package backjoon_algorithm;

/*
 * 꼭다시보기!!!
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back11066 {

	public static int[] test;
	public static int[] sum;
	public static int[][] mem;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int case_num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < case_num; i++) {
			int ary_num = Integer.parseInt(br.readLine());
			
			mem = new int[ary_num +1][ary_num + 1];
			test = new int[ary_num + 1];
			sum = new int[ary_num + 1];
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j <= ary_num; j++) {
				test[j] = Integer.parseInt(st.nextToken());
				sum[j] = sum[j-1] + test[j];
			}
			
			for(int j = 1; j <= ary_num; j++) {
				for(int start = 1; start + j <= ary_num; start++) {
					int end = start + j;
					mem[start][end] = Integer.MAX_VALUE;
					for(int mid = start; mid < end; mid++) {
						mem[start][end] = Math.min(mem[start][end], mem[start][mid] + mem[mid + 1][end] + sum[end] - sum[start - 1]);
						
					}
				}
			}
			
			bw.write(mem[1][ary_num] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
