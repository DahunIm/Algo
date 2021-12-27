package backjoon1;

import java.util.Scanner;

public class hw27 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num_min = sc.nextInt();
		int num_max = sc.nextInt();
		int sum = 0;
		int min = 10001;
		
		for(int i = num_min; i <= num_max; i++) {
			
			if(is_prime(i)) {
				sum += i;
				
				if(i < min) min = i;

			}

	
		}
		
		if(min == 10001) {
			System.out.println("-1");
		}
		else {
			System.out.println(sum);
			System.out.println(min);
		}
		sc.close();
	}

	public static boolean is_prime(int t_num) {
		
		if(t_num == 1) {
			return false;
			
		}
		
		int prime_count = 0;
	
		for(int i = 1; i <= t_num ; i++) {
			
			if(t_num % i == 0) prime_count++;
			
			if(prime_count > 2) return false;
		}
		
		return true;
	}
}
