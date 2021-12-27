package backjoon_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class tree1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		ArrayList<Integer> tree_ary = new ArrayList<>();
		//TreeSet<Integer> tset = new TreeSet<Integer>();

		tree_ary.add(0);
		tree_ary.add(1);
		int tmp_num, val;
		for(int i = 0; i < num; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int nod1 = Integer.parseInt(st.nextToken());
			int nod2 = Integer.parseInt(st.nextToken());
			
			if(tree_ary.contains(nod1)) {
				tmp_num = tree_ary.indexOf(nod1);
				val = 0;
			}
			else {
				tmp_num = tree_ary.indexOf(nod2);
				val = 1;
			}
			
			if(val == 1) {
				if(tree_ary.size() <= tmp_num * 2 || tree_ary.get(tmp_num * 2) == 0) tree_ary.add(tmp_num * 2 , nod1);
				else tree_ary.add(tmp_num * 2 + 1, nod1);	
			}
			else {
				if(tree_ary.size() <= tmp_num * 2 || tree_ary.get(tmp_num * 2) == 0) tree_ary.add(tmp_num * 2 , nod2);
				else tree_ary.add(tmp_num * 2 + 1, nod2);	
			}
		}
		
		for(int j = 2; j <= num; j++ ) {
			sb.append(tree_ary.get(j/2) + "\n");
		}
		System.out.print(sb);
	}

}
