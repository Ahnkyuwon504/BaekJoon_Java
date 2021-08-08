package minjaeIsMyGodHamster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P18352 {
	
	static String answer = ""; 
	
	static int N, M, K, X;
	static int[] route;
	static ArrayList<Integer>[] adj;
	
	static class Node {
		int now;
		int length;
		
		public Node(int now, int length) {
			this.now = now;
			this.length = length;
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		route = new int[N + 1];
		adj = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
		}
		
		Arrays.fill(route, -1);
		
		bfs(new Node(X, 0));
		
		check(K);
		
		if (answer.length() == 0) System.out.println(-1);
		else System.out.println(answer);
	}
	
	static void bfs(Node nowNode) {		
		Queue<Node> q = new LinkedList<Node>();
		route[nowNode.now] = nowNode.length;
		
		q.offer(nowNode);
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			
			for (int next : adj[node.now]) {
				if (route[next] == -1) {
					route[next] = node.length + 1;
					q.offer(new Node(next, node.length + 1));
				}
			}
		}
	}
	
	static void check(int val) {
		for (int i = 0; i < route.length; i++) {
			if (route[i] == val) answer += i + "\n";
		}
	}
}
