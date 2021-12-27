package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2243 {

	static class segmentTree{
		static int[] tree;
		static int[] num;
		
		segmentTree(int N){
			double height = Math.ceil(Math.log(N) / Math.log(2)) + 1;
			long treeCount = Math.round(Math.pow(2, height));
			tree = new int[(int)treeCount];
			num = new int[(int)treeCount];
		}
		
		static void init(int index, int left, int right) {
			
			if(left == right) {
				num[index] = left;
				return;
			}
			
			int mid = (left + right) / 2;
			init(index * 2, left, mid);
			init(index * 2+ 1, mid + 1, right);
			
		}
		
		static void update(int index, int val, int start, int end, int inputNum) {
			if(start == end) {
				tree[index] += inputNum;
				return;
			}

			int mid = (start + end) / 2;
			if(val <= mid) update(index * 2, val, start, mid, inputNum);
			else if(val > mid) update(index * 2 + 1, val, mid+1, end, inputNum);
			tree[index] = tree[index * 2] + tree[index * 2+ 1];
		}
		
	}
	
	public static StringBuilder sb = new StringBuilder();
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		segmentTree segT= new segmentTree(1000001);
		segT.init(1, 1, 1000000);
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int cmd = Integer.parseInt(st.nextToken());
			switch (cmd) {
			case 1:
				int candyPop = Integer.parseInt(st.nextToken());
				search(segT, 1, candyPop ,1, 1000000);
				break;

			case 2:
				int candyT = Integer.parseInt(st.nextToken());
				int candyP = Integer.parseInt(st.nextToken());
				segT.update(1, candyT, 1, 1000000, candyP);
				break;
			}
		}
		
		System.out.println(sb);
		br.close();
		
	}
	
	@SuppressWarnings("static-access")
	public static void search(segmentTree segT, int index, int val, int start, int end) {
		if(start == end) {
			segT.tree[index]--;
			sb.append(start + "\n");
			return;
		}

		int mid = (start + end) / 2;
		if(segT.tree[index * 2] >= val) search(segT, index * 2, val, start, mid);
		else search(segT, index * 2 + 1, val - segT.tree[index * 2], mid+1, end);
		segT.tree[index] = segT.tree[index * 2] + segT.tree[index * 2+ 1];
	}

}
