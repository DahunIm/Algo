package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class hw3 {

	public static void main(String[] args) throws IOException {
		
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(bf.readLine());
		
		int i = 1;
		while(i <= num) {
			String s = "";
			for(int j = 0; j < num; j++) {
				if(j < num - i) {
					s += " ";
				}
				else {
					s += "*";
				}
			}
			bw.write( s + "\n");
			i++;
			if( i == num + 1) {
				bw.flush();
				bw.close();
			}
		}
	}
}
	