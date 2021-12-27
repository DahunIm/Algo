package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back14727 {

	public static long[] input;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		input = new long[num];
		segmentTree segT = new segmentTree(num);
		
		for(int i = 0 ; i < num; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		segT.init(1, 0, input.length-1, input);
		System.out.println(segT.query(1, 0, input.length-1, input));
		br.close();
	}

	
	static class segmentTree{
		
		long[] tree;
		
		segmentTree(int N){
			double height = Math.ceil(Math.log(N) / Math.log(2)) + 1;
			long nodeCount = Math.round(Math.pow(2, height));
			tree = new long[(int)nodeCount];
		}
		
		long init(int index, int start, int end, long[] input) {
			
			if(start == end) {
				tree[index] = input[start];
				return tree[index];
			}
			
			int mid = (start + end) / 2;
			
			return tree[index] = Math.min(init(index * 2, start, mid, input), init(index * 2 + 1, mid + 1, end, input));
			
		}
		
		long query(int index, int start, int end , long[] input) {
			
			if(start == end) return tree[index];
			
			int mid = (start + end) / 2;
			long max = 0;
			
			long leftWid = query(index * 2, start, mid, input);
			long rightWid = query(index * 2 + 1, mid + 1, end, input);
		
			max = Math.max(leftWid, rightWid);
			int leftIndex = mid;
			int rightIndex = mid;
			long hei = input[mid];
			long midWid = input[mid];
			
			while(leftIndex > start && rightIndex < end) {
			
				if(input[leftIndex - 1] < input[rightIndex + 1]) {
					rightIndex++;
					
					hei = Math.min(hei, input[rightIndex]);
				}
				else {
					leftIndex--;
					
					hei = Math.min(hei, input[leftIndex]);
				}
				
				
				midWid = Math.max(midWid, hei * (rightIndex - leftIndex + 1));
					
			}
			
			while(rightIndex < end) {
				rightIndex++;
				
				hei = Math.min(hei, input[rightIndex]);
				midWid = Math.max(midWid, hei * (rightIndex - leftIndex + 1));
				
			}	
			
			while(leftIndex > start) {
				leftIndex--;
				
				hei = Math.min(hei, input[leftIndex]);
				midWid = Math.max(midWid, hei * (rightIndex - leftIndex + 1));			
			}
			
			
			return max = Math.max(midWid, max);	
		}
		
	}
	
	
}
