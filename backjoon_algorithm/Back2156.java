package backjoon_algorithm;

/*
 * 왜맞았지..? ㅋㅋ 계단오르기랑 조금 다르게한 부분 확인
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back2156 {

	public static int[] grape;
	public static int[] memo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		grape = new int[num + 1];
		memo = new int[num + 1];

		for(int i = 1; i <= num; i++) {
			
			int yang = Integer.parseInt(br.readLine());
			
			grape[i] = yang;
			
		}
		if(num == 1) bw.write(grape[1] + "\n");
		else if(num == 2) bw.write((grape[1] + grape[2]) + "\n");
		else {
			memo[1] = grape[1];
			memo[2] = grape[1]+ grape[2];
			memo[3] = Math.max(grape[1] + grape[3] , Math.max(memo[2], grape[2] + grape[3]));
		
			for(int i = 4; i <= num; i++) {
				memo[i] = Math.max(memo[i-3] + grape[i-1] + grape[i], memo[i-2] + grape[i]);
				if(memo[i-1] > memo[i]) memo[i] = memo[i-1];
			}
		
			bw.write(Math.max(memo[num], memo[num - 1]) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	
	}

}
