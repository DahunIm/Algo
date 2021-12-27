package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back12015 {
	
	public static int[] ary;
	public static ArrayList<Integer> result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		ary = new int[len];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < len; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		result = new ArrayList<>();
		result.add(ary[0]);

		for(int i = 1 ; i < len ; i++) {
			if(result.get(result.size()-1) < ary[i]) result.add(ary[i]);			
			else if(result.get(0) > ary[i]) result.set(0, ary[i]);
			else findPlace(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(result.size() + "\n");
		System.out.print(sb);
		br.close();
	
	}
	
	public static void findPlace(int index) {
		
		int start = 0;
		int end = result.size()-1;
		int mid = (start + end) / 2;
		while(end - start >= 0) {		
			if(ary[index] == result.get(mid)) {
				return;
			}
			else if(ary[index] > result.get(mid)) {
				if(ary[index] < result.get(mid + 1)) {
					result.set(mid + 1, ary[index]);
					return;
				}
				start = mid + 1;
			}
			else if(ary[index] < result.get(mid)) {
				if(ary[index] > result.get(mid - 1)){
					result.set(mid, ary[index]);
					return;
				}
				end = mid - 1;
			}
			mid = (start + end) / 2;
		}
		
	}
}
