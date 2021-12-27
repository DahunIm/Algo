package gaboza;

import java.util.*;

public class Solution {
	    public static int minValue;
	    public static int[][] map;
	    public static int[] x_ary= {-1,0,1,0};
	    public static int[] y_ary = {0,-1,0,1};
	    public static int n; 
	    
	    public static void main(String[] args) {
			int[][] board = {{0, 0, 0, 0, 0},
			        {0, 1, 1, 1, 0},
			        {0, 0, 1, 0, 0},
			        {1, 0, 0, 0, 1},
			        {0, 1, 1, 0, 0}};
			System.out.println(solution(board));
	    }
	    
	    public static void bfs(int x, int y, int sum, int vector) {
	        Queue<Road> q = new LinkedList<>();
	        q.add(new Road(x,y, sum, vector));
	        map[0][0] = 1;
	        
	        while(!q.isEmpty()){
	            
	            Road road = q.poll();
	            if(road.x == n-1 && road.y == n-1) {
	                if(minValue > road.sum) {
	                    minValue = road.sum;
	                }
	                continue;
	            }
	            
	            //4방향 이동, 0 - 위, 1 - 왼쪽, 2 - 아래, 3 - 오른쪽
	            for(int i = 0; i < 4; i++) {
	                int next_x = road.x + x_ary[i];
	                int next_y = road.y + y_ary[i];
	                //1이면 벽이이므로 if문이 실행되면 안된다.
	                if(next_x >= 0 && next_x < n && next_y >=0 && next_y < n && map[next_x][next_y] != 1) {
	                    int nextFieldSum = 0;
	                    
	                    if(road.vector == -1 || road.vector == i) {
	                        nextFieldSum = road.sum + 100;
	                    }else {
	                        nextFieldSum = road.sum + 600;
	                    }
	                    
	                    //처음 가는 곳인지 아닌지를 판단.
	                    if(map[next_x][next_y] == 0) {
	                        map[next_x][next_y] = nextFieldSum;
	                        q.add(new Road(next_x, next_y, nextFieldSum, i));
	                    }else if(map[next_x][next_y] >= nextFieldSum) {
	                        map[next_x][next_y] = nextFieldSum;
	                        q.add(new Road(next_x, next_y, nextFieldSum, i));
	                    }
	                    
	                }
	            }
	        }
	    }
	    
	    public static int solution(int[][] board) {
	        minValue = Integer.MAX_VALUE;
	        n = board.length;
	        map = board;
	        
	        
	        bfs(0,0,0,-1);
	        return minValue;
	    }
	 
	    public static class Road{
	        int x, y;
	        int sum;
	        int vector;
	        public Road(int x, int y, int sum, int vector) {
	            this.x = x;
	            this.y = y;
	            this.sum = sum;
	            this.vector = vector;
	        }
	    }
}


