package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back7469 {

	static class segmentTree{
		
		static List<Integer>[] tree;
		
		@SuppressWarnings("unchecked")
		segmentTree(int N){
			double height = Math.ceil(Math.log(N)/ Math.log(2)) + 1;
			long nodeCnt = Math.round(Math.pow(2, height));
			tree = new List[(int)nodeCnt];
		}
		
		public List<Integer> init(int index, int start, int end, int[] input) {
			
			if(start == end) {
				tree[index] = new ArrayList<Integer>();
				tree[index].add(input[start - 1]);
				return tree[index];
			}
			
			int mid = (start + end) / 2;			
			return tree[index] = merge(init(index * 2, start, mid, input), init(index * 2 + 1, mid+1, end, input));		
		}
		
		public List<Integer> merge(List<Integer> leftList, List<Integer> rightList){
			
			List<Integer> mL = new ArrayList<>();
			int i = 0, j = 0;
			while(i < leftList.size() && j < rightList.size()) {
				if(leftList.get(i) <= rightList.get(j)) {
					mL.add(leftList.get(i++));
				}
				else {
					mL.add(rightList.get(j++));
				}
			}
			
			while(i < leftList.size()) {
				mL.add(leftList.get(i++));
			}
			while(j < rightList.size()) {
				mL.add(rightList.get(j++));
			}
			
			return mL;
		}
		
		public int query(int k, int index, int left, int right, int start, int end){
			if(right < start || left > end) return 0;
			if(left <= start && right >= end) return upperBound(tree[index], k);
			int mid = (start + end) / 2;
			return query(k, index* 2, left, right, start, mid) + query(k, index * 2 + 1, left, right, mid+1, end);		
		}
		
		public int upperBound(List<Integer> list, int k) {
			
			int len = list.size();
			
			int left = 0, right = len-1, mid = 0;
			
			if(list.get(left) > k) return 0;
			else if(list.get(right) < k ) return len;
			
			while(left < right) {
				if(list.get(mid) <= k) left = mid+1;
				else right = mid;
				mid = (left + right) / 2;
				if(right == mid) {
					if(list.get(mid) <= k) return len;
					else return mid;
				}
				
			}
			
			return left + 1;
			
		}
	}
	
	public static int N,M;
	public static int[] ary;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ary = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		segmentTree segT = new segmentTree(N);
		segT.init(1, 1, ary.length, ary);
		
		
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sIn = Integer.parseInt(st.nextToken());
			int eIn = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			
			int leftNum = (int)-1e9;
			int rightNum = (int)1e9;
			
			while(leftNum <= rightNum) {
				int mid = (leftNum + rightNum) / 2;
				
				int result = segT.query(mid, 1, sIn, eIn, 1, ary.length);
				
				if(result < index) {
					leftNum = mid + 1;
				}
				else {
					rightNum = mid - 1;
				}				
			}
			sb.append(leftNum + "\n");

		}
		System.out.print(sb);
		br.close();		
	}
	

}
