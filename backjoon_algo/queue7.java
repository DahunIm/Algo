package backjoon_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class queue7 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int line_num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < line_num; i++) {
			
			String command = br.readLine();
			int val_num = Integer.parseInt(br.readLine());
			String str_in = br.readLine();
			str_in = str_in.substring(1, str_in.length() - 1);
			StringTokenizer st = new StringTokenizer(str_in, ",");
			Deque<Integer> deque = new LinkedList<>();
			int error = 0;
			int R = 0;
			
			if( val_num == 0) {
				if(command.contains("D")) error = 1;
			}
			
			else {
				for(int j = 0; j < val_num; j++) {
					deque.addLast(Integer.parseInt(st.nextToken()));
				}
				for(int j = 0; j < command.length() ; j++) {
					error = 0;
					switch(command.charAt(j)) {
						case 'R':	// 이걸 간단하게 구현해야 가능
							R++;
							break;
						case 'D':
							if(deque.isEmpty()) error = 1;
							else if(R % 2 == 0) deque.removeFirst();
							else if(R % 2 == 1) deque.removeLast();
							break;
					}
					if(error == 1) {
						break;
					}
				}
				
			}
			StringBuilder sb = new StringBuilder();
			if(error == 1) {
				sb.append("error");
			}
			else {
				sb.append("[");
				while(deque.size() > 1 && R % 2 == 0) {
					sb.append(deque.removeFirst() + ",");
				}
				
				while(deque.size() > 1 && R % 2 != 0) {
					sb.append(deque.removeLast() + ",");
				}
				if(deque.size() != 0)sb.append(deque.removeFirst());
				sb.append("]");
			}		
			System.out.println(sb);
		}
	}
}
