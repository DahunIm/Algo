package backjoon_algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class stack2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		for(int i = 0; i < num; i++) {
			
			int input_num = Integer.parseInt(br.readLine());
			if(input_num == 0) {
				stack.pop();
			}
			else {
				stack.push(input_num);
			}
			
		}
		while(!stack.empty()) {
			sum += stack.pop();
		}
		bw.write(sum + "\n");
		bw.flush();
		bw.close();
	}
}
