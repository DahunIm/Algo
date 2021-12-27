package backjoon_algo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class queue3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		Deque<Integer> deque = new LinkedList<>();
		
		for(int i = 1; i <= N ; i++) {
			deque.addLast(i);
		}

		sb.append("<");
		
		while(!deque.isEmpty()) {
			
			for(int i = 1; i < K; i++) {
				deque.addLast(deque.removeFirst());
			}
			
			if(deque.size() == 1) {
				sb.append(deque.removeFirst() + ">");
			}
			else {
				sb.append(deque.removeFirst() + ", ");
			}
		}
		System.out.println(sb);
		sc.close();
	}
}
