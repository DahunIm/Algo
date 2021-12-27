package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back10942 {

	public static String[] ary;
	public static String[][] mem;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int ary_num = Integer.parseInt(br.readLine());
		ary = new String[ary_num + 1];
		mem = new String[ary_num + 1][ary_num + 1];
		for(String[] tmp: mem) Arrays.fill(tmp, "");
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i  = 1; i <= ary_num; i++) {
			ary[i] = st.nextToken();
		}
		
		for(int mid = 1; mid <= ary_num; mid++) {
			mem[mid][mid] = ary[mid];
			if(mid != ary_num) mem[mid][mid + 1] = ary[mid + 1];
			if(mid != 1) mem[mid][mid - 1] = ary[mid - 1];
			
			for(int i = mid - 2; i > 0; i--) {
				mem[mid][i] = ary[i] + mem[mid][i + 1];
			}
			
			for(int j = mid + 2; j <= ary_num; j++) {
				mem[mid][j] = ary[j] + mem[mid][j - 1];
			}
		}		
		
		int speak = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<= speak; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int mid = (start + end) / 2;
			
			if(start == end) bw.write("1\n");
			else if((start + end) % 2 == 0) {
				if(mem[mid][start].equals(mem[mid][end])) bw.write("1\n");
				else bw.write("0\n");
			}
			else if((start + end) % 2 != 0) {
				if(ary[mid].equals(ary[mid+1])) {
					if(mem[mid][end].equals(mem[mid+1][start])) bw.write("1\n");
					else bw.write("0\n");
				}
				else bw.write("0\n");
			}
			
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
