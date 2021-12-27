package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Back1003 {
	
	public static int[] ary_0 = new int[41];
	public static int[] ary_1 = new int[41];
	public static BufferedWriter bw ;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int case_num = Integer.parseInt(br.readLine());
		ary_0[0] = 1;
		ary_1[0] = 0;
		ary_0[1] = 0;
		ary_1[1] = 1;
		int index = 2;
		for(int i = 0; i < case_num ; i++) {
			int val = Integer.parseInt(br.readLine());
			
			pibo(val, index);
			if(val > index) index = val + 1;
		}
		
		bw.flush();
		bw.close();
	}

	
	public static void pibo(int val, int index) throws IOException {
		

		for(int n = index; n <= val; n++) {		
			ary_0[n] = ary_0[n-1] + ary_0[n-2];
			ary_1[n] = ary_1[n-1] + ary_1[n-2];
		}
		
		bw.write(ary_0[val] + " " + ary_1[val] + "\n");
		
	}
}
