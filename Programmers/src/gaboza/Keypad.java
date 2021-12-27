package gaboza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Keypad {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String hand = "left";
		String answer = "";
		int[] left_loc = {3, 0};
		int[] right_loc = {3, 2};
		
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		
		for(int i = 0; i < numbers.length; i++) {
			answer += use_finger(hand, left_loc, right_loc, numbers[i]);
		}
		
		System.out.println(answer);
		
	}

	public static char use_finger(String hand, int[] left_loc, int[] right_loc, int number) {
		
		char value = '\0';
		int left_dis = 0;
		int right_dis = 0;
		int tmp_num = 0;
			if(number == 0 || number == 2 || number == 5 || number == 8) {
				if(number == 0) tmp_num = 3;
				else tmp_num = number / 3;
				left_dis = Math.abs(tmp_num - left_loc[0]) + Math.abs(1 - left_loc[1]);
				right_dis = Math.abs(tmp_num - right_loc[0]) + Math.abs(1 - right_loc[1]);
				if(left_dis == right_dis) {
					if(hand.equals("right")) {
						right_loc[0] = tmp_num;
						right_loc[1] = 1; 
						value = 'R';
					}
					else {
						left_loc[0] = tmp_num;
						left_loc[1] = 1;
						value = 'L';
					}
				}
				else if(left_dis < right_dis){
					left_loc[0] = tmp_num;
					left_loc[1] = 1;
					value = 'L';
				}
				else {
					right_loc[0] = tmp_num;
					right_loc[1] = 1; 
					value = 'R';
				}
			}
			else if(number == 1 || number == 4 || number == 7){
				left_loc[0] = number / 3;
				left_loc[1] = 0;
				value = 'L';
			}
			else {
				right_loc[0] = (number / 3) - 1;
				right_loc[1] = 2; 
				value = 'R';
			}
		System.out.print(left_loc[0] + " " + left_loc[1]);
		System.out.println("     " + right_loc[0] + " " + right_loc[1]);
		return value;
	}
}
