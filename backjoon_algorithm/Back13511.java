package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back13511 {

	public static ArrayList<Node>[] tree; // ����� ��带 �޴� tree
	public static Node[][] parents; // �θ��� �迭 ���� ( 1��°, 2��°, 4��°, 8��° �θ�....)
	public static int[] depth; // 1�� ���(root) �������� ���̸� ��Ÿ���� �迭
	public static boolean[] visited; // ù �θ� ���ſ��� ����ϴ� visited �迭
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // ��� ����
		
		tree = new ArrayList[N+1];
		parents = new Node[N+1][22];
		depth = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1 ; i <= N ;i++) {
			tree[i] = new ArrayList<>();
		}
		for( int i = 0; i <= N ; i++) {
			for(int j = 0 ; j < 22; j++) {
				parents[i][j] = new Node(0,0); 
			}
		}
		for(int i = 1 ; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sV = Integer.parseInt(st.nextToken());
			int eV = Integer.parseInt(st.nextToken());
			long wei = Integer.parseInt(st.nextToken());
			
			tree[sV].add(new Node(eV, wei));
			tree[eV].add(new Node(sV, wei));		
		}
		
		dfs(new Node(1,0), 0);
		
		connect(N);
		
		int queryNum = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < queryNum; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int num1 = Integer.parseInt(st.nextToken());
			
			switch (num1) {
			// stV ���� endV�� ���� ��� ��� ���
			case 1:
				int stV = Integer.parseInt(st.nextToken());
				int endV = Integer.parseInt(st.nextToken());
				sb.append(lca1(new Node(stV, 0), new Node(endV, 0)) + "\n"); // ��� ��� ���
				break;
				
			// �ǽɵǴ� �κ� 
		    // start ���� end�� ���� ��ο� �����ϴ� ���� �� k ��° ���� ���
			case 2:
				int start = Integer.parseInt(st.nextToken()); // ���� ��� ��ȣ
				int end = Integer.parseInt(st.nextToken()); // �� ��� ��ȣ
				int k = Integer.parseInt(st.nextToken()) - 1; // �ڱ� �ڽź��� 1��°�� �Է¹ޱ� ������ -1�Ͽ� �ڽ��� ������ ��° �� �� �� �ֵ��� �� 
				if(k == 0) sb.append(start + "\n"); // �ڱ� �ڽ� ��� �϶� �ڱ� �ڽ� ��� ���
				else {
					int lcaNum = lca2(new Node(start, 0), new Node(end, 0)); // �ּ� ���� ���� ���ϱ�
					int v1dep = depth[start] - depth[lcaNum]; 
					int v2dep = depth[end] - depth[lcaNum];
					if(v1dep == k) { // ���� ��� depth ������ K��°�� ���ٸ� �ּ� ���� ���� ��ȣ�� ���
						sb.append(lcaNum + "\n");
					}
					else if(v1dep > k) { // �ּ� ���� ������ ���� �ʴ� K��° �϶�,
						sb.append(findResult(start, k) + "\n"); // start��� �������� k��° �θ� ����
					}
					else {
						int dep = v2dep - (k - v1dep); // end ��� �������� ���° �θ� ���ؾ��ϴ��� dep�� ����
						if(dep == 0) sb.append(end + "\n"); // dep�� 0 �� ��� end �ڽ��� ����Ű�Ƿ� end ��� ��ȣ ��� 
						else {
							sb.append(findResult(end, dep) + "\n"); // end���� ���� ����� dep��° �θ� ���� ���
						}
					}
				}
				
				break;

			}
		}
		System.out.print(sb);
		br.close();
		
	}
	
	// �ڽ� ����� �ٷ� �� �θ� ��常�� parents�� ����, depth�� �ڽ��� ��� ���̸� ���� �ϴ� �Լ� 
	public static void dfs(Node cur, int dep) {
		visited[cur.num] = true;
		depth[cur.num] = dep;
		
		for(Node next : tree[cur.num]) {
			if(visited[next.num]) continue;
			parents[next.num][1].num = cur.num;
			parents[next.num][1].wei = next.wei;
			dfs(next, dep + 1);
		}
	}
	
	// �� ������ �θ� ��� ����
	public static void connect(int N) {
		
		for(int i = 2 ; i < 22; i++) {
			for(int cur = 1; cur <= N; cur++) {
				if(parents[parents[cur][i-1].num][i-1].num == 0) continue;
				parents[cur][i].num = parents[parents[cur][i-1].num][i-1].num;
				parents[cur][i].wei = parents[cur][i-1].wei + parents[parents[cur][i-1].num][i-1].wei;
			}
		}
		
	}
	
	// v1���� v2 ��ηΰ��� ����� ���ϴ� �Լ� 
	public static long lca1(Node v1, Node v2) {
		
		long v1Num = 0;
		long v2Num = 0;
		
		if(depth[v1.num] > depth[v2.num]) {
			Node tmp = v1;
			v1 = v2;
			v2 = tmp;
		}
		
		for(int i = 21; i > 0; i--) {
			int jump = 1 << (i-1);
			if(depth[v2.num] - depth[v1.num] >= jump ) {
				
				v2Num += parents[v2.num][i].wei;
				v2 = parents[v2.num][i];
				
			}
		}
		
		if(v1.num == v2.num) return v1Num + v2Num;
		
		for(int i = 21; i > 0 ; i--) {
			if(parents[v1.num][i].num == parents[v2.num][i].num) continue;
			
			v1Num += parents[v1.num][i].wei;
			v2Num += parents[v2.num][i].wei;
			v1 = parents[v1.num][i];
			v2 = parents[v2.num][i];		
		}
		
		v1Num += parents[v1.num][1].wei;
		v2Num += parents[v2.num][1].wei;
		
		return v1Num + v2Num;
		
	}
	
	// �ּ� ���� ������ ��ȣ ���ϴ� �Լ�
	public static int lca2(Node v1, Node v2) {
		
		if(depth[v1.num] > depth[v2.num]) {
			Node tmp = v1;
			v1 = v2;
			v2 = tmp;
		}
		
		for(int i = 21; i > 0; i--) {
			int jump = 1 << (i - 1);
			if(depth[v2.num] - depth[v1.num] >= jump ) {
				
				v2 = parents[v2.num][i];
				
			}
		}
		
		if(v1.num == v2.num) return v1.num;
		
		for(int i = 21; i > 0 ; i--) {
			if(parents[v1.num][i].num == parents[v2.num][i].num) continue;
			
			v1 = parents[v1.num][i];
			v2 = parents[v2.num][i];		
		}
		
		return parents[v1.num][1].num;
		
	}
	
	// ���� ���� ��ȣ num���� k��° �θ� ���ϴ� �Լ� 
	
	public static int findResult(int num, int k) {
		
		Node tmp = new Node(num , 0);
		
		for(int i = 21; i > 0; i--) {
			int jump = 1 << (i - 1);
			if(jump <= k) {
				tmp = parents[tmp.num][i];
				k -= jump;
			}
		}
		
		return tmp.num;
		
	}

	
	static class Node{ // ����ȣ �� ���� ����� ��� Node
		
		int num;
		long wei;

		public Node(int num, long wei) {
			super();
			this.num = num;
			this.wei = wei;
		}
		
	}

}
