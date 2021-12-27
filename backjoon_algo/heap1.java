package backjoon_algo;

import java.util.Scanner;

public class heap1 {

	public static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		
		int num = sc.nextInt();
		int[] heap_ary = new int[num + 1];
		int index = 0;
		for(int i = 1; i <= num; i++) {
			
			int input = sc.nextInt();
			
			if(input == 0) {
				index = printheap(heap_ary, index);
			}
			else {
				insert_tree(heap_ary, input, index);
				index++;
			}
			for(int j = 1; j <= index; j++) {
				System.out.print(heap_ary[j] + " " + index + "\\ ");
			}
			System.out.println();
		}
		
		System.out.print(sb);
		sc.close();
	}
	
	public static int printheap(int[] ary, int index) {
		if(ary[1] == 0) {
			sb.append("0\n");
			return index;
		}
		else {
			sb.append(ary[1] + "\n");
			delete_tree(ary, index);
			index--;
			return index;
		}
	}

	public static void insert_tree(int[] ary, int val, int index) {
		
			index++;
			ary[index] = val;
			int tmp;
			
			while(index > 1 && (ary[index] > ary[ index / 2])){
				tmp = ary[index];
				ary[index] = ary[index / 2];
				ary[index / 2] = tmp;
				index /= 2;
			}
		
	}
	
	public static void delete_tree(int[] ary, int index) {
		
		if( index == 1) {
			ary[1] = 0;
			return;
		}
		ary[1] = ary[index];
		ary[index] = 0;
		int i =1;
		int tmp;
		while( i * 2 <= index) {
			if(i * 2 + 1 > index && ary[i] < ary[i * 2]) {
				tmp = ary[i];
				ary[i] = ary[i * 2];
				ary[i * 2] = tmp;
			}
			else {
				if(ary[i* 2] >= ary[i * 2 + 1] && ary[i] < ary[i * 2]) {
					tmp = ary[i];
					ary[i] = ary[i * 2];
					ary[i * 2] = tmp;
				}
					
				else if(ary[i * 2 + 1] > ary[i * 2] && ary[i] < ary[i * 2 + 1]) {
					tmp = ary[i];
					ary[i] = ary[i * 2 + 1];
					ary[i * 2 + 1] = tmp;
				}
			}
			i *= 2;
		}
	}
	
}
