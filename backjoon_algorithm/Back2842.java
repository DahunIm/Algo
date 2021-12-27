package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Back2842 {

	public static char[][] postAry;
	public static int[][] heightAry;
	public static Set<Integer> heightSet;
	public static ArrayList<Integer> heightList;
	public static int cnt, N, minVal, minL, maxL;
	public static int[] x_go = { 0, 1, 1, 1, 0, -1, -1, -1};
	public static int[] y_go = {1, 1, 0, -1, -1, -1, 0, 1};
	public static boolean flag;
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		postAry = new char[N][N];
		heightAry = new int[N][N];
		minVal = Integer.MAX_VALUE;
		
		int startX = 0;
		int startY = 0;
		cnt = 0;
		
		for(int i = 0 ; i < N ; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < N; j++) {
				char input = tmp.charAt(j);
				if(input == 'P') {
					startX = i;
					startY = j;
				}
				if(input == 'K') cnt++;
				postAry[i][j] = input;
			}
		}
		heightSet = new HashSet<>();

		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				int tmpNum = Integer.parseInt(st.nextToken());
				heightAry[i][j] = tmpNum;
				heightSet.add(tmpNum);
			}
		}
		heightList = new ArrayList(heightSet);
		Collections.sort(heightList);
		
		int listX = 0, listY = 0;
		while(listX <= heightList.size() - 1 && listY <= heightList.size() - 1) {
			flag = false;
			minL  = heightList.get(listX);
			maxL = heightList.get(listY);
			if(heightAry[startX][startY] >= minL && heightAry[startX][startY] <= maxL) {
				bfs(startX, startY);
			}
			if(flag) minVal = Math.min(minVal, maxL - minL);
			if(minVal == 0) break;
			if(listY == heightList.size() - 1 || flag) {
				listX++;
			}
			else if(!flag){
				listY++;
			}
		}
		
		System.out.println(minVal);
		br.close();
		
	}

	public static void bfs(int sX, int sY) {
		boolean[][] visited = new boolean[N][N];
		
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(sX, sY));
		visited[sX][sY] = true;
		int resultCnt = 0;
		
		while(!q.isEmpty()) {
		
			Node curNode = q.poll();
			int curX = curNode.x;
			int curY = curNode.y;
			
			if(postAry[curX][curY] == 'K') resultCnt++;
			
			if(resultCnt == cnt) {
				flag = true;
				return;
			}
			
			for(int i = 0 ; i < 8 ; i++) {
				int nx = curX + x_go[i];
				int ny = curY + y_go[i];

				if( nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {

					if(heightAry[nx][ny] > maxL || heightAry[nx][ny] < minL) continue;
					visited[nx][ny] = true;
					q.add(new Node(nx, ny));
				}
			}
		}
		
	}
	
	public static class Node implements Comparable<Node>{
		
		int x;
		int y;
		
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.x, o.x);
		}
		
	}

}
