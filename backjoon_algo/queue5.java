package backjoon_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class queue5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<>();
		
		for(int i = 0; i < num; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			
			switch(st.nextToken()) {
				case "push_front":
					int input = Integer.parseInt(st.nextToken());
					deque.addFirst(input);
					break;
				case "push_back":
					int input_back = Integer.parseInt(st.nextToken());
					deque.addLast(input_back);
					break;
				case "front":
					Integer fr_tmp = deque.peekFirst();
					if(fr_tmp == null) sb.append("-1\n");
					else sb.append(fr_tmp + "\n");
					break;
				case "back":
					Integer bk_tmp = deque.peekLast();
					if(bk_tmp == null) sb.append("-1\n");
					else sb.append(bk_tmp + "\n");
					break;
				case "size":
					sb.append(deque.size() + "\n");
					break;
				case "empty":
					if(deque.isEmpty()) sb.append("1\n");
					else sb.append("0\n");
					break;
				case "pop_front":
					Integer tmp = deque.pollFirst();
					if(tmp == null) sb.append("-1\n");
					else sb.append(tmp + "\n");
					break;
				case "pop_back":
					Integer pb_tmp = deque.pollLast();
					if(pb_tmp == null) sb.append("-1\n");
					else sb.append(pb_tmp + "\n");
					break;
			}
			
		}
		System.out.print(sb);
	}

}
