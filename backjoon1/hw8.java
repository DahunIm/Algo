package backjoon1;

import java.util.Scanner;

public class hw8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		double result[] = new double[num];
		int i = 0;
		int index = 0;
		double max = 0;
		while(i < num) {
			result[i] = sc.nextInt();	
			if(max < result[i]) {
				max = result[i];
				index = i;
			}
			i++;
		}
		
		i = 0;
		while(i < num) {
			result[i] = result[i]/max * 100; 
			i++;
		}
		
		System.out.println(avg(result));
	}
	
	public static double avg(double ary[]) {
		
		double avg_result = 0;
		
		for(int i = 0; i < ary.length; i++) {
			avg_result += ary[i];
		}
		
		avg_result /= ary.length;
		
		
		return avg_result;
	}
}
