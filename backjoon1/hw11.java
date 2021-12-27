package backjoon1;

public class hw11 {
	
	public static void main(String args[]) {
		
		int ary[] = new int[10000];
		int ary_check[] = new int[10000];
		
		for(int i = 0 ; i < ary.length ; i++) {
			
			ary[i] = i+1;
			
		}
		
		check(ary,ary_check);	
		
	}
	
	public static void check(int ary[],int ary_check[]) {
		
		int sang = 0;
		for(int j = 1; j <= ary.length; j++) {
			
			sang = self(j);
			
			if(sang <= 10000) {
				ary_check[sang - 1 ]++;
			}
		}
		
		for(int i = 0; i < ary.length; i++) {
			if(ary_check[i] == 0) {
				System.out.println(ary[i]);
			}
		}
	
		
	}
	
	public static int self(int j) {
		
		int tmp = j;
		
		while(true) {
			
			if(j == 0) break;
			
			tmp += j%10;
			j /= 10;

		}		
		return tmp;
	}
	
}
