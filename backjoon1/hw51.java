package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class hw51 {

	public static String result[];
	public static String s_ary[];
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i< num ; i++) {
			
			String s = br.readLine();
			set.add(s);
			
		}
		
		s_ary = new String[set.size()];
		result = new String[set.size()];
		
		Iterator <String> itor = set.iterator();
		int i = 0;
		while(itor.hasNext()) {
			s_ary[i] = itor.next();
			i++;
		}

		Arrays.sort(s_ary);		
		for(i = 0; i < s_ary.length; i++) {
			bw.write(s_ary[i] + "\n");
		}

		bw.write("\n");
		merge_sort(0, s_ary.length - 1);
		for(i = 0; i < s_ary.length; i++) {
			bw.write(s_ary[i] + "\n");
		}
		
		bw.flush();
		bw.close();
		
	}
	
	public static void merge_sort(int start, int end) {
		
		if(start<end) {
			int mid = (start + end) / 2;
			merge_sort(start, mid);
			merge_sort(mid + 1, end);
			
			int i,j,k,tmp;
			i = start;
			j = mid + 1;
			k = start;
			
			while(i <= mid && j <= end) {
				
				if(s_ary[i].length() > s_ary[j].length()) {
					result[k++] = s_ary[j++];
				}
				else {
					result[k++] = s_ary[i++];
				}
			}
			
			while(i <= mid) {
				
				result[k++] = s_ary[i++];
				
			}
			
			for(tmp = start; tmp < k; tmp++) {
				s_ary[tmp] = result[tmp];
			}
		}
	}

}
