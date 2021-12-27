package backjoon_algo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class heap4 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = sc.nextInt();
		PriorityQueue<Integer> max_queue = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> min_queue = new PriorityQueue<>();
		
		for(int i = 1; i <= num; i++) {
			
			int input = sc.nextInt();
			if(min_queue.size() == 0 || min_queue.peek() > input) max_queue.add(input);
			else if(min_queue.peek() <= input) min_queue.add(input);
			if(max_queue.size() - min_queue.size() >= 2) min_queue.add(max_queue.poll());
			if(min_queue.size() > max_queue.size()) max_queue.add(min_queue.poll());
			
			if(i % 2 != 0) bw.write(max_queue.peek() + "\n");
			else {
				int result = max_queue.peek() > min_queue.peek() ? min_queue.peek() : max_queue.peek();
				bw.write(result + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		sc.close();
	}
}
