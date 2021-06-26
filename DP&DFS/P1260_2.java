package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260_2 {
	
	static ArrayList<Integer>[] adj;
	static boolean[] visited;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(adj[i]);
		}
		
		dfs(V); Arrays.fill(visited, false); System.out.println();
		bfs(V);
	}
	
	static void dfs(int start) {
		
		visited[start] = true;
		System.out.print(start + " ");
		
		for (int nextNode : adj[start]) {
			if (!visited[nextNode]) {
				dfs(nextNode);
			}
		}
	}
	
	static void bfs(int start) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(start);
		visited[start] = true;
		System.out.print(start + " ");
		
		while (!q.isEmpty()) {
			int nowProcessing = q.poll();
			
			for (int next : adj[nowProcessing]) {
				if (!visited[next]) {
					q.offer(next);
					visited[next] = true;
					System.out.print(next + " ");
				}
			}
		}
	}
}
