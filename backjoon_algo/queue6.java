package backjoon_algo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class queue6 {
	public static int ary[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int tmp;
		int count = 0;
		Deque<Integer> deque = new LinkedList<>();
		ary = new int[N];
		for(int i = 1; i <= N; i++) {
			deque.addLast(i);
			ary[i-1] = i;
		}
		
		for(int i = 0; i < M ; i++) {
			tmp = sc.nextInt();
			int val = calc_distance(tmp);
			count += count_move(deque, val, tmp);
			deque.removeFirst();
			del_ary();
		}	
		
		System.out.println(count);
		sc.close();
	}

	public static int calc_distance(int num) {
		int i = 0;
		while(ary[i] == 0) {
			i++;
		}
		
		int st_index = i;
		while(ary[i] != 0) {
			if(ary[i] == num) break;
			i++;
		}
		
		int front = Math.abs(i - st_index);
		int back = (ary.length - 1) - i;
		
		if(front > back) return 1;
		else return 0;
	}
	
	public static int count_move(Deque<Integer> deq, int num, int target) {
		
		int count = 0;
		if(deq.peekFirst() == target) return count;
		if(num == 1) {
			while(deq.peekFirst() != target) {
				deq.addFirst(deq.removeLast());
				ary_fmove();
				count++;
			}
			return count;
		}
		else {
			while(deq.peekFirst() != target) {
				deq.addLast(deq.removeFirst());
				ary_bmove();
				count++;
			}	
			return count;
		}
	}
	public static void ary_fmove() {
		int i = 0;
		while(ary[i] == 0) {
			i++;
		}
		int tmp = ary[ary.length-1];
		for(int j = ary.length - 2; j >= i; j--) {
			ary[j + 1] = ary[j];
		}
		ary[i] = tmp;
			
	}
	public static void ary_bmove() {
		int i = 0;
		while(ary[i] == 0) {
			i++;
		}
		int tmp = ary[i];
		for(int j = i; j < ary.length - 1; j++) {
			ary[j] = ary[j + 1];
		}
		ary[ary.length - 1] = tmp;
			
	}
	public static void del_ary() {
		
		int i = 0;
		while(ary[i] == 0) {
			i++;
		}
		ary[i] = 0;
	}
}

