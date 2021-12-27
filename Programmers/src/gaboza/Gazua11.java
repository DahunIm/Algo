package gaboza;

import java.util.*;

public class Gazua11 {

	public static void main(String[] args) {

		
		String s = "123";
		String tmp = "";
		Map<String, String> hm = new HashMap<String, String>();
		
		hm.put("zero", "0");
		hm.put("one", "1");
		hm.put("two", "2");
		hm.put("three", "3");
		hm.put("four", "4");
		hm.put("five", "5");
		hm.put("six", "6");
		hm.put("seven", "7");
		hm.put("eight", "8");
		hm.put("nine", "9");
		
		
		for(int i = 0; i < s.length(); i++) {

			if(s.charAt(i) >= 48 && s.charAt(i) <= 57)  tmp += s.charAt(i);
			else {
				String word_tmp = "";
				int index = i;
				word_tmp += s.charAt(index);
				while(!hm.containsKey(word_tmp)) {
					word_tmp += s.charAt(++index);
				}
				tmp += hm.get(word_tmp);
				i = index;
			}
			
		}
		
		
		System.out.println(tmp);
		
	}

}
	