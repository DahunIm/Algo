package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back11054 {

	public static int[] ary;
	public static int[][] memo;
	public static int[] dist;
	public static int[] dist_rev;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ary = new int[num + 1];
		dist = new int[num + 1];
		dist_rev = new int[num + 1];
		memo = new int[num + 1][num + 1];
		
		for(int i = 1; i <= num; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 1; i <= num; i++) {
			for(int j = i + 1; j <= num; j++) {
				if(ary[i] < ary[j]) {
					memo[i][j] = dist[i] + 1;
					if(dist[j] < dist[i] + 1) dist[j] = dist[i] + 1;
				}
			}	
		}
		for(int i = num; i >= 1; i--) {
			for(int j = i-1; j >= 1; j--) {
				if(ary[i] < ary[j]) {
					memo[i][j] = dist[i] + 1;
					if(dist_rev[j] < dist_rev[i] + 1) dist_rev[j] = dist_rev[i] + 1;
				}			
			}		
		}
		bw.write((find_max(num) + 1)  + "\n");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static int find_max(int num) {
		int max = 0;
		for(int i = 1; i <= num; i++) {
			if(max < dist[i] + dist_rev[i]) max = dist[i] + dist_rev[i];
		}
		
		return max;
	}
}
