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

public class P1260_1 {
	
	static ArrayList<Integer>[] adj;
	static boolean[] visited;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		
		// 정점 세팅
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		// 정점이 방문하는 노드 세팅
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		// 방문노드를 오름차순으로
		for (int i = 1; i <= N; i++) {
			Collections.sort(adj[i]);
		}
		
		dfs(V); Arrays.fill(visited, false); System.out.println();
		// visited 초기화
		bfs(V);
		
		br.close();
	}
	
	static void dfs(int start) {
		
		System.out.print(start + " ");
		visited[start] = true;
		
		for (int nextNode : adj[start]) {
			if (!visited[nextNode]) {
				dfs(nextNode);
			}
		}
	}
	
	static void bfs(int start) {
		
		visited[start] = true;
		System.out.print(start + " ");
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		
		while (!q.isEmpty()) {
			int nowProcessing = q.poll();
			
			for (int nextNode : adj[nowProcessing]) {
				if (!visited[nextNode]) {
					q.offer(nextNode);
					visited[nextNode] = true;
					System.out.print(nextNode + " ");
				}
			}
		}
	}
}
