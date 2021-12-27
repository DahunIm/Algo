package backjoon1;

import java.util.Scanner;

public class hw20 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ob_num = sc.nextInt();
		
		int room = 1;
		int stage = 1;
		

		
		room = find_stage(ob_num);
		
		System.out.println(room);
		
		
	}
	
	
	public static int find_stage(int num) {
		
		int result_stage = 1;
		int stage_end = 1;
		
		while(stage_end < num) {
			
	
			stage_end += result_stage  * 6; 
			result_stage++;
			
			
		}
		
		
		
		return result_stage;
	}

}
