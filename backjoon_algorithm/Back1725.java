package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1725 {
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] heiAry = new long[N];
		for(int i = 0 ; i < N; i++) {
			heiAry[i] = Integer.parseInt(br.readLine());
		}
		
		segmentTree segT = new segmentTree(N);
		
		segT.init(1, 0, N-1, heiAry);
		System.out.println(segT.query(1, 0, N-1, heiAry));
		br.close();
	}

	static class segmentTree{
		
		long[] tree;
		
		segmentTree(int N){
			double height = Math.ceil(Math.log(N) / Math.log(2)) + 1;
			long nodeCnt = Math.round(Math.pow(2, height));
			tree = new long[(int)(nodeCnt)];
		}
		
		long init(int index, int left, int right, long[] input ) {
			
			if(left == right) {
				tree[index] = input[left];
				return tree[index];	
			}
			
			int mid = (left + right) / 2;
			
			return tree[index] = Math.min(init(index * 2, left, mid, input), init(index * 2 + 1, mid + 1, right, input));
			
		}
		
		long query(int index, int start, int end, long[] heiAry) {
			
			if(start == end) {
				return tree[index];
			}
			
			int mid = ( start + end ) / 2;		
			
			long max = 0;
			long left = 0;
			long right = 0;
			
			left = query(index * 2, start, mid, heiAry);
			right = query(index * 2 + 1, mid + 1, end, heiAry);
			
			long midH = heiAry[mid];
			
			int Lindex = mid;
			int Rindex = mid;
			long midWid = heiAry[mid];
			
			while(Lindex > start && Rindex < end) {
				
				if(heiAry[Lindex - 1] < heiAry[Rindex + 1]) {
					Rindex++;
					midH = Math.min(midH, heiAry[Rindex]);
				}
				else {
					Lindex--;
					midH = Math.min(midH, heiAry[Lindex]);
				}
				
				midWid = Math.max(midWid, midH * (Rindex - Lindex + 1));
				
			}
			
			while(Lindex > start) {
				Lindex--;
				midH = Math.min(midH, heiAry[Lindex]);
				midWid = Math.max(midWid, midH * (Rindex - Lindex + 1));
			}
			while(Rindex < end) {
				Rindex++;
				midH = Math.min(midH, heiAry[Rindex]);
				midWid = Math.max(midWid, midH * (Rindex - Lindex + 1));
			}
			
			max = Math.max(left, right);
			max = Math.max(max, midWid);
			
			
			return max;
		}
		
		
	}
	

}
