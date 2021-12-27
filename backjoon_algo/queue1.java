package backjoon_algo;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class queue1 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Deque<Integer> deque = new LinkedList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine());
		for(int i = 0; i < num ; i++) {
			
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			
			String cmd = st.nextToken();
			switch(cmd) {
				case "push":
					int val = Integer.parseInt(st.nextToken());
					deque.offerLast(val);
					break;
				case "pop":
					Integer tmp = deque.pollFirst();
					if(tmp == null) {
						sb.append("-1\n");
					}
					else {
						sb.append(tmp + "\n");
					}
					break;
				case "size":
					sb.append(deque.size() + "\n");
					break;
				case "empty":
					if(deque.isEmpty()) {
						sb.append("1\n");
					}
					else {
						sb.append("0\n");
					}
					break;
				case "front":
					if(deque.size() == 0) {
						sb.append("-1\n");
					}
					else {
						sb.append(deque.peek() + "\n");
					}
					break;
				case "back":
					if(deque.size() == 0) {
						sb.append("-1\n");
					}
					else {
						sb.append(deque.peekLast() + "\n");
					}
					break;
				default:
					System.out.println("Error!");
					break;
			}
		}
		System.out.print(sb);	
	}
}
