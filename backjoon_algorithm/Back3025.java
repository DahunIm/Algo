package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back3025{

	public static int R,C; // �Է� ���� Map�� ��, �� ũ��
	public static char[][] volMap; // �Է��� ���� ������ Map ����
	public static int[] H = new int[100000];
	public static Quick[] quick = new Quick[30];
	public static StringBuilder sb; // ����� ���� StringBuilder
	
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
	
	public static void main(String[] args) throws IOException { // �Է°� ���� �� exception�� ������ ���� throws
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // �Է� �ޱ����� BufferedReader ����
		StringTokenizer st; // �� �ٿ� ���� ������ ���� ��, ��ū�������� �����ֱ� ����
		
		st = new StringTokenizer(br.readLine()," "); // �� ĭ�� �������� �Է°��� ��ū�������� ����
		R = Integer.parseInt(st.nextToken()); // Map�� �� ��
		C = Integer.parseInt(st.nextToken()); // Map�� �� ��
		volMap = new char[R][C]; // Map�� character�� �迭 ����
		
		for(int i = 0; i < R ; i++) { // �� �ึ�� �Է� �ޱ� ���� ������
			volMap[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0 ; i < C; i++) {
			quick[i] = new Quick();
			quick[i].col[0] = i;
			quick[i].trim();
		}
		
		
		int N = Integer.parseInt(br.readLine()); // ���ƿ� ȭ��ź�� Ƚ��
		
		for(int i = 0 ; i < N; i++) { // ȭ��ź�� ������ŭ ���ư�
			H[i] = (Integer.parseInt(br.readLine()) - 1); // ���� 1���� �����ϹǷ�, 1�� �� 0���� �����ϵ��ϸ����, ȭ��ź ���� ��ġ�� �����ϴ� �Լ� ȣ��
		}
		
		for(int i = 0 ; i<N; i++) {
			quick[H[i]].insert();
			for(int j = 0; j < C; j++) {
				quick[j].trim();
			}
		}
		
		sb = new StringBuilder(); // ��°��� ���� StringBuilder ��ü ����
		printVol(); // StringBuilder��ü�� ��� Map�� �߰��ϴ� �Լ� ȣ��
		System.out.print(sb); // ��� ���
		br.close(); // BufferedReader �޸� ����
	}

	
	// ������ ������ �ٲ� Map ��� StringBuilder�� �߰� �Լ�
	public static void printVol() {
		
		for(int i = 0 ; i < R ; i++) { // �� ũ�⸸ŭ ������
			for(int j = 0 ; j < C; j++) { // �� ũ�⸸ŭ ������
				sb.append(volMap[i][j]); // Map�� �� �ε��� �� StringBuilder�� �߰�
			}
			sb.append("\n"); // �� ���� ������ ���� ���๮�� �߰�
		}		
	}
}


