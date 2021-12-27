package backjoon_algo;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class queue4 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int num = sc.nextInt();
		int count, N, M;
		for(int i = 0; i < num; i++) {
			count = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			Deque<Integer> deque = new LinkedList<>();
			int ary[] = new int[N];
			
			for(int j = 0; j < N; j++) {
				deque.addLast(j+1);
				ary[j] = sc.nextInt();
			}
			
			while(!deque.isEmpty()) {
				
				if(check_joong(ary[deque.peek() - 1], ary)) {
					int tmp = deque.removeFirst();
					ary[tmp - 1] = 0;
					count++;
					if(tmp == M + 1) {
						sb.append(count + "\n");
						break;
					}
				}
				else {
					deque.addLast(deque.removeFirst());
				}
			}
		}
		System.out.print(sb);
		sc.close();
	}

	public static boolean check_joong(int val, int ary[]) {
		int max = val;
		for(int i = 0; i < ary.length; i++) {
			if(ary[i] > max) {
				return false;
			}
		}
		return true;
	}
}
