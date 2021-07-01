package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2606 {
	
	static ArrayList<Integer>[] adj;
	static boolean[] visit;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int numOfCom = Integer.parseInt(br.readLine());
		int numOfLink = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[numOfCom + 1];
		visit = new boolean[numOfCom + 1];
		
		for (int i = 1; i <= numOfCom; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < numOfLink; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		bfs();
	}
	
	static void bfs() {
		
		int virus;
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(1);
		visit[1] = true;
		virus = 0;
		
		while (!q.isEmpty()) {
			int nowProcessing = q.poll();
			
			for (int nextProcessing : adj[nowProcessing]) {
				if (!visit[nextProcessing]) {
					visit[nextProcessing] = true;
					virus++;
					q.offer(nextProcessing);
				}
				
			}
		}
		
		System.out.println(virus);
	}
}
