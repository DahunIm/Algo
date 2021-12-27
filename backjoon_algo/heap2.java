package backjoon_algo;

import java.util.PriorityQueue;
import java.util.Scanner;

public class heap2 {

		public static StringBuilder sb;
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			sb = new StringBuilder();
			
			int num = sc.nextInt();
			PriorityQueue<Integer> p_queue = new PriorityQueue<>();
			Integer empty;
			for(int i = 1; i <= num; i++) {
				
				int input = sc.nextInt();
				
				if(input == 0) {
					empty = p_queue.poll();
					if(empty == null) {
						sb.append("0\n");
					}
					else {
						sb.append(empty + "\n");
					}
				}
				else {
					p_queue.add(input);
				}
			}
			
			System.out.print(sb);
			sc.close();
		}
}
