package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class hw45 {

	public static int result[];
	public static int ary[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		ary = new int[num];
		
		result = new int[num];
		if(num == 1) {
			bw.write(Integer.parseInt(br.readLine()) + "\n");
		}
		
		else {
			for(int i = 0; i < num; i++) {
			
				ary[i] = Integer.parseInt(br.readLine());
			
			}
		
			merge_sort(ary, 0, (ary.length - 1));
			for(int j = 0; j < ary.length ; j++) {
				bw.write(ary[j] + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
	
	public static void merge_sort(int ary[], int left, int right) {
		
		if(left<right) {
			int mid = (left+right)/2;
			merge_sort(ary, left, mid);
			merge_sort(ary, mid+1, right);
			
			int i, j, k, tmp;
			i = left;
			j = mid + 1;
			k = left;
			
			while(i <= mid && j <= right) {
				
				if(ary[i] <= ary[j]) {
					 result[k++] = ary[i++];
				}
				else {
					result[k++] = ary[j++];
				}
				
			}
			
			while(i <= mid) {
				result[k++] = ary[i++];
			}
			
			for(tmp = left ; tmp < k ; tmp++) {
				ary[tmp] = result[tmp];
			}

		}
	}
}
