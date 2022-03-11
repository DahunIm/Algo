package gaboza;

public class Kakao2022Sol2 {

	public static void main(String[] args) {
		System.out.println(solution(437674,3));
		System.out.println(solution(7, 3));
	}

    public static int solution(int n, int k) {
        int answer = 0;
        
        StringBuffer result = new StringBuffer();
        int mok = n;
        while(true) {
        	result.append((char)(mok % k + '0'));
        	mok /= k;
        	
        	if(mok == k) {
        		result.append((char)(1 + '0'));
        		result.reverse();
        		break;
        	}
        	else if( mok < k) {
        		result.append((char)(mok + '0'));
        		result.reverse();
        		break;
        	}
        }
        
        int len = result.length();
        StringBuffer tmpNum = new StringBuffer();
        for(int i = 0 ; i < len; i++) {
        	if(result.charAt(i) == '0') {
        		if(tmpNum.length() == 0) continue;
        		if(isPrime(Long.parseLong(tmpNum.toString()))) {
        			
        			answer++;
        		}
        		tmpNum.delete(0, tmpNum.length());
        		continue;
        	}
        	tmpNum.append(result.charAt(i));
        }
        if(tmpNum.length() != 0) {
    		if(isPrime(Long.parseLong(tmpNum.toString()))) {
    			answer++;
    		}
        }
        return answer;
    }
    
    public static Boolean isPrime(Long n) {
    	if(n == 1) return false;
    	for (int i = 2; i<=(int)Math.sqrt(n); i++) {
          if (n % i == 0) {
              return false;
          }
    	}
    	return true;
    }
}
