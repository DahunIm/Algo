package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.*;

public class Back5373 {
	
	public static Queue<String> queue = new LinkedList<>();
	public static String[][] cube = new String[3][3];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int case_num = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				
			}
		}
		
		
		for(int i = 0 ; i < case_num ; i++) {
			int rot_num = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < rot_num; j++) {
				queue.add(st.nextToken());
			}
			
			
			//calc();
		}
		
		
	}
}
