package backjoon_algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class stack1 {
	public static int stack[] = new int [10000];
	public static int top;
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		top = -1;
		
		for(int i = 0; i < num; i++) {
			
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			String cmd = st.nextToken();
			if(cmd.equals("push")) {
				int input_num = Integer.parseInt(st.nextToken());
				push(input_num);
			}
			else if(cmd.equals("pop")){
				pop();
			}
			else if(cmd.equals("size")) {
				size();
			}
			else if(cmd.equals("empty")) {
				is_empty();
			}
			else if(cmd.equals("top")) {
				top();
			}
			else {
				System.out.println("Command Error!!");
				break;
			}
		}
		bw.flush();
		bw.close();
		
	}
	
	public static void push(int num) {
		stack[++top] = num;
	}
	
	public static void pop() throws IOException {
		if(top == -1) {
			bw.write("-1" + "\n");
		}
		else {
			bw.write(stack[top] + "\n");
			stack[top--] = 0;
		}
	}
	
	public static void size() throws IOException {
		bw.write((top + 1) + "\n");
	}
	
	public static void is_empty() throws IOException {
		if(top == -1) {
			bw.write('1' + "\n");
		}
		else {
			bw.write('0' + "\n");
		}
	}
	
	public static void top() throws IOException {
		if(top == -1) {
			bw.write("-1" + "\n");
		}
		else {
			bw.write(stack[top] + "\n");
		}
	}
}
