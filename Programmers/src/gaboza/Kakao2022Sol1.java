package gaboza;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Kakao2022Sol1 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
	    String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int[] result = solution(id_list, report, 2);
		
		for(int i = 0 ; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> hm = new HashMap<String, Integer>();
        Map<String, HashSet<String>> reportMap = new HashMap<>();
        
        int idLen = id_list.length;
        for(int i = 0 ; i < idLen; i++) {
        	hm.put(id_list[i], i);
        }
        
        int reportLen = report.length;
        for(int i = 0 ; i < reportLen; i++) {
        	String[] ids = report[i].split(" ");
        	if(reportMap.get(ids[1]) == null) {
        		HashSet<String> hs = new HashSet<String>();
        		hs.add(ids[0]);
        		reportMap.put(ids[1], hs);
        	}
        	else {
	        	HashSet<String> hs = reportMap.get(ids[1]);
	        	hs.add(ids[0]);
	        	reportMap.put(ids[1], hs);
        	}
        }
        
        for(int i = 0 ; i < idLen; i++) {
        	if(reportMap.get(id_list[i]) == null) continue;
        	if(reportMap.get(id_list[i]).size() >= k) {
        		HashSet<String> hs = reportMap.get(id_list[i]);
        		for(String user : hs) {
        			answer[hm.get(user)]++;
        		}
        	}
        }
          
        return answer;  
    }
    
}
