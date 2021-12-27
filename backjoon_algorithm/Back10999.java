package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back10999 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] input = new int[N];
		for( int i = 0 ; i < N ; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		segT segt = new segT(N);
		segt.init(1, input, 0, input.length-1);
		
		for(int i = 0 ; i < M + K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int num1 = Integer.parseInt(st.nextToken());
			
			switch (num1) {
			case 1:
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int target = Integer.parseInt(st.nextToken());
				segt.query1(1, target, start-1, end-1, 0, input.length-1);
				break;
			case 2:
				int stN = Integer.parseInt(st.nextToken());
				int endN = Integer.parseInt(st.nextToken());
				sb.append(segt.query2(1, stN-1, endN-1, 0, input.length-1) + "\n");
				break;
			}
		}
		
		System.out.print(sb);
		br.close();
	}

	
	public static class segT{
		
		public static long[] tree;
		public static long[] lazy;
		
		public segT(int N) {
			double height = Math.ceil(Math.log(N)/ Math.log(2)) + 1;
			long nodeCount = Math.round(Math.pow(2, height));
			tree = new long[Long.valueOf(nodeCount).intValue()];
			lazy = new long[Long.valueOf(nodeCount).intValue()];
		}
		
		long init(int index, int[] input, int left, int right) {
			
			if(left == right) {
				return tree[index] = input[left];
			}
			
			int mid = (left + right) / 2;
			return tree[index] = init(index * 2, input, left, mid) + init(index * 2 + 1, input, mid + 1, right);
		
		}
		
		void query1(int index, int targetNum, int start, int end, int left, int right) {
			lazyUpdate(index, left, right);
			
			if(left > end || right < start) {
				return;
			}
			if(left >= start && right <= end) {
				lazy[index] += targetNum;
				lazyUpdate(index, left, right);
				return;
			}
			
			int mid = (left + right) / 2;
			query1(index * 2, targetNum, start, end, left, mid);
			query1(index * 2 + 1, targetNum, start, end, mid + 1, right);
			tree[index] = tree[index * 2] + tree[index * 2 + 1];			
		}
		
		
		
		long query2(int index, int start, int end, int left, int right) {
			lazyUpdate(index, left, right);
			
			if(left > end || right < start) {
				return 0;
			}
			
			if(start <= left && end >= right) {
				return tree[index];
			}
			
			int mid = (left + right) / 2;
			return query2(index * 2, start, end, left, mid) + query2(index * 2 + 1, start, end, mid + 1, right);
			
		}
		
		public void lazyUpdate(int index, int start, int end) {
			if(lazy[index] == 0) {
				return;
			}
			
			tree[index] += (end - start + 1) * lazy[index];
			if(end != start) {
				lazy[index * 2] += lazy[index];
				lazy[index * 2 + 1] += lazy[index];
			}
			
			lazy[index] = 0;
		}
		
		
	}
}
