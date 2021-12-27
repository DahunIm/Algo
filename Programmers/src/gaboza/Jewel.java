package gaboza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Jewel {
	
	
	public static int min_length = Integer.MAX_VALUE;
	public static ArrayList<String> tmp = new ArrayList<>();
	public static Map<String, Integer> compare_gem = new HashMap<>();
	public static ArrayList<String> gem_kinds;
	public static String[] gems = {"DIA", "EM", "EM", "RUB", "DIA"};
	public static int[] tmp_result = new int[2];
	
	public static void main(String[] args) {

		gem_kinds = new ArrayList<String>();
		int[] answer = {};
		answer = new int[2];

		for(int i = 0; i < gems.length; i++) {
			if(!gem_kinds.contains(gems[i])) {
				gem_kinds.add(gems[i]);
			}
		}
	
		calc(0, 0, 0, answer);
		System.out.println(answer[0] + " " + answer[1]);
		
	}
	
	public static void calc(int a_index, int b_index, int length, int[] answer) {
		
		while(b_index <= gems.length) {
			if(gem_kinds.size() != compare_gem.size()) {
				if(b_index == gems.length) break;
				compare_gem.put(gems[b_index], b_index);
				tmp.add(gems[b_index]);
			    b_index++;
				length++;
			}
			if(gem_kinds.size() == compare_gem.size()) {
				if(length < min_length) {
					answer[0] = a_index + 1;
					answer[1] = b_index;
					min_length = length;
				}
				a_index++;
				length--;
				String tmp_gem = tmp.remove(0);
				if(compare_gem.get(tmp_gem) == a_index - 1){
					compare_gem.remove(tmp_gem);
				}
			}
		}	
	}
}
