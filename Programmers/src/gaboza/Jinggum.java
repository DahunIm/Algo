package gaboza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Jinggum {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int[] ary = new int[10];
		int low = Integer.MAX_VALUE;
		int high = 0;
		int mid = 0;
		int k = 3;
		int answer = 0;
		for(int i = 0; i <= 9 ; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i <= 9; i++) {
			low = Math.min(low, ary[i]);
			high = Math.max(high, ary[i]);
		}
System.out.println( low + " " + high);
		while(low <= high) {
			mid = (low + high) / 2;
			
			if(!bridge(ary, k, mid)) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
				answer = Math.max(answer, mid);
			}
		}

		System.out.println(answer);
		
	}
	
	public static boolean bridge(int[] ary, int k, int mid) {
		
		int count = 0;
		
		for(int stone : ary) {
			
			if(stone < mid) count++;
			else {
				count = 0;
			}
			if(count == k) return false;
		}
		
		
		
		
		return true;
	}

}
