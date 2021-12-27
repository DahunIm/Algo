package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class hw2 {

	public static void main(String[] args) throws IOException {
		
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(bf.readLine());
		
		int i = 0;
		while(i < num) {
			String s = (bf.readLine());
			StringTokenizer st = new StringTokenizer(s, " ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			bw.write("Case #" + (i + 1) + ": " + num1 + " + " + num2 + " = " + 
			(num1 + num2) + "\n");
			i++;
			if( i == num) {
				bw.flush();
				bw.close();
			}
		}
	}
}
	