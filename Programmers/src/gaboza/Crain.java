package gaboza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Crain {

	public static int[][] board;
	public static int[] moves;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		board = new int[num][num];
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < num; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		moves = new int[8];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 8; i++) {
			moves[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(board[0].length);
		System.out.println(solution(board, moves));
	}

	
	public static int solution(int[][] board, int[] moves) {
		int count = 0;
		
		Stack<Integer> stack = new Stack<>();
		int tmp;
		int i, j;
		for(i = 0; i < moves.length; i++) {
			for(j= 0 ; j < board[0].length; j++) {
				if(board[j][moves[i] - 1] != 0) break; 
			}
			if(j == board[0].length) continue;
			else {
				tmp = board[j][moves[i] - 1];
				board[j][moves[i] - 1] = 0;
				if(stack.isEmpty()) {
					stack.push(tmp);
				}
				else if(stack.peek() != tmp) {
					stack.push(tmp);
				}
				else if(stack.peek() == tmp){
					stack.pop();
					count += 2;
				}
			}	
		}
		return count;
	}
}

/*
5
0 0 0 0 0
0 0 1 0 3
0 2 5 0 1
4 2 4 4 2
3 5 1 3 1
1 5 3 5 1 2 1 4
*/