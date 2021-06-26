package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260 {
	
	static boolean[] visited ;
	static String answer = "";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N + 1];
		
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			list.get(v1).add(v2);
			list.get(v2).add(v1);
		}
		
		dfs(list, V, visited);
		System.out.println(answer);
		Arrays.fill(visited, false);
		bfs(list, V, visited);
	}
	
	
	static void bfs(List<ArrayList<Integer>> list, int V, boolean[] visited) {
		String answer = "";
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(V);
		visited[V] = true;
		answer += V + " ";
		
		while(!q.isEmpty()) {
			int nowProcessing = q.poll();
			
			Collections.sort(list.get(nowProcessing));
			
			for (int node : list.get(nowProcessing)) {
				if (!visited[node]) {
					q.offer(node);
					visited[node] = true;
					answer += node + " ";
				}
			}
		}
		System.out.println(answer);
	}
	
	static void dfs(List<ArrayList<Integer>> list, int V, boolean[] visited) {
		
		visited[V] = true;
		answer += V + " ";
		
		Collections.sort(list.get(V));
		for (int nowProcessing : list.get(V)) {
			if (!visited[nowProcessing]) {
				dfs(list, nowProcessing, visited);
			}
		}
	}

}
