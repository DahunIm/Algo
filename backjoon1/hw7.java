package backjoon1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class hw7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> intList = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			intList.add(sc.nextInt() % 42);
		}
		
		intList = new ArrayList<Integer>(new HashSet<Integer>(intList));
		
		System.out.println(intList.size());
		
	}

}