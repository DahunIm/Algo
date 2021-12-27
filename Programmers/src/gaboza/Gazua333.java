package gaboza;

import java.util.*;

public class Gazua333 {

	public static void main(String[] args) {
		
		String answer = "";
		String[] cmd = {"D 97","C","U 3","C","D 2","C","U 2","Z","Z"};
		int n = 100; // 행 개수
		int k = 2; // 시작 행 위치
		
		
		ArrayList<Integer> num_list = new ArrayList<>();
		
		for(int i = 0 ; i < n; i++) {
			num_list.add(i);
		}
		Stack<Integer> Z_stack = new Stack<>();
		int u_d = 0;
		for(String tmp_cmd: cmd) {
			switch(tmp_cmd.charAt(0)) {
			case 'U': 
				u_d = Integer.parseInt(tmp_cmd.substring(2, tmp_cmd.length())); 
				k -= u_d;	
				break;
			case 'D': 
				u_d = Integer.parseInt(tmp_cmd.substring(2, tmp_cmd.length())); 
				k += u_d;
				break;
			case 'C':
				if(k == num_list.size() - 1) {
					Z_stack.add(num_list.remove(k));
					Z_stack.add(k);
					k -= 1;
				}
				else {
					Z_stack.add(num_list.remove(k));
					Z_stack.add(k);
				}
				break;
			case 'Z':
				int input_index = Z_stack.pop();
				if(input_index <= k) k += 1;
				num_list.add(input_index, Z_stack.pop());
				break;
			}	
		}
		
		/*if(num_list.get(0) == 0) {
			answer += "O";
		}
		else {
			for(int i = 0; i < num_list.get(0); i++) {
				answer += "X";
			}
			answer += "O";
		}
		for(int i = 1; i < num_list.size(); i++) {	
			if(answer.length() == num_list.get(i)) answer += "O";
			else {
				for(int j = answer.length(); j < num_list.get(i); j++) {
					answer += "X";
				}
				answer += "O";
			}
		}
		if(num_list.get(num_list.size()-1) != n - 1) {
			for(int i = num_list.get(num_list.size() - 1) + 1 ; i < n; i++) {
				answer += "X";
			}
		}
		*/
		
		int ans_index = 0;
		int size = num_list.size();
		while(answer.length() < n && ans_index < size) {
			if(answer.length() == num_list.get(ans_index)) {
				answer += "O";
				ans_index++;
			}
			else answer += "X";		
		}
		
		while(answer.length() < n) {
			answer += "X";
			System.out.println(answer.length());
		}
		
		System.out.println(answer);		
	}
}
