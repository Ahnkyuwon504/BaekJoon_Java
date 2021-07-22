package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724 {
	
	static ArrayList<Integer>[] adj;
	static boolean[] visit;
	static int connection;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N + 1];
		adj = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			visit[i] = false;
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		for (int i = 1; i <= N; i++) {
			if (visit[i]) continue;
			
			dfs(i);
			connection++;
		}
		
		System.out.println(connection);
		
		

	}
	
	static void dfs(int node) {
		visit[node] = true;
		
		for (int nextNode : adj[node]) {
			if (!visit[nextNode]) dfs(nextNode);
		}
	}

}
