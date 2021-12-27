package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class hw51_ans {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		HashSet<String> arr = new HashSet<String>();
		
		for(int i = 0; i< num ; i++) {
			
			String s = br.readLine();
			arr.add(s);
			
		}
		
		ArrayList<String> result = new ArrayList<String>(arr);
	
	
	Collections.sort(result, new Comparator<String>(){
		@Override
		public int compare(String s1, String s2) {
			if(s1.length() == s2.length()) {
				return s1.compareTo(s2);
			}
			else {
				return s1.length() - s2.length();
			}
	}	
	
	});
	
	
	for(String s : result) {
		bw.write(s + "\n");
	}
	
	bw.flush();
	bw.close();
	}
}
