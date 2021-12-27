package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2357 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] ary = new long[N];
		long[] treeMax = {};
		long[] treeMin = {};
		
		SegmentTree1 segmin = new SegmentTree1();
		SegmentTree1 segmax = new SegmentTree1();

		segmin.tree = segmin.makeTree(segmin.tree, N);
		segmax.tree = segmax.makeTree(segmax.tree, N);
		
		for(int i = 0 ; i < N ; i++) {
			ary[i] = Long.parseLong(br.readLine());
		}
		
		SegmentTree1.initMin(segmin.tree, 1, ary, 0, ary.length-1);
		SegmentTree1.initMax(segmax.tree, 1, ary, 0, ary.length-1);
		
		for(int i = 0 ; i < segmin.tree.length; i++) {
			System.out.print(segmin.tree[i] + "     ");
		}
		System.out.println();
		for(int i = 0 ; i < segmin.tree.length; i++) {
			System.out.print(segmax.tree[i] + "     ");
		}
		
//		treeMax = SegmentTree1.makeTree(treeMax, N);
//		treeMin = SegmentTree1.makeTree(treeMin, N);
		
		
//		for(int i = 0 ; i < N ; i++) {
//			ary[i] = Long.parseLong(br.readLine());
//		}
//		
//		SegmentTree1.initMin(treeMin, 1, ary, 0, ary.length-1);
//		SegmentTree1.initMax(treeMax, 1, ary, 0, ary.length-1);
//		
//		for(int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine()," ");
//			int num1 = Integer.parseInt(st.nextToken());
//			int num2 = Integer.parseInt(st.nextToken());
//
//			sb.append(SegmentTree1.searchMin(treeMin, 1, num1-1, num2-1 , 0, ary.length-1) + " " +SegmentTree1.searchMax(treeMax, 1, num1-1, num2-1 , 0, ary.length-1) + "\n");
//		}
//		
//		System.out.print(sb);
//		br.close();
//		
	}
	

public static class SegmentTree1{
	
	public long[] tree;
	
	static long[] makeTree(long[] treeAry, int n){
		double height = Math.ceil(Math.log(n) / Math.log(2)) +1 ;
		long nodeCount = Math.round(Math.pow(2, height));
		treeAry = new long[Long.valueOf(nodeCount).intValue()];
		return treeAry;
	}

	static long initMin(long[] treeAry, int index, long[] input, int left, int right) {
		
		if(left == right) {
			return treeAry[index] = input[left];
		}
		int mid = (left + right) / 2;
		return treeAry[index] = Math.min(initMin(treeAry, index * 2, input, left, mid), initMin(treeAry, index * 2+ 1, input, mid + 1, right));
	
	}
	
	static long initMax(long[] treeAry, int index, long[] input, int left, int right) {
		
		if(left == right) {
			return treeAry[index] = input[left];
		}
		int mid = (left + right) / 2;
		return treeAry[index] = Math.max(initMax(treeAry, index * 2, input, left, mid), initMax(treeAry, index * 2+ 1, input, mid + 1, right));
		
	}
	
	static long searchMin(long[] treeAry, int index, int left, int right, int start, int end) {
		if(left <= start && right >= end) return treeAry[index];
		int mid = (start + end) / 2;
		long min = Integer.MAX_VALUE;
		if(left <= mid) min = Math.min(min, searchMin(treeAry, index * 2, left, right, start, mid));
		if(right > mid) min = Math.min(min, searchMin(treeAry, index * 2 + 1, left, right, mid+1, end));
		
		return min;		
	}
	
	static long searchMax(long[] treeAry, int index, int left, int right, int start, int end) {
		if(left <= start && right >= end) return treeAry[index];
		int mid = (start + end) / 2;
		long max = 0;
		if(left <= mid) max = Math.max(max, searchMax(treeAry, index * 2, left, right, start, mid));
		if(right > mid) max = Math.max(max, searchMax(treeAry, index * 2 + 1, left, right, mid+1, end));
		
		return max;		
	}
	
	static void update(long[] treeAry, int index, int val, int start, int end, long inputNum) {
		if(start == end) {
			if(start == val) treeAry[index] = inputNum;
			return;
		}

		int mid = (start + end) / 2;
		if(val <= mid) update(treeAry, index * 2, val, start, mid, inputNum);
		else if(val > mid) update(treeAry, index * 2 + 1, val, mid+1, end, inputNum);
		treeAry[index] = treeAry[index * 2] + treeAry[index * 2+ 1];
	}
	
	}
}
