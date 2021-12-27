package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back3025{

	public static int R,C; // 입력 받을 Map의 행, 열 크기
	public static char[][] volMap; // 입력을 받을 게임의 Map 선언
	public static int[] H = new int[100000];
	public static Quick[] quick = new Quick[30];
	public static StringBuilder sb; // 출력을 위한 StringBuilder
	
	static class Quick{
		int[] col;
		int r;
		
		public Quick() {
			this.col = new int[30000];
			this.r = 1;
		}
		
		public void insert() {
			volMap[r -1][col [r-1]] = 'O';
		}
		
		public void trim() {
			while(true) {
				
				int cur = col[r-1];
				
				if(r > 1 && volMap[r-1][cur] != '.') {
					r--;
				}
				
				else if(r == R) {
					break;
				}
				
				else if(volMap[r][cur] == 'X')
					break;
				else if(volMap[r][cur] == '.')
					col[r++] = cur;
				else {
					if(cur > 0 && volMap[r][cur-1] == '.' && volMap[r-1][cur-1] == '.')
						col[r++] = cur-1;
					else if(cur+1 < C && volMap[r][cur+1] == '.' && volMap[r-1][cur+1] == '.')
						col[r++] = cur+1;
					else break;
				}
							
			}	
			
		}
		
	}
	
	public static void main(String[] args) throws IOException { // 입력값 받을 시 exception을 던지기 위한 throws
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기위해 BufferedReader 선언
		StringTokenizer st; // 한 줄에 값을 여러개 받을 때, 토큰형식으로 나눠주기 위함
		
		st = new StringTokenizer(br.readLine()," "); // 빈 칸을 기준으로 입력값을 토큰형식으로 나눔
		R = Integer.parseInt(st.nextToken()); // Map의 행 수
		C = Integer.parseInt(st.nextToken()); // Map의 열 수
		volMap = new char[R][C]; // Map의 character형 배열 생성
		
		for(int i = 0; i < R ; i++) { // 각 행마다 입력 받기 위한 루프문
			volMap[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0 ; i < C; i++) {
			quick[i] = new Quick();
			quick[i].col[0] = i;
			quick[i].trim();
		}
		
		
		int N = Integer.parseInt(br.readLine()); // 날아올 화산탄의 횟수
		
		for(int i = 0 ; i < N; i++) { // 화산탄의 갯수만큼 돌아감
			H[i] = (Integer.parseInt(br.readLine()) - 1); // 열이 1부터 시작하므로, 1을 빼 0부터 시작하도록만들고, 화산탄 굳을 위치를 결정하는 함수 호출
		}
		
		for(int i = 0 ; i<N; i++) {
			quick[H[i]].insert();
			for(int j = 0; j < C; j++) {
				quick[j].trim();
			}
		}
		
		sb = new StringBuilder(); // 출력값을 받을 StringBuilder 객체 생성
		printVol(); // StringBuilder객체에 결과 Map을 추가하는 함수 호출
		System.out.print(sb); // 결과 출력
		br.close(); // BufferedReader 메모리 해제
	}

	
	// 게임이 끝나고 바뀐 Map 결과 StringBuilder에 추가 함수
	public static void printVol() {
		
		for(int i = 0 ; i < R ; i++) { // 행 크기만큼 루프문
			for(int j = 0 ; j < C; j++) { // 열 크기만큼 루프문
				sb.append(volMap[i][j]); // Map의 각 인덱스 값 StringBuilder에 추가
			}
			sb.append("\n"); // 각 행이 끝날때 마다 개행문자 추가
		}		
	}
}


