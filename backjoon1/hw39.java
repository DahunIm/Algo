package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class hw39 {

	public static int ary[];
	public static void main(String[] args) throws IOException {

		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		*/
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ary = new int[n];
		for(int i = 0; i < n ; i++) {
			
			ary[i] = sc.nextInt();
		}
		calc_ary(m);
		sc.close();
	}
	
	public static void calc_ary(int num) {
		
		int gap = num;
		int i_in = 0, j_in= 0, k_in = 0;
		for(int i = 0; i < ary.length -2; i++ ) {
			for(int j = i+1; j < ary.length - 1; j++) {
				for(int k = j+1; k < ary.length; k++) {
					if( num >= (ary[i] + ary[j] + ary[k]) && gap >= num - (ary[i] + ary[j] + ary[k])){
						i_in = i;
						j_in = j;
						k_in = k;
						gap = num - (ary[i] + ary[j] + ary[k]);
					}
				}
			}
		}
		System.out.println(ary[i_in] + ary[j_in] + ary[k_in]);
		
	}

}
