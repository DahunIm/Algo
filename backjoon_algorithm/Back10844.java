package backjoon_algorithm;
/* 
 * 혼자 1개도 못푸네.. 이것도 다시보자... DP 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back10844 {

	public static int[][] memo;
	public static int MAX = 1000000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		memo = new int[num + 1][10];
		
		memo[1][0] = 0;
		for(int i = 1; i < 10; i++) {
			memo[1][i] = 1;
		}
		
		for(int i = 2; i <= num; i++) {
			for(int k = 0; k < 10; k++) {
				
				if(k == 0) {
					memo[i][k] = memo[i-1][k+1] % MAX; 
				}
				else if(k == 9) {
					memo[i][k] = memo[i-1][k-1] % MAX;
				}
				else {
					memo[i][k] = (memo[i-1][k-1] % MAX + memo[i-1][k+1] % MAX) % MAX;
				}
				
			}	
		}
		
		int result = 0;
		for(int i = 0; i <10 ; i++) {
			result += memo[num][i];
			result %= MAX;
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();	
	}
}
