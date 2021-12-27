package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back6549 {

	public static long height[];
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			if(num == 0) break;
			
			height = new long[num];
			for(int i = 0 ; i < num; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			SegTree segT = new SegTree();
			segT.makeTree(num);
			
			Arrays.fill(segT.tree, Integer.MAX_VALUE);
			
			segT.init(1, height, 0, height.length-1);
			segT.tree[0]= 0;
			
			sb.append(segT.query(1, 0, height.length-1) + "\n");
		}
		
		System.out.print(sb);
		br.close();
		
	}
	
	
	public static class SegTree{
		
		public static long[] tree;
		
		public void makeTree(int N) {
			double height = Math.ceil(Math.log(N) / Math.log(2)) + 1;
			long nodeCount = Math.round(Math.pow(2, height));
			tree = new long[Long.valueOf(nodeCount).intValue()];	
		}
		
		
		static long init(int index, long[] input, int left, int right) {
			
			if(left == right) {
				return tree[index] = height[left];
			}
			
			int mid = (left + right) / 2;

			return tree[index] = Math.min(init(index * 2, input, left, mid ), init(index * 2 + 1, input,  mid + 1, right));

		}

		static long query(int index, int left, int right) {
			
			if(left == right) {
				return tree[index];
			}
			
			int mid = (left + right) / 2;
			
			long leftNodeWid = query(index * 2, left, mid); 
			long rightNodeWid = query(index * 2 + 1, mid + 1, right); 
			
			if(leftNodeWid == Integer.MAX_VALUE) leftNodeWid = 0;
			if(rightNodeWid == Integer.MAX_VALUE) rightNodeWid = 0;
			long max = Math.max(leftNodeWid, rightNodeWid);
			
			int leftGo = mid;
			int rightGo = mid;
			
			long Hei = height[mid];
			long maxArea = Hei;
			
			while(left < leftGo && right > rightGo) {
								
				if(height[leftGo - 1] < height[rightGo + 1]) {
					rightGo++;
					Hei = Math.min(Hei, height[rightGo]);
				}
				else {
					leftGo--;
					Hei = Math.min(Hei, height[leftGo]);
				}
			
				
				maxArea = Math.max(maxArea, Hei * (rightGo - leftGo + 1));
			}
			
			while(rightGo < right) {
				rightGo++;
				Hei = Math.min(Hei, height[rightGo]);
				maxArea = Math.max(maxArea, Hei * (rightGo - leftGo + 1));
			}
			while(leftGo > left) {
				leftGo--;
				Hei = Math.min(Hei, height[leftGo]);
				maxArea = Math.max(maxArea, Hei * (rightGo - leftGo + 1));
			}
			
			
			maxArea = Math.max(maxArea, max);
			return maxArea;

		}
	
	}

}
