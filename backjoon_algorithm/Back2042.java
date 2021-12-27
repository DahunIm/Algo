package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SegmentTree1{
	
	public static long[] tree;
	
	static void treeMake(int n){
		double height = Math.ceil(Math.log(n) / Math.log(2)) +1 ;
		long nodeCount = Math.round(Math.pow(2, height));
		tree = new long[Long.valueOf(nodeCount).intValue()];
	}

	static long init(int index, long[] input, int left, int right) {
		
		if(left == right) {
			return tree[index] = input[left];
		}
		int mid = (left + right) / 2;
		return tree[index] = init(index * 2, input, left, mid) + init(index * 2+ 1, input, mid + 1, right);
		
	}
	
	static long search(int index, int left, int right, int start, int end) {
		if(left <= start && right >= end) return tree[index];
		int mid = (start + end) / 2;
		long sum = 0;
		if(left <= mid) sum += search(index * 2, left, right, start, mid);
		if(right > mid) sum += search(index * 2 + 1, left, right, mid+1, end);
		
		return sum;		
	}
	
	static void update(int index, int val, int start, int end, long inputNum) {
		if(start == end) {
			if(start == val) tree[index] = inputNum;
			return;
		}

		int mid = (start + end) / 2;
		if(val <= mid) update(index * 2, val, start, mid, inputNum);
		else if(val > mid) update(index * 2 + 1, val, mid+1, end, inputNum);
		tree[index] = tree[index * 2] + tree[index * 2+ 1];
	}
	
}

public class Back2042 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long[] ary = new long[N];
		
		SegmentTree1.treeMake(N);
		for(int i = 0 ; i < N ; i++) {
			ary[i] = Long.parseLong(br.readLine());
		}
		
		SegmentTree1.init(1, ary, 0, ary.length-1);
		
		for(int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			long num3 = Long.parseLong(st.nextToken());
		
			switch (num1) {
			case 1:
				SegmentTree1.update(1, num2 -1, 0, ary.length-1, num3);
				break;
			case 2:
				sb.append(SegmentTree1.search(1, num2-1, Long.valueOf(num3).intValue()-1, 0,  ary.length-1) + "\n");
				break;
			default:
				break;
			}
		
		}
		
		System.out.print(sb);
		br.close();
		
	}

}
