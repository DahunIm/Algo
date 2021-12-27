package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Back2261 {

	public static Set<Coor> hs;
	public static ArrayList<Coor> list;
	public static long result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		result = 1;
		int num = Integer.parseInt(br.readLine());
		hs = new HashSet<>();
		for(int i = 0 ; i < num ; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(hs.contains(new Coor(x, y))) result = 0;			
			hs.add(new Coor(x, y));
			
		}
			
		if(result != 0) {
			list = new ArrayList<Coor>(hs);	
			Collections.sort(list);		
			result = DQ(0, list.size() - 1);
			
		}
		
//		
//		for(Coor tmp : list) {
//			System.out.print( tmp.x + "," + tmp.y + " || ");
//		}
		
		System.out.println(result);
		br.close();
	}
	
	public static long DQ(int start, int end) {
		
		if(end - start < 3) {
			int minDist = Integer.MAX_VALUE;
			for(int i = start; i < end; i++) {
				for(int j = i + 1; j <= end; j++) {
					minDist = Math.min(minDist, calcDist(list.get(i), list.get(j)));
				}
			}
			return minDist;
		}
		
		int mid = (start + end) / 2;
		long dist = Math.min(DQ(start, mid), DQ(mid + 1, end));
		
		return Math.min(dist, calcMid(start, end, mid, dist));	
	}
	
	public static long calcMid(int start, int end, int mid, long len) {
		
		ArrayList<yCoor> yList = new ArrayList<>();
		
		int xDist;
		int midX = list.get(mid).x;
		for(int i = start; i <= end; i++) {
			
			int nowX = list.get(i).x;
			int nowY = list.get(i).y;
			
			xDist = nowX - midX;
			
			xDist *= xDist;
			
			if(xDist < len) {
				yList.add(new yCoor(nowX, nowY));
			}
		}
		
		Collections.sort(yList);
		
		int yLen = yList.size();
		int yDist;
		int xDis;
		
		for(int i = 0 ; i < yLen ; i++) {
			
			int nowX = yList.get(i).x;
			int nowY = yList.get(i).y;
			
			int j = i + 1;
			while(j < yLen) {
					
				int comX = yList.get(j).x;
				int comY = yList.get(j).y;
				
				yDist = comY - nowY;
				yDist *= yDist;
				
				xDis = comX - nowX;
				xDis *= xDis;
				
				if(yDist >= len) break;
				else len = Math.min(len, xDis + yDist);
				j++;
			
			}
			
		}
		
		return len;
	}

	public static int calcDist(Coor c1, Coor c2) {
		return (c1.x - c2.x) * (c1.x - c2.x) + (c1.y - c2.y) * (c1.y - c2.y);
		
	}
	
	static class Coor implements Comparable<Coor>{
		int x,y;

		public Coor(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Coor o) {
			if(this.x == o.x) return Integer.compare(this.y, o.y);
			return Integer.compare(this.x, o.x);
		}
		
	}
	
	static class yCoor implements Comparable<yCoor>{
		int x,y;
		
		public yCoor(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(yCoor o) {
			if(this.y == o.y) return Integer.compare(this.x, o.x);
			return Integer.compare(this.y, o.y);
		}
		
	}
}
