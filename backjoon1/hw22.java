package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class hw22 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int haru = A - B;
		int day = 0;
		
		if((V-A) % haru == 0){
			
			day = (V-A) / haru + 1;
		}
		else if((V-A) > haru){
			
			day = ((V-A) / haru) + 2;

			
		}
		else if((V-A) < haru) {
			
			day = (V-A) / haru +2; 
					
		}
		
		bw.write(day + "\n");
		bw.flush();
		bw.close();
		
	}
// 5 3 6
	
}
