package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2644 {
	
	static int n, start, end, m;
	static ArrayList<Integer>[] adj;
	static int[] visit;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n + 1];
		visit = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
				
		m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
			
		}
		
		dfs(start, 0);
		
		System.out.println((visit[end] == 0)? -1 : visit[end]);
		

		
	}
	
	static void dfs(int node, int length) {
		visit[node] = length;
		
		for (int nextNode : adj[node]) {
			if (visit[nextNode] == 0) dfs(nextNode, length + 1);
		}
	}
}
