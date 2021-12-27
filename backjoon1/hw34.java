package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class hw34 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int max, min1, min2;
		while(true) {
			
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());
			
			if( num1 == 0 || num2 == 0 || num3 == 0) {
				break;
			}
			
			if(num1 >= num2) {
				max = num1;
				min1 = num2;
				if(num3 >= max) {
					max = num3;
					min2 = num1;
				}
				else {
					min2 = num3;
				}
			}
			else {
				max = num2;
				min1 = num1;
				if(num3 >= max) {
					max = num3;
					min2 = num2;
				}
				else {
					min2 = num3;
				}
			}
			
			if(Math.pow(max, 2) == Math.pow(min1, 2) + Math.pow(min2, 2)) {
				bw.write("right" + "\n");
			}
			else {
				bw.write("wrong" + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}

}
