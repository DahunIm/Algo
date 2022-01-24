package gaboza;

public class StringCompress {

	public static void main(String[] args) {
		    int answer = 0;
	        String s = "abcabcabcabcdededededede";
	        int len = s.length();
	        answer = len;
	        int cnt = 0;
	        for(int i = 1 ; i <= len / 2; i++){
	            String start = s.substring(0, i);
	            cnt = 1;
	            String result = "";
	            String last = "";
	            for(int j = i ; j < len; j+= i){
	                if(j + i > len){
	                    last = s.substring(j);
	                    break;
	                }
	                if(start.equals(s.substring(j, j+ i))){
	                    cnt++;
	                }
	                else{
	                    if(cnt == 1){
	                        result += start;    
	                    }
	                    else{
	                        result += cnt + start;
	                        cnt = 1;
	                    }
	                    start = s.substring(j, j+i);
	                }
	            }
	            result += start + last;
	            if(cnt != 1){
	                result += cnt;
	            }
	            answer = Math.min(answer, result.length());
	            
	        }
	        
	        System.out.println(answer);
	}

}
