package gaboza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
/*
public class Baduser {

	public static String[] user_id;
	public static String[] banned_id;
	public static Set<Set<String>> result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ",");
		
		user_id = new String[5];
		banned_id = new String[2];
		for(int i = 0; i < 5; i ++) {
			user_id[i] = st.nextToken();
		}
		for(int i = 0; i < 2; i ++) {
			banned_id[i] = st.nextToken();
			
		}
		
		//System.out.println(solution(user_id, banned_id));
	}
	
	public static int solution(String[] user_id, String[] banned_id) {
       result = new HashSet<>();
       dfs(user_id, banned_id, )
		
    }
	
	public static void dfs(String[] user_id, String[] banned_id, Set<String> set) {
		if(set.size() == banned_id.length) {
			if(usercheck(set, banned_id)) {
				result.add(new HashSet<>(set));
			}
			return;
		}
		
		
	}

	public static boolean Stringcheck(String a, String b) {
		if(a.length() != b.length()) return false;
		
		for(int i = 0; i<a.length(); i++) {
			if(b.charAt(i) == '*') continue;
			
			if(a.charAt(i) != b.charAt(i)) return false;
		}
		
		return true;
	}
}


/* frodo,fradi,crodo,abc123,frodoc*/