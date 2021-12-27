package gaboza;

import java.util.*;
import java.util.regex.Pattern;

public class Matching {

	public static void main(String[] args) {

		String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
		String word = "blind";
		
		String[] url_ary = new String[pages.length];
		Map<String, Integer> url_map = new HashMap<String, Integer>();
		
		int[] basic_score = new int[pages.length];
		double[] tmp_score = new double[pages.length];
		int[] link_num = new int[pages.length];
		String[][] link_url= new String[pages.length][pages.length];
		for(String[] tmp: link_url) Arrays.fill(tmp, "");
		int index = 0;
		int word_count = 0;
		for(int i = 0; i < pages.length; i++) {	
			index = 0;
			word_count = 0;
			for(String tmp_st: pages[i].split("\n")) {
				if(tmp_st.contains("content=\"")) {
					for(String url : tmp_st.split("\"")) {
						if( url.contains("https")) {
							url_ary[i] = url;
							url_map.put(url, i);
						}
					}
				}
				if(tmp_st.contains("a href")) {
					for(String url : tmp_st.split("\"")) {
						if( url.contains("https")) {
							link_url[i][index] = url;
							index++;
						}
					}
				}
				if(tmp_st.toLowerCase().contains(word.toLowerCase())) {
					System.out.println("zzz");
					for(String st : tmp_st.split(" ")) {
						if(st.indexOf(word) != -1) {
							int tmp_index = st.indexOf(word);
							if((!alpha_check(st.charAt(tmp_index -1)) || tmp_index-1 <0) && (!alpha_check(st.charAt(tmp_index + 1)))) {
								word_count++;
							}
						}
					}
				}
			}	
			basic_score[i] = word_count;
			link_num[i] = index;
			tmp_score[i] = (double)basic_score[i] / (double)link_num[i];
		}
		
		int answer = -1;
		int index_res = -1;
		for(int i = 0 ; i < pages.length; i++) {
			String tmp = "";
			int j = 0;
			int score = 0;
			while(link_url[i][j] != "") {
				
				score += tmp_score[url_map.get(link_url[i][j])];
			//	System.out.println(score);
				j++;
			}
			if(answer < basic_score[i] + score) {
				answer = basic_score[i] + score;
				index_res = i; 
			}
		//	System.out.println();
		}
		
		/*for(int i = 0 ; i < 3 ; i ++) {
			System.out.println(basic_score[i] + " " + link_num[i] + " ");
			
		}*/
		System.out.println(link_url[0][0] + " " + link_url[0][1]);
		System.out.println(index_res);
		
		
	}

	public static Boolean alpha_check(char tmp) {
		
		if(tmp >= 65 && tmp <= 122) return true;
		return false;
	}
}
