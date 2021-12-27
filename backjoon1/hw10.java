package backjoon1;

import java.util.Scanner;

public class hw10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int i = 0;
		int j;
		double result[] = new double[num];
		
		while(i < num) {
			
			int st_num = sc.nextInt();
			double st_ary[] = new double[st_num];
			j = 0;
			while(j < st_num) {
				st_ary[j] = sc.nextDouble();
				j++;
			}
			result[i] = avg_rate(st_ary, st_num);
			i++;
		}
		
		for(int k = 0; k < num; k++) {
			System.out.println(String.format("%.3f", result[k] * 100) + "%");
		}
		
	}
	
	
	public static double avg_rate(double st_ary[], int st_num) {
		
		double avg = 0;
		int st_su = 0;
		
		for(int i = 0; i< st_ary.length; i++) {
			
			avg += st_ary[i];
		}
		avg /= st_ary.length;
		
		for(int i = 0; i< st_ary.length; i++) {
			
			if(avg < st_ary[i]) {
				st_su++;
			}
			
		}
		
		avg = (double)st_su / st_ary.length;
		
		return avg;
	}

}
