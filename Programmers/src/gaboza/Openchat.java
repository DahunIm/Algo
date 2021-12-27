package gaboza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Openchat {

	public static String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
			"Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
	public static ArrayList<String> action = new ArrayList<>();
	public static String[] answer = {};
	public static Map<String, String> hm = new HashMap<String, String>();
	
	public static void main(String[] args) {
		Arrays.fill(answer, "");
		int index = 0;
		String act = "";
		String id = "";
		String name = "";
		int count = 0;
		for(String rec : record) {
			index = 0;
			act = "";
			id = "";
			name = "";
			for(String val : rec.split(" ")) {
				if(index == 0) {
					act = val;
					index++;
				}
				
				else if(index == 1) {
					id = val;
					index++;
				}
				
				else if(index == 2) {
					name = val;
					index++;
				}
				
			}
			if(act.equals("Leave") || act.equals("Enter")) count++;
			if(act.equals("Change") || act.equals("Enter")) {
				hm.put(id, name);
			}		
		}
		
		answer = new String[count];
		String tmp = "";
		int result_index = 0;
		for(String rec : record) {
			index = 0;
			tmp = "";
			act = "";
			id = "";
			name = "";
			for(String val : rec.split(" ")) {
				if(index == 0) {
					act = val;
					index++;
				}
				
				else if(index == 1) {
					id = val;
					index++;
				}
			}
			if(act.equals("Enter")) {
				tmp = hm.get(id) + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
				answer[result_index] = tmp;
				result_index++;
			}
			else if(act.equals("Leave")) {
				tmp = hm.get(id) + "´ÔÀÌ ³ª°¬½À´Ï´Ù.";
				answer[result_index] = tmp;
				result_index++;
			}
		}
		

	}

}
