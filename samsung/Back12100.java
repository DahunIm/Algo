package samsung;
/*
 * 시뮬레이션 문제 잘보자!! ( BackTracking )
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Back12100 {

	public static int[][] ary;
	public static int num;
	public static int result;
	
	public static void main(String[] args) throws IOException{
		
		result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		num = Integer.parseInt(br.readLine());
		ary = new int[num][num];
		
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < num; j++) {
				ary[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		calc(0);

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	
	public static void calc(int count){
		
		if(count == 5) {
			f_max();
			return;
		}
		int[][] memo = new int[num][num];
		for(int i = 0; i < num; i++) memo[i] = ary[i].clone();
		
		for(int i = 0; i < 4; i++) {
			slide(i);
			calc(count + 1);
			for(int j = 0; j <num; j++) ary[j] = memo[j].clone();		
		}
	}
	
	public static void slide(int direction) {

		switch(direction) {
		case 0: // 왼
			for(int i = 0; i < num ; i++) {
				int index = 0;
				int block = 0;
				for(int j = 0; j < num; j++) {
					if(ary[i][j] != 0) {
						if(ary[i][j] == block) {
							ary[i][index-1] = block * 2;
							ary[i][j] = 0;
							block = 0;
						}
						else {
							block = ary[i][j];
							ary[i][j] = 0;
							ary[i][index] = block;
							index++;
						}
						
					}
				}
			}
		break;
		case 1: // 위		
			for(int j = 0; j < num ; j++) {
				int index = 0;
				int block = 0;
				for(int i = 0; i < num; i++) {
					if(ary[i][j] != 0) {
						if(ary[i][j] == block) {
							ary[index - 1][j] = block * 2;
							ary[i][j] = 0;
							block = 0;
						}
						else {
							block = ary[i][j];
							ary[i][j] = 0;
							ary[index][j] = block;
							index++;
						}
						
					}
				}
			}
		break;	
		case 2: // 오
			for(int i = 0; i < num ; i++) {
				int index = num - 1;
				int block = 0;
				for(int j = num - 1; j >= 0; j--) {
					if(ary[i][j] != 0) {
						if(ary[i][j] == block) {
							ary[i][index + 1] = block * 2;
							ary[i][j] = 0;
							block = 0;
						}
						else {
							block = ary[i][j];
							ary[i][j] = 0;
							ary[i][index] = block;
							index--;
						}
					}
				}
			}
			break;
		case 3: // 아래
			for(int j = 0; j < num ; j++) {
				int index = num - 1;
				int block = 0;
				for(int i = num - 1; i >= 0; i--) {
					if(ary[i][j] != 0) {
						if(ary[i][j] == block) {
							ary[index+1][j] = block * 2;
							ary[i][j] = 0;
							block = 0;
						}
						else {
							block = ary[i][j];
							ary[i][j] = 0;
							ary[index][j] = block;
							index--;
						}
					}
				}
			}
			break;
		}
		
	}
	
	public static void f_max() {
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				result = Math.max(result, ary[i][j]);
			}
		}
		
		
	}
}
