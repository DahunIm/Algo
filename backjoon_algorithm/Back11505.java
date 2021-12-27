package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back11505 {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] input = new long[N];
		for(int i = 0 ; i < N ; i++) {
			input[i] = Long.parseLong(br.readLine());
		}
		
		Segt seg = new Segt(N);
		seg.init(1, input, 0, input.length-1);
		
		for(int i = 0 ; i < M + K ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());
			
			switch (num1) {
			case 1:
				seg.update(1, num2 -1, num3, 0 , input.length-1);
				break;
			case 2:
				sb.append(seg.calcMul(1, num2 - 1, num3 - 1, 0, input.length-1) % 1000000007 + "\n");
				break;
			}
		}
		
		System.out.print(sb);
		br.close();
	}
	
	public static class Segt {
		public static long[] tree;
		
		public Segt(int N) {
			double height = Math.ceil(Math.log(N) / Math.log(2)) + 1;
			long nodeCount = Math.round(Math.pow(2, height));
			tree = new long[Long.valueOf(nodeCount).intValue()];
		}
		
		public static long init(int index, long[] input, int left, int right) {
			
			if(left == right) {
				return tree[index] = input[left];
			}
			
			int mid = (left + right) / 2;
			return tree[index] = (init(index * 2, input, left, mid)% 1000000007) * (init(index * 2 + 1, input, mid + 1, right) % 1000000007);
	
		}
		
		public static void update(int index, int target, int inputnum, int left, int right) {
			
			if(left == right) {
				if(left == target) tree[index] = inputnum;
				return;
			}
			
			int mid = (left + right) / 2;
			if(target <= mid) update(index * 2, target, inputnum, left, mid);
			else if(target > mid) update(index * 2 + 1, target, inputnum, mid + 1, right);
			tree[index] = (tree[index * 2] % 1000000007) * (tree[index * 2 + 1] % 1000000007);

		}
		
		public static long calcMul(int index, int start, int end, int left, int right) {
			if(start <= left && end >= right) {
				return tree[index];
			}
			
			int mid = (left + right) / 2;
			long mul = 1;
			if(start <= mid) {
				mul *= calcMul(index * 2, start, end, left, mid)  % 1000000007;
				mul %= 1000000007;
			}
			if(end > mid) {
				mul *= calcMul(index * 2 + 1, start, end, mid + 1 , right) % 1000000007;
				mul %= 1000000007;
			}
			
			return mul;
		}
		
		
	}
}
