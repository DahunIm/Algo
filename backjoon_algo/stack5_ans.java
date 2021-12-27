package backjoon_algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class stack5_ans {
	
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static int ary[];
	public static Stack<Integer> stack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
	    stack = new Stack<>();
		int num = Integer.parseInt(br.readLine());
		int gap = 0;
		ary = new int[num];
	
		for(int i = 0; i < num ; i++) {
			int input_num = Integer.parseInt(br.readLine());
			ary[i] = input_num;

		}

		for(int i =0; i < num; i++) {
			stack.push(i + 1);
			sb.append("+\n");
			while( stack.peek() == ary[gap]) {
				stack.pop();
				sb.append("-\n");
				gap++;
				if(stack.isEmpty()) {
					break;
				}
			}
			
		}
		
		if(stack.isEmpty()) {
			System.out.println(sb);
		}
		else{
			System.out.println("NO");
		}
	}
}
