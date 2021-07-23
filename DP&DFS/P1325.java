package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1325 {
	
	static int N, M;
	static ArrayList<Integer>[] adj;
	static boolean[] visit;
	static int[] result;
	
	static int hacking;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>(i);
		}
		
		visit = new boolean[N + 1];
		result = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[v].add(u);
		}
		
		int max_hacking = 0;
		
		for (int i = 1; i <= N; i++) {
			hacking = 0;
			Arrays.fill(visit, false);
			
			bfs(i);
			
			max_hacking = Math.max(max_hacking, hacking);
			result[i] = hacking;
		}
				 		
		for (int i = 1; i <= N; i++) {
			if (result[i] == max_hacking) sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		visit[node] = true;
		hacking++;
		q.offer(node);
		
		while (!q.isEmpty()) {
			int nowProcessingNode = q.poll();
			
			for (int nextNode : adj[nowProcessingNode]) {
				if (!visit[nextNode]) {
					visit[nextNode] = true;
					hacking++;
					q.offer(nextNode);
				}
			}
		}
	}
}
