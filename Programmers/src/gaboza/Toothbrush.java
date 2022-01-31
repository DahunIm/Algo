package gaboza;

import java.util.HashMap;
import java.util.Map;

public class Toothbrush {

	
	public static int[] parent;
	public static int[] costs;
	public static Map<String, Integer> hm = new HashMap<String, Integer>();
	
	
	public static void main(String[] args) {
		String[] tmp = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] tmp1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] tmp2 = {"young", "john", "tod", "emily", "mary"};
		int[] tmp3 = {12, 4, 2, 5, 10};
		int[] result = solution(tmp, tmp1, tmp2, tmp3);
		
		for(int i = 0 ; i <= tmp.length; i++) {
			System.out.print(costs[i] + " ");
		}
		System.out.println();
		for(int i = 0 ; i < tmp.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        int len = enroll.length;
        hm.put("centercenter", 0);
        for(int i = 0 ; i < len; i++) {
        	hm.put(enroll[i], i+1);
        }
        
        parent = new int[len+1];
        costs = new int[len+1];
        int[] result = new int[len];
        
        parent[0] = -1;
        
        for(int i = 1; i <= len; i++) {
        	if(referral[i-1].equals("-")) continue;
        	parent[i] = hm.get(referral[i-1]);
        }
        
        int sel_len = seller.length;
        for(int i = 0; i < sel_len; i++) {
        	find(hm.get(seller[i]), amount[i] * 100);
        }
        
        for(int i = 0 ; i < len; i++) {
        	result[i] = costs[hm.get(enroll[i])];
        }
        
        return result;
   
    }
    
	public static void find(int a, int cost) {
		
		int nowCost = cost - (int)(cost / 10);
		int nextCost = cost - nowCost;
		if(nextCost == 0) {
			costs[a] += cost;
			return;
		}
			
		if(parent[a] < 0) {
			costs[0] += cost;
		}
		else {
			costs[a] += nowCost; 
			find(parent[a], nextCost);
		}
	}
    
}
