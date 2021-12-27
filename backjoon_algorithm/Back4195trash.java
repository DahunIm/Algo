package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Back4195trash {

	public static int[] num_ary;
	public static int[] rank;
	public static Map<String, Integer> map;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int case_num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < case_num; i++) {
			
			int rel_num = Integer.parseInt(br.readLine());
			rank = new int[2 * rel_num + 2];
			num_ary = new int[2 * rel_num + 2];
			map = new HashMap<>();
			for(int k = 0; k < num_ary.length; k++) num_ary[k] = k;
			Arrays.fill(rank, 1);
			int index = 1;
			
			for(int j = 1; j <= rel_num; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				
				if(!map.containsKey(name1)) map.put(name1, index++);	
				if(!map.containsKey(name2)) map.put(name2, index++);
							
				union(map.get(name1) , map.get(name2));
			}
		}
		System.out.print(sb);

	}

	public static int find(int a) {
		
		if(num_ary[a] == a) {
			return a;
		}
		
		else {		
			return num_ary[a] = find(num_ary[a]);
		}		
		
	}
	
	public static void union(int a, int b) {
		
		int x = find(a);
		int y = find(b);
		
		if(x != y) {	
			num_ary[x] = y;	
			rank[y] += rank[x];
		}
		sb.append(rank[y] + "\n");
	}
}
