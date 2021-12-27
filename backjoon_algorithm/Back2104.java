package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2104 {
	
	
	public static int len;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		len = Integer.parseInt(br.readLine());
		int[] input = new int[len + 1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1 ; i <= len; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		segmentTree segT = new segmentTree(len);
		
		segT.minInit(1, 1, len, input);
		segT.sumInit(1, 1, len, input);

		System.out.println(segT.query(1, len, input));
		br.close();
		
	}
	
	static class segmentTree{
		
		int[] minTree;
		long[] sumTree;
		
		segmentTree(int N){
			double height = Math.ceil(Math.log(N) / Math.log(2)) + 1;
			long nodeCnt = Math.round(Math.pow(2, height));
			minTree = new int[(int)nodeCnt];
			sumTree = new long[(int)nodeCnt];
		}
		
		int minInit(int index, int start, int end, int[] input) {
			
			if(start == end) {
				minTree[index] = start;
				return minTree[index];
			}
			
			int mid = (start + end) / 2;
			
			return minTree[index] = cmpidx(minInit(index *2, start, mid, input), minInit(index * 2 + 1, mid+1, end, input), input);
			
		}
		
		long sumInit(int index, int start, int end, int[] input) {
			
			if(start == end) {
				sumTree[index] = input[start];
				return (long)sumTree[index];
			}
			
			int mid = (start + end) / 2;
			
			return sumTree[index] = sumInit(index *2, start, mid, input) + sumInit(index * 2 + 1, mid+1, end, input);
			
		}
		
		long query(int start, int end, int[] input) {
			
			if(start == end) {				
				return (long)input[start] * (long)input[start];
			}
			int minIdx = query1(1, 1, len, start, end, input);
			long max = input[minIdx] * query2(1, 1, len, start, end);
			if(minIdx > start) max = Math.max(max, query(start, minIdx-1, input)); 
			if(minIdx < end) max = Math.max(max, query(minIdx + 1, end, input));
			
			return max;
		}
		
		int query1(int index, int start, int end, int left, int right, int[] input) {
			
			if(left > end || right < start) return -1;
			
			if(left <= start && right >= end) return minTree[index];
			
			int mid = (start + end) / 2;
			
			return cmpidx(query1(index * 2, start, mid, left, right, input), query1(index * 2 + 1, mid + 1, end, left, right, input), input);
			
		}
		
		long query2(int index, int start, int end, int left, int right) {
			
			if(left > end || right < start) return 0;
			
			if(left <= start && right >= end) return sumTree[index];
			
			long sum = 0;
			int mid = (start + end) / 2;
			
			return sum = query2(index * 2, start, mid, left, right) + query2(index * 2 + 1, mid + 1, end, left, right);
			
		}
		
		int cmpidx(int a, int b, int[] input) {
			if(a == -1) return b;
			if(b == -1) return a;
			if(input[a] < input[b]) return a;
			return b;
		}
		
		
	}

}
