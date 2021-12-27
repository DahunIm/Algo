package backjoon_algo;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class stack6 {
	
	public static StringBuilder sb;
	public static Stack <Integer> stack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int num = sc.nextInt();
		
		int ary[] = new int[num];
		stack = new Stack<>();
		for(int i = 0 ; i < num ; i++) {
			ary[i] = sc.nextInt();
		}
		
		for(int i = 0; i < ary.length; i++) {
			
			while(!stack.isEmpty() && ary[stack.peek()] < ary[i]) {
				ary[stack.pop()] = ary[i];
			}
			
			stack.push(i);
		}
	    
		while(!stack.isEmpty()) {
			ary[stack.pop()] = -1;
		}
		
		for(int i = 0; i < ary.length - 1; i++) {
			sb.append(ary[i] + " ");
		}
		sb.append(ary[ary.length-1]);
		
		System.out.println(sb);
		sc.close();
	}
	
}
