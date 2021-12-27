package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// ¬Ú¬Ú«— «Æ¿Ã
public class hw52 {
	public static String ary[][];
	public static String result[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		ary = new String[3][num];
		result = new String[3][num];

		for(int i =0; i < num; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			ary[0][i] = Integer.toString(age);
			ary[1][i] = name;
			ary[2][i] = Integer.toString(i);
			
		}

		merge_sort(0, ary[0].length - 1);

		sort_name();
		
		for(int i = 0 ; i < ary[0].length ; i++) {
			bw.write(ary[0][i] + " ");
			bw.write(ary[1][i] + "\n");
		}
		
		bw.flush();
		bw.close();
		
	}
	

	public static void sort_name() {
		
		int i = 1;
		
		while(i < ary[0].length) {
			int j = i;
				while(j < ary[0].length && Integer.parseInt(ary[0][j]) == Integer.parseInt(ary[0][j-1])) {
					
					if(Integer.parseInt(ary[2][j]) < Integer.parseInt(ary[2][j-1])) {
						swit(j,j-1);
					}
					j++;
				}
	
			i++;
		}
		
	}
	
	public static void swit(int in, int out) {
		
		String tmp;
		
		for(int i = 0; i < 3; i++) {
			tmp = ary[i][in];
			ary[i][in] = ary[i][out];
			ary[i][out] = tmp;
		}
	}

	
	public static void merge_sort( int left, int right) {
		
		if(left<right) {
			int mid = (left+right)/2;
			merge_sort(left, mid);
			merge_sort(mid+1, right);
			
			int i, j, k, tmp;
			i = left;
			j = mid + 1;
			k = left;
			
			while(i <= mid && j <= right) {
				
				if(Integer.parseInt(ary[0][i]) <= Integer.parseInt(ary[0][j])) {
					result[2][k] = ary[2][i]; 
					result[0][k] = ary[0][i];
					 result[1][k++] = ary[1][i++];
				}
				else {
					result[2][k] = ary[2][j]; 
					result[0][k] = ary[0][j];
					result[1][k++] = ary[1][j++];
				}
				
			}
			
			while(i <= mid) {
				result[2][k] = ary[2][i]; 
				result[0][k] = ary[0][i];
				result[1][k++] = ary[1][i++];
			}
			
			for(tmp = left ; tmp < k ; tmp++) {
				ary[2][tmp] = result[2][tmp];
				ary[0][tmp] = result[0][tmp];
				ary[1][tmp] = result[1][tmp];
			}

		}
	}
}
