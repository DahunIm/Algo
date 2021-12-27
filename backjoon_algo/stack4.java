package backjoon_algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class stack4 {
	public static BufferedReader br;
	public static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = "";
		Stack<Character> stack = new Stack<>();
		char tmp;
		while(!s.equals(".")) {
			
			s = br.readLine();
			if(s.equals(".")) {
				break;
			}
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '(') {
					stack.push('(');
				}
				else if(s.charAt(i) == ')') {
					if(stack.isEmpty()) {
						bw.write("no" + "\n");
						break;
					}
					tmp = stack.pop();
					if(tmp != '(') {
						bw.write("no" + "\n");
						break;
					}
				}
				else if(s.charAt(i) == '[') {
					stack.push('[');
				}
				else if(s.charAt(i) == ']') {
					if(stack.isEmpty()) {
						bw.write("no" + "\n");
						break;
					}
					tmp = stack.pop();
					if(tmp != '[') {
						bw.write("no" + "\n");
						break;
					}
				}
				if(i == s.length() - 1 && stack.isEmpty()) {
					bw.write("yes" + "\n");
				}
				else if(i == s.length() - 1 && !stack.isEmpty()) {
					bw.write("no" + "\n");
				}
			}

			stack.clear();
		}
		bw.flush();
		bw.close();
		
	}
}
// (([())])
