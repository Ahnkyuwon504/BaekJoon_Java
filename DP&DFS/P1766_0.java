package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1766 {
    
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static StringBuilder sb;
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        
        for (int i = 0; i <= N; i++ ) {
            adj[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            adj[u].add(v);
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        for (int i = 1; i <= N; i++) {
            if (adj[i].size() != 0) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int now = q.poll();
            bfs(now);
        }
        
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                sb.append(i).append(" ");
            }
        }
        
        System.out.println(sb);

    }
    
    static void bfs(int now) {
        visit[now] = true;
        sb.append(now).append(" ");
        
        if (adj[now].size() != 0) {
            int next = adj[now].get(0);
            if (!visit[next]) bfs(next);
        }
    }

}
