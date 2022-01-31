package gaboza;

import java.util.ArrayList;
import java.util.Collections;

public class DevLotto {

	public static void main(String[] args) {
		int[] ary = {45,4,35,20,3,9};
		int[] ary2 = {20,9,3,45,4,35};
		int[] result = Solution(ary, ary2);
		
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

	public static int[] Solution(int[] lottos, int[] win_nums) {
		
		int[] answer = {};
		
		int zero = 0;
		
		int count = 0;
		int min = 0;
		int max = 0;
		
		ArrayList<Integer> lList = new ArrayList<>();
		ArrayList<Integer> wList = new ArrayList<>();
		
		for(int i = 0 ; i < 6; i++) {
			lList.add(lottos[i]);
			wList.add(win_nums[i]);
			
			if(lottos[i] == 0 ) zero++;
			
		}
		
		Collections.sort(lList);
		Collections.sort(wList);
		
		for(int i = zero; i< 6; i++) {			
			for(int j = 0 ; j < 6 ; j++) {
				if(lList.get(i) == wList.get(j)) {
					count++;				
					break;
				}
				if(lList.get(i) < wList.get(j)) break;
			}	
		}
		
		max = 7 - (zero + count);
		min = 7 - count;

		
		if(max >= 6) max = 6;
		if(min >= 6) min = 6;
		
		answer = new int[2];
		answer[0] = max;
		answer[1] = min;
		
		
		return answer;
		
	}
}
