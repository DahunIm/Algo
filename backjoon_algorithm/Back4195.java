package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Back4195 {

	public static int[] num_ary;
	public static Map<String, Integer> map;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int case_num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < case_num; i++) {
			
			int rel_num = Integer.parseInt(br.readLine());
			num_ary = new int[2 * rel_num + 2];
			map = new HashMap<>();
			Arrays.fill(num_ary, -1);
			
			int index = 1;
			
			for(int j = 1; j <= rel_num; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				
				if(!map.containsKey(name1)) map.put(name1, index++);	
				if(!map.containsKey(name2)) map.put(name2, index++);
							
				sb.append(union(map.get(name1) , map.get(name2)) + "\n");
			}
		}
		System.out.print(sb);

	}

	public static int find(int a) {
		
		if(num_ary[a] < 0) {
			return a;
		}
		
		else {		
			return num_ary[a] = find(num_ary[a]);
		}		
		
	}
	
	public static int union(int a, int b) {
		
		int x = find(a);
		int y = find(b);
		
			
		if(num_ary[x] < num_ary[y]) {	
			num_ary[x] += num_ary[y];
			num_ary[y] = x;	
			return -Math.min(num_ary[x], num_ary[y]);
		}
		else {
			num_ary[y] += num_ary[x];
			num_ary[x] = y;
			return -Math.min(num_ary[x], num_ary[y]);
		}
	}
}
