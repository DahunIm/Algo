package backjoon_algo;

import java.util.PriorityQueue;
import java.util.Scanner;

public class heap3 {
	public static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		int num = sc.nextInt();
		PriorityQueue<Integer> p_queue = new PriorityQueue<>();
		int[] minus = new int[num]; 
		Integer empty;
		int m_index = 0;
		for(int i = 1; i <= num; i++) {
			
			int input = sc.nextInt();
			if(input < 0) {
				minus[m_index] = input;
				m_index++;
			}
			if(input == 0) {
				empty = p_queue.poll();
				if(empty == null) {
					sb.append("0\n");
				}
			
				else {
					int j;
					for(j = 0; j < m_index; j++) {
						if(minus[j] == -empty){
							minus[j] = 0;
							sb.append(-empty + "\n");
							j = m_index + 2;
							break;
						}
					}
					if(j != m_index + 2) sb.append(empty + "\n");
				}
			}
			else {
				p_queue.add(Math.abs(input));
			}
		}
	
		System.out.print(sb);
		sc.close();
	}
}
