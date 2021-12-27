package backjoon1;

import java.util.Scanner;

public class hw21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int index = sc.nextInt();
		
		int stage = 1;
		int stage_end= 1;
		int deno, numer;
		while(stage_end < index){
			
			stage++;
			stage_end += stage;
			
		}
		
		if(stage % 2 == 0) {
			deno = 1 + (stage_end - index);
			numer = stage - (stage_end - index);
		}
		
		else {
			deno = stage - (stage_end - index);
			numer = 1 + (stage_end - index);
		}
		
		System.out.println(numer + "/" + deno);
		
	}

}
