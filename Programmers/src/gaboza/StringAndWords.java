package gaboza;

public class StringAndWords {

    public static String[] words = {"zero",
	"one",
	"two",
	"three",
	"four",
	"five",
	"six",
	"seven",
	"eight",
	"nine"};
    
    public static int solution(String s) {
        int answer = 0;
        int len = s.length();
        String result = "";
        for(int i = 0 ; i< len; i++){
            char now = s.charAt(i);
            if(Character.isDigit(now)){
                result += now;
                continue;
            }
            String subnow = s.substring(i, i+3);
            int wordslen = 0;
            for(int j = 0 ; j < 10; j++){
                if(words[j].substring(0, 3).equals(subnow)){
                    result += Integer.toString(j);
                    wordslen = words[j].length() - 1;
                    break;
                }
            }
            i += wordslen;
            
        }
        answer = Integer.parseInt(result);
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("one4seveneight"));
	}

}
