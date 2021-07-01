package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2606_1 {
	
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
		
		dfs(1);
		
		int cnt = 0;
		for (boolean isVisit : visit) {
			if (isVisit) cnt++;
		}
		System.out.println(cnt - 1);
		
	}
	
	static void dfs(int start) {
		visit[start] = true;
		
		for (int nextNode : adj[start]) {
			if (!visit[nextNode]) dfs(nextNode);
		}
	}
}
