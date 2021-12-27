package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class SegmentTree{
	
	public int[] tree;

	SegmentTree(int n) {

		double height = Math.ceil(Math.log(n)/ Math.log(2)) +1;
		int nodeCount = Math.round((float)Math.pow(2, height));
		tree = new int[nodeCount];
	}
	
	void init(int[] arr, int node) {
		arr[node / 2] = arr[node / 2 * 2] + arr[node / 2 * 2 + 1]; 
		
	}
	
	
	int find(int[] arr, int index, int val, int size) {
		
		if(arr.length / 2 <= index)
			return index;
		
		if(arr[index * 2] > val) return find(arr, index * 2, val, size);
		else return find(arr, index *2 +1, val - arr[index * 2], size);
		
	}

	void update(int[] arr, int start) {
		
		if(start == 1) {
			arr[start]--;
			return;
		}
		
		arr[start]--;
		update(arr, start / 2);
	}
}

public class Back1849 {

	    public static int[] ary;
	    public static int[] resultAry;
	    public static void main(String[] args) throws IOException {
	        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
	        
	        int N = Integer.parseInt(br.readLine());
	        ary = new int[N];
	        resultAry = new int[N];
	        
	        for(int i = 0 ; i < N; i++) {
	        	ary[i] = Integer.parseInt(br.readLine());
	        }
	        
	        SegmentTree stree = new SegmentTree(N);
	        for(int i = 0 ; i< stree.tree.length; i++) {
		        	stree.tree[i] = 1;
	        }
	        for(int i = stree.tree.length-1; i > 1; i--) {
	        	stree.init(stree.tree, i);
	        }
	        
	        
	        for(int i = 0; i < N ; i++) {
	        	int index = stree.find(stree.tree, 1, ary[i], N);
	        	resultAry[index - (stree.tree.length / 2)] = i + 1;
	        	stree.update(stree.tree, index);
	        }
	        
	        for(int i = 0 ; i < N ; i++) {
	        	bw.write(resultAry[i] + "\n");
	        }
	        
	        bw.flush();
	        br.close();
	        bw.close();
        
	    }
}
	





