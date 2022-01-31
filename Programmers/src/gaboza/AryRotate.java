package gaboza;

public class AryRotate {

    public static int[][] ary;
    public static int[] x_go = {0, 1, 0, -1};
    public static int[] y_go = {1, 0 ,-1, 0};
    public static int[] go_cnt = new int[4];
    public static int direction;
    public static int sX, sY;
    public static int min;
    
	public static void main(String[] args) {
		int tmp[][] = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int[] result = solution(6, 6, tmp);
		
		int len = result.length;
		for(int i = 0 ; i < len ; i++) {
			System.out.print(result[i] + " ");
		}
	}

	
    public static int[] solution(int rows, int columns, int[][] queries) {        
        ary = new int[rows][columns];
        int cnt = 1;
        for(int i = 0 ; i < rows; i++){
            for(int j = 0 ; j < columns; j++){
                ary[i][j] = cnt++;
            }
        }
            
        int[] answer = {};
        answer = new int[queries.length];    
        
        for(int i = 0; i < queries.length; i++){
            direction = 0;
            int x_cnt = queries[i][2] - queries[i][0];
            int y_cnt = queries[i][3] - queries[i][1];
            for(int j = 0 ; j < 4; j++){
                if(j % 2 == 0){
                    go_cnt[j] = y_cnt;
                }
                else go_cnt[j] = x_cnt;
            }
            sX = queries[i][0];
            sY = queries[i][1];
            min = ary[sX-1][sY-1];
            rotate(sX-1, sY-1, 0, ary[sX-1][sY-1]);
            answer[i] = min;
        }
        
        return answer;
    }
    
    public static void rotate(int nowX, int nowY, int cnt, int prev){

        int pr = prev;
        int next = prev;
        int nx = nowX;
        int ny = nowY;
        
        for(int i = 0 ; i < go_cnt[direction]; i++){
            
            pr = next;
            
            nx = nowX + x_go[direction] * (i+1);
            ny = nowY + y_go[direction] * (i+1);
            
            next = ary[nx][ny];
            
            min = Math.min(min, next);
            ary[nx][ny] = pr;
            
        }
        
        if(direction == 3) return;
        
        direction++;
        rotate(nx, ny, cnt + 1, next);      
        
    }
    
}
