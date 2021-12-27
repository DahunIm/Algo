package backjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back13511 {

	public static ArrayList<Node>[] tree; // 연결된 노드를 받는 tree
	public static Node[][] parents; // 부모노드 배열 선언 ( 1번째, 2번째, 4번째, 8번째 부모....)
	public static int[] depth; // 1번 노드(root) 기준으로 깊이를 나타내는 배열
	public static boolean[] visited; // 첫 부모 갱신에만 사용하는 visited 배열
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 노드 갯수
		
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
			// stV 에서 endV로 가는 경로 비용 출력
			case 1:
				int stV = Integer.parseInt(st.nextToken());
				int endV = Integer.parseInt(st.nextToken());
				sb.append(lca1(new Node(stV, 0), new Node(endV, 0)) + "\n"); // 경로 비용 출력
				break;
				
			// 의심되는 부분 
		    // start 에서 end로 가는 경로에 존재하는 정점 중 k 번째 정점 출력
			case 2:
				int start = Integer.parseInt(st.nextToken()); // 시작 노드 번호
				int end = Integer.parseInt(st.nextToken()); // 끝 노드 번호
				int k = Integer.parseInt(st.nextToken()) - 1; // 자기 자신부터 1번째로 입력받기 때문에 -1하여 자신의 위부터 번째 수 셀 수 있도록 함 
				if(k == 0) sb.append(start + "\n"); // 자기 자신 노드 일때 자기 자신 노드 출력
				else {
					int lcaNum = lca2(new Node(start, 0), new Node(end, 0)); // 최소 공통 조상 구하기
					int v1dep = depth[start] - depth[lcaNum]; 
					int v2dep = depth[end] - depth[lcaNum];
					if(v1dep == k) { // 시작 노드 depth 개수와 K번째가 같다면 최소 공통 조상 번호를 출력
						sb.append(lcaNum + "\n");
					}
					else if(v1dep > k) { // 최소 공통 조상을 넘지 않는 K번째 일때,
						sb.append(findResult(start, k) + "\n"); // start노드 기준으로 k번째 부모를 구함
					}
					else {
						int dep = v2dep - (k - v1dep); // end 노드 기준으로 몇번째 부모를 구해야하는지 dep에 저장
						if(dep == 0) sb.append(end + "\n"); // dep이 0 인 경우 end 자신을 가리키므로 end 노드 번호 출력 
						else {
							sb.append(findResult(end, dep) + "\n"); // end노드로 부터 계산한 dep번째 부모를 구해 출력
						}
					}
				}
				
				break;

			}
		}
		System.out.print(sb);
		br.close();
		
	}
	
	// 자신 노드의 바로 위 부모 노드만을 parents에 갱신, depth에 자신의 노드 깊이를 저장 하는 함수 
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
	
	// 각 노드들의 부모 노드 연결
	public static void connect(int N) {
		
		for(int i = 2 ; i < 22; i++) {
			for(int cur = 1; cur <= N; cur++) {
				if(parents[parents[cur][i-1].num][i-1].num == 0) continue;
				parents[cur][i].num = parents[parents[cur][i-1].num][i-1].num;
				parents[cur][i].wei = parents[cur][i-1].wei + parents[parents[cur][i-1].num][i-1].wei;
			}
		}
		
	}
	
	// v1에서 v2 경로로가는 비용을 구하는 함수 
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
	
	// 최소 공통 조상의 번호 구하는 함수
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
	
	// 시작 지점 번호 num에서 k번째 부모를 구하는 함수 
	
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

	
	static class Node{ // 노드번호 및 간선 비용을 담는 Node
		
		int num;
		long wei;

		public Node(int num, long wei) {
			super();
			this.num = num;
			this.wei = wei;
		}
		
	}

}
