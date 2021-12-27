package gaboza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Hotel {

	public static Map<Long, Long> bang = new HashMap<>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		ArrayList<Long> result = new ArrayList<>();
		
		long[] room_number = new long[6];
		long[] answer = new long[6];
		int k = 10;
		
		for(int i = 0; i < 6; i++) {
			room_number[i] = Integer.parseInt(st.nextToken());
		}
		
		int index = 0;
		for(long room_num : room_number) {
			answer[index] = check(room_num);
			index++;
		}
		
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		System.out.println();
	}

	
	public static long check(long room_number) {
		long next_room;
		
		if(!bang.containsKey(room_number)) {
			bang.put(room_number, room_number + 1);
			return room_number;
		}
		next_room = bang.get(room_number);
		long empty = check(next_room);
		bang.put(room_number, empty);
		return empty;
	}
}
