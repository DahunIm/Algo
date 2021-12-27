package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class hw47 {

	public static BufferedReader br;
	public static BufferedWriter bw;
	public static int ary[];
	public static int result[];
	
	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		ary = new int[num];
		result = new int[num];
		
		for(int i = 0; i < num ; i++) {
			
			ary[i] = Integer.parseInt(br.readLine());
		
		}
		merge_sort(ary, 0, ary.length - 1);
		find_avg();
		find_mid();
		if( num == 1) {
			bw.write(ary[0] + "\n");
		}
		else {
			find_rep();
		}
		find_range();
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

	public static void find_avg() throws IOException {
		
		double max = 0.0;
		
		for(int i =0; i < ary.length; i++) {
			max += ary[i];
		}
		
		
		bw.write((int)Math.round(max/ary.length) + "\n");
	}
	
	public static void find_mid() throws IOException{
		
		bw.write(ary[(ary.length / 2)] + "\n");
		
	}
	
	public static void find_rep() throws IOException {
		
		Arrays.fill(result, 0);
		
		int count = 1, max_count = 0;
		
		for(int i = 0; i < ary.length; i++) {
			
			if( i == 0) {
				continue;
			}
			
			else if(ary[i] == ary[i - 1]) {
				count++; 
				if(i == ary.length - 1) {
					result[i] = count;
					if(max_count < count) {
						max_count = count;
					}
				}
			}
			
			else {
				
				result[i - 1] = count;
				if(i == ary.length - 1) {
					result[i] = 1;
				}
				
				if(max_count < count) {
					max_count = count;
				}
				count = 1;
			}
			
		}
		count = 0;
		
		int index = 0;
		
		for(int i = 0; i <result.length; i++) {
			
			if(result[i] == max_count) {
				result[index++] = ary[i - (result[i] - 1)];
				count++;
			}
		}
		if(count == 1) {
			bw.write(result[0] + "\n");
		}
		else {
			merge_sort(result,0, index-1);
			bw.write(result[1] + "\n");
		}
	}
	
	public static void find_range() throws IOException {
		
		bw.write((ary[ary.length - 1] - ary[0]) + "\n");
		
	}
}
