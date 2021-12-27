package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class hw49 {
	
	public static int ary_x[];
	public static int ary_y[];
	public static int result_x[];
	public static int result_y[];
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int line = Integer.parseInt(br.readLine());
		
		ary_x = new int[line];
		ary_y = new int[line];
		result_x = new int[line];
		result_y = new int[line];
		
		for(int i = 0; i < line ; i++) {
			
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			ary_x[i] = x;
			ary_y[i] = y;
			
		}
		
		sort(0, ary_x.length -1);
		
		for(int i = 0; i < line ; i++) {
			
			bw.write(ary_x[i] + " ");
			bw.write(ary_y[i] + "\n");
			
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void sort(int start, int end) {
		
		if(start < end) {
			int mid = (start + end) / 2;
			sort(start, mid);
			sort(mid + 1, end);
			
			int i,j,k,tmp;
			i = start;
			j = mid + 1;
			k = start;
			
			while(i <= mid && j <= end) {
				
				if(ary_x[i] < ary_x[j]) {
					result_x[k] = ary_x[i];
					result_y[k++] = ary_y[i++];
				}
				
				else if(ary_x[i] == ary_x[j]) {
					if(ary_y[i] > ary_y[j]) {
						result_x[k] = ary_x[j];
						result_y[k++] = ary_y[j++];	
					}
					else {
						result_x[k] = ary_x[i];
						result_y[k++] = ary_y[i++];
					}
				}
				else {
					result_x[k] = ary_x[j];
					result_y[k++] = ary_y[j++];
				}
				
			}
			
			while(i <= mid) {
				
				result_x[k] = ary_x[i];
				result_y[k++] = ary_y[i++];
			}
			
			for(tmp = start; tmp < k ; tmp++) {
				
				ary_x[tmp] = result_x[tmp];
				ary_y[tmp] = result_y[tmp];
			}
			
		}
		
	}
}
