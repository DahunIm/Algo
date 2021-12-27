package backjoon1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class hw23 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
			
		int i = 0;
		while(i < num) {
			
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int room = find_room(H,W,N);
			bw.write(room + "\n");
			i++;
			
		}
		
		bw.flush();
		bw.close();
		
	
	}

	
	
	public static int find_room(int floors, int rooms, int num) {
		
		int room_num = 0;
		
		if(num % floors == 0) {
			room_num += floors * 100;
			room_num += num / floors;
		}
		else {
			room_num += (num % floors) * 100;
			room_num += num / floors + 1;
		}
		
		return room_num;
	}
}
