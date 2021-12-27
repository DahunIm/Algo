package gaboza;

import java.util.*;

public class Way {

	public static void main(String[] args) {
		
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		
		int length = nodeinfo.length;
		
		ArrayList<node> node_list = new ArrayList<>();
		for(int i =0; i < length; i++) {
			node_list.add(new node(nodeinfo[i][0], nodeinfo[i][1], i + 1, 0));
		}
		
		Collections.sort(node_list, new nodeComparator());

		int now_depth = 0;
		int parent = node_list.get(0).node_num;
		/*for(int i =1; i < length; i++) {
			if(node_list.get(i).y < node_list.get(i - 1).y) {
				node_list.get(i).parent = parent;
				parent = node_list.get(i).node_num;
			}
			else if( node_list.get(i).y == node_list.get(i - 1).y) {
				node_list.get(i).parent = 
			}
		}
		*/
		Set<Integer> result_set = new HashSet<>();
		result_set.add(node_list.get(0).node_num);
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i =0; i < length; i++) {
			queue.add(node_list.get(i).x);
			queue.add(node_list.get(i).y);
			queue.add(node_list.get(i).node_num);
		}
		
		int prev_x = queue.poll();
		int prev_y = queue.poll();
		int prev_num = queue.poll();
		result_set.add(prev_num);
		
		while(queue.isEmpty()) {
			int now_x = queue.poll();
			int now_y = queue.poll();
			int now_node_num = queue.poll();
	
			if(now_y == prev_y) {
				queue.add(now_x);
				queue.add(now_y);
				queue.add(now_node_num);
			}
			else {
				if(now_x < prev_x) {
					
				}
				else {
					
					
				}
				
			}
		}
		
		
		
		result_set.clear();
	
	}

	
	
	
	
	public static class node{
		
		int x;
		int y;
		int node_num;
		int parent;
		
		public node(int x, int y, int node_num, int parent) {
			this.x = x;
			this.y = y;
			this.node_num = node_num;
			this.parent = parent;
		}

		
	}
	
	public static class nodeComparator implements Comparator<node>{
		
		@Override
		public int compare(node a, node b) {
			if(a.y == b.y) return a.x - b.x;
			else return b.y - a.y;
			
		}
	}
}


