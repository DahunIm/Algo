package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class hw46 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int max = 0;
		
		int count[] = new int[10000];
		for(int i = 0; i < num ; i++) {
			
			int tmp = Integer.parseInt(br.readLine());
			
			count[tmp-1]++;
		}
		
		for(int j = 0; j < count.length; j++) {
			
			if(count[j] != 0) {
				int tmp = count[j];
				while(tmp > 0) {
					bw.write(j+1 + "\n");
					tmp--;
				}
			}
		}
		bw.flush();
		bw.close();
	}

}
