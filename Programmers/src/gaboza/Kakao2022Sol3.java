package gaboza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Kakao2022Sol3 {

	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		solution(fees, records);
		
		int[] fees1 = {1, 461, 1, 10};
		String[] records1 = {"00:00 1234 IN"};
		solution(fees1, records1);
	}
	
    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        HashMap<String, HashMap<String, String>> hm = new HashMap<>();
        HashMap<String, Integer> result = new HashMap<>();
        List<String> rank = new ArrayList<>();
        
        int count = 0;
        int recordsLen = records.length;
        
        for(int i = 0 ; i < recordsLen; i++) {
        	String[] record = records[i].split(" ");
        	if(!hm.containsKey(record[1])) {
        		HashMap<String, String> inputHm = new HashMap<>();
        		inputHm.put(record[2], record[0]);
        		hm.put(record[1], inputHm);
        	}
        	else {
        		HashMap<String, String> inputHm = hm.get(record[1]);
        		inputHm.put(record[2], record[0]);
        		
        		hm.put(record[1], inputHm);
        		
        	}
        	if(record[2].equalsIgnoreCase("IN")) {
        		if(!rank.contains(record[1])){
        			rank.add(record[1]);
        		}
        	}
        	else if(record[2].equalsIgnoreCase("OUT")) {
        		if(result.get(record[1]) == null) {
                	HashMap<String, String> nowCar = hm.get(record[1]);
            		String[] inTime = nowCar.get("IN").split(":");
            		String[] outTime = nowCar.get("OUT").split(":");
            		
            		int totalTime = (Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0])) * 60 + (Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]));
            		
            		result.put(record[1], totalTime);
            		hm.get(record[1]).clear();
        		}
        		else {
                	HashMap<String, String> nowCar = hm.get(record[1]);
            		String[] inTime = nowCar.get("IN").split(":");
            		String[] outTime = nowCar.get("OUT").split(":");
            		
            		int totalTime = (Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0])) * 60 + (Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]));
            		
            		int time = result.get(record[1]);
            		result.put(record[1], time + totalTime);
            		hm.get(record[1]).clear();
        		}
        	}
        }
        
        
        for(Map.Entry<String,HashMap<String,String>> tmp: hm.entrySet()) {
        	if(tmp.getValue().size() > 0) {
        		HashMap<String, String> nowCar = tmp.getValue();
        		String[] inTime = nowCar.get("IN").split(":");
        		
        		int time = 0;
        		if(result.get(tmp.getKey()) != null) {
        			time = result.get(tmp.getKey());
        		}
        		int totalTime = (23 - Integer.parseInt(inTime[0])) * 60 + (59 - Integer.parseInt(inTime[1]));
        		result.put(tmp.getKey(), time+ totalTime);
        	}
        }
        
        Collections.sort(rank);
        
        int rankLen = rank.size();
        answer = new int[rank.size()];
        for(int i = 0 ; i < rankLen; i++) {
        	String carNum = rank.get(i);
        	
        	int time = result.get(carNum);
        	
        	
//        	else {
//        		String[] inTime = nowCar.get("IN").split(":");
//        		String[] outTime = nowCar.get("OUT").split(":");
//        		
//        		int totalTime = (Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0])) * 60 + (Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]));
//        		
//        		price = fees[1] + (int)Math.ceil((totalTime - fees[0]) / fees[2]) * fees[3];
//        	}
        	int price = fees[1] + (int)Math.ceil((double)(time - fees[0]) / (double)fees[2]) * fees[3];
        	if(price <= fees[1]) price = fees[1];
        	answer[i] = price;
        	
        }
        
        for(int i = 0 ; i < answer.length; i++) {
        	System.out.println(answer[i]);
        }
        return answer;
    }

}
