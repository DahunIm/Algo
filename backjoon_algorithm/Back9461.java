package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Back9461 {

	public static BufferedWriter bw;
	public static long[] ary;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int case_num = Integer.parseInt(br.readLine());
		
		ary = new long[101];
		
		for(int i = 0 ; i < case_num; i++) {
			
			Arrays.fill(ary, 0);
			ary[1] = 1;
			ary[2] = 1;
			ary[3] = 1;
			int num = Integer.parseInt(br.readLine());
			
			trian(num);
			bw.write(ary[num] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void trian(int num) {
		for(int tmp = 4; tmp <= num; tmp++) {	
			if(ary[tmp] == 0) ary[tmp] = ary[tmp -3] + ary[tmp - 2];	
		}	
	}

}
