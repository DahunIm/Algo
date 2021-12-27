package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class hw14 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		
		for( int i = 0; i < num; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			int rep = Integer.parseInt(st.nextToken());
			String input_st = st.nextToken();
			
			String result_string = pt(input_st, rep);
			
			bw.write(result_string + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static String pt(String s, int rep) {
		
		
		String st_change = "";
		for(int i = 0; i < s.length(); i++) {
			
			for(int j = 0; j < rep; j++) {
				
				st_change += s.charAt(i);
				
			}
			
		}
	
		return st_change;
	}

}
