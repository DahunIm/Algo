package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back14003 {

	public static int[] ary;
	public static ArrayList<Integer> result;
	public static ArrayList<Integer> origin;
	public static ArrayList<Integer> aryResult;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		ary = new int[len];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0 ; i < len; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		
		result = new ArrayList<>();
		origin = new ArrayList<>();
		aryResult = new ArrayList<>();
		result.add(ary[0]);
		origin.add(0);
		for(int i = 1 ; i < len ; i++) {
			if(result.get(result.size()-1) < ary[i]) {
				result.add(ary[i]);		
				origin.add(result.size() - 1);
			}
			else if(result.get(0) > ary[i]) {
				result.set(0, ary[i]);
				origin.add(0);
			}
			else findPlace(i);
		}
		
		int resLen = result.size();
		
		int index = resLen - 1;
		for(int i = len - 1; i >= 0; i--) {
			if(origin.get(i) == index) {
				aryResult.add(ary[i]);
				index--;
			}
		}
		
		sb.append(resLen +"\n");
		for(int i = resLen-1 ; i >= 0; i--) {
			sb.append(aryResult.get(i) + " ");
		}
		System.out.println(sb);
		br.close();
	}

	public static void findPlace(int index) {
		
		int start = 0;
		int end = result.size()-1;
		int mid = (start + end) / 2;
		while(end - start >= 0) {		
			if(ary[index] == result.get(mid)) {
				origin.add(mid);
				return;
			}
			else if(ary[index] > result.get(mid)) {
				if(ary[index] < result.get(mid + 1)) {
					result.set(mid + 1, ary[index]);
					origin.add(mid+1);
					return;
				}
				start = mid + 1;
			}
			else if(ary[index] < result.get(mid)) {
				if(ary[index] > result.get(mid - 1)){
					result.set(mid, ary[index]);
					origin.add(mid);
					return;
				}
				end = mid - 1;
			}
			mid = (start + end) / 2;
		}
		
	}
}
