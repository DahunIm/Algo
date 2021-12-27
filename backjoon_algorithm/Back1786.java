package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1786 {

	public static int[] preAry;
	public static String input, comSt;
	public static int cnt;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine();
		comSt = br.readLine();
		cnt = 0;
		
		preAry = new int[comSt.length()];
		
		calcPre();
		kmp();
		System.out.println(cnt);
		System.out.println(sb);
		br.close();
		
	}
	
	public static void kmp() {
		
		int iSize = input.length();
		int cSize = comSt.length();
		
		int j = 0;
		
		for(int i = 0; i < iSize ; i++) {
			while(input.charAt(i) != comSt.charAt(j) && j > 0) {
				j = preAry[j-1];
			}
			
			if(input.charAt(i) 	 == comSt.charAt(j)) {
				if(j == cSize - 1) {
					cnt++;
					sb.append((i - j + 1) + " ");
					j = preAry[j];
				}
				else 
					j++;
			}
			
		}
		
		
		
	}
	
	
	public static void calcPre() {
		
		int len = preAry.length;
		int j = 0;
		preAry[0] = 0;
		
		for(int i = 1; i < len; i++) {
			while(comSt.charAt(i) != comSt.charAt(j) && j > 0) {
				j = preAry[j-1];
			}
			
			if(comSt.charAt(i) == comSt.charAt(j)) {
				preAry[i] = j+1;
				j++;
			}
			
		}
	}

}
