package backjoon1;

import java.util.Scanner;

public class hw48 {

	public static int ary[];
	public static int result[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		ary = new int[input.length()];
		result = new int[input.length()];
		
		for(int i = 0; i < input.length() ; i++) {
			
			ary[i] = Character.getNumericValue(input.charAt(i));
			
			
		}
		
		sort(0, ary.length - 1);
		
		for(int i = 0; i < ary.length; i++) {
			System.out.print(ary[i]);
			
		}
		System.out.println();
		
	}
	
	
	public static void sort(int start, int end) {
		int mid;
		
		if(start < end) {
			mid = (start + end) / 2;
			sort(start, mid);
			sort(mid+1, end);	
			
			int i,j,k,tmp;
			
			i = start;
			j = mid + 1;
			k = start;
			
			while(i <= mid && j <= end) {
				
				if(ary[i] <= ary[j]) {
					result[k++] = ary[j++];
				}	
				else {
					result[k++] = ary[i++];
				}
				
			}
			
			while(i <= mid) {
				
				result[k++] = ary[i++];
				
			}
			
			for(tmp = start; tmp < k ; tmp++) {
				
				ary[tmp] = result[tmp];
			}
			
		}
	
	}

}
