package gaboza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Tuple {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();

		
		System.out.println(Arrays.toString(solution(s)));
		br.close();
	}

	public static int[] solution(String s) {
		
		int[] answer = {};
		String[] tmp = s.replaceAll("[{}]", " ").trim().split(" ,");
		int index = 0;
		answer = new int[tmp.length];	
		HashSet<Integer> hs = new HashSet<Integer>();
		Arrays.sort(tmp, (a, b)-> (a.length() - b.length()));
		for(String str: tmp) {
			for(String val : str.split(",")) {
				int gap = Integer.parseInt(val.trim());
				if(hs.contains(gap)) continue;
				hs.add(gap);
				answer[index++] = gap; 
			}
		}	
		return answer;
	}
}
