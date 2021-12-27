package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class hw26 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < num ; i++) {
			
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int a = (int)Math.sqrt((double)(y - x));
			if(y-x == a * a) {
				
				bw.write(a * 2 - 1 + "\n");
				
			}
			
			else if((y-x) > a * a && (y-x) <= a * (a+1) ) {
				
				bw.write(a * 2 + "\n");
			}
			
			else {
				bw.write(a * 2 + 1 + "\n");
			}
			
		}
		bw.flush();
		bw.close();
	}
}
