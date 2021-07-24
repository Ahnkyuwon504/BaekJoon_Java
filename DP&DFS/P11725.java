package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11725 {
	
	static List<Integer>[] adj;
	static boolean[] visit;
	static int[] indegree;
	
	static class Node {
		int n;
		int topology;
		
		public Node(int n, int topology) {
			this.n = n;
			this.topology = topology;
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		indegree = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i <= N - 2; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		init();
		
		for (int i = 2; i <= N; i++) {
			int parent = 0;
			int preIndegree = Integer.MAX_VALUE;
			
			for (int node : adj[i]) {
				if (indegree[node] < preIndegree) parent = node;
				
				preIndegree = indegree[node];
			}
			
			sb.append(parent).append("\n");
		}
		
		System.out.println(sb);
	}

	static void init() {
		Queue<Node> q = new LinkedList<Node>();
		
		Node root = new Node(1, 1);
		
		q.offer(root);
		visit[root.n] = true;
		indegree[root.n] = root.topology;
		
		while (!q.isEmpty()) {
			Node nowProcessingNode = q.poll();
			
			int num = nowProcessingNode.n;
			int topology = nowProcessingNode.topology;
			
			for (int nextNum : adj[num]) {
				if (!visit[nextNum]) {
					Node nextNode = new Node(nextNum, topology + 1);
					
					q.offer(nextNode);
					visit[nextNode.n] = true;
					indegree[nextNode.n] = nextNode.topology;
				}
			}
		}
	}
}
