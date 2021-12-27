package backjoon_algo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class queue2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int num = sc.nextInt();
		Deque<Integer> deq = new LinkedList<>();
		
		for(int i = 1; i <= num ; i++) {
			deq.addLast(i);
		}

		while(deq.size() != 1) {
			deq.removeFirst();
			deq.addLast(deq.removeFirst());			
		}
		sb.append(deq.peek());
		System.out.println(sb);
		sc.close();	
	}
}
