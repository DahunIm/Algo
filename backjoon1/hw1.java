package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class hw1 {

	public static void main(String[] args) throws IOException {
		
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(bf.readLine());
		
		int i = 0;
		while(i < num) {
			String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			//Integer.parseInt
			int num1 = Integer.parseInt(st.nextToken());
		    //Integer.parseInt
			int num2 = Integer.parseInt(st.nextToken());
			//String ary[] = s.split(" ");
			bw.write((num1 + num2) + "\n");
			i++;
			if( i == num) {
				bw.flush();
				bw.close();
			}
		}
	}
}
	