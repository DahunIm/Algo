package backjoon1;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class hw4 {

	public static void main(String[] args) throws IOException {
		
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		int num = Integer.parseInt(st.nextToken());
		int st_num = Integer.parseInt(st.nextToken());
		
		int i = 1, j = 0;
		String s_tmp = bf.readLine();
		StringTokenizer st_tmp = new StringTokenizer(s_tmp, " ");
		String tmp = "";
		while(i <= num) {
			
			int tmp_num = Integer.parseInt(st_tmp.nextToken());
			if(tmp_num < st_num) {
				if(j == 0) {
					tmp += tmp_num;
					j++;
				}
				else {
					tmp += " ";
					tmp += tmp_num;
				
				}
			}
			i++;
		}
		bw.write(tmp);
		bw.flush();
		bw.close();
			
	}
}


/*
public class hw4 {

	public static void main(String[] args) throws IOException {
	
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int st_num = sc.nextInt();
		
		int i = 0;
		while(i < num) {
			int tmp_num = sc.nextInt();
			if(tmp_num < st_num) {
				if( i == num - 1) {
					System.out.println(tmp_num);
				}
				else {
				System.out.print(tmp_num + " ");	
				}
			}
			i++;
		}
	}
}
*/