package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back10868 {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st= new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] input = new int[N];
		for(int i = 0 ; i < N ; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Segt seg = new Segt(N);
		seg.init(1, input, 0, input.length-1);

		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sX = Integer.parseInt(st.nextToken());
			int sY = Integer.parseInt(st.nextToken());
			sb.append(seg.searchMin(1, sX-1, sY-1, 0, input.length-1) + "\n");
		}
		
		System.out.print(sb);
		br.close();
		
	}

	
	
	public static class Segt {
		public static int[] tree;
		
		public Segt(int N) {
			double height = Math.ceil(Math.log(N) / Math.log(2)) + 1;
			long nodeCount = Math.round(Math.pow(2, height));
			tree = new int[Long.valueOf(nodeCount).intValue()];
		}
		
		public static int init(int index, int[] input, int left, int right) {
			
			if(left == right) {
				return tree[index] = input[left];
			}
			
			int mid = (left + right) / 2;
			return tree[index] = Math.min(init(index * 2, input, left, mid), init(index * 2 + 1, input, mid + 1, right));
	
		}
		
		
		public static int searchMin(int index, int start, int end, int left, int right) {
			
			if(left >= start && right <= end) {
				return tree[index];
			}
			
			int mid = (left + right) / 2;
			int min = Integer.MAX_VALUE;
			if(start <= mid) min = Math.min(min, searchMin(index * 2, start, end, left, mid));
			if(end > mid) min = Math.min(min, searchMin(index * 2 + 1, start, end, mid + 1, right));
			
			return min;
		}
		
		
		
	}
}
