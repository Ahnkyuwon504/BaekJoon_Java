package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1766 {
    
    static ArrayList<Integer>[] adj;
    static StringBuilder sb;
    static int[] indegree;
    
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
        indegree = new int[N + 1];
        
        for (int i = 0; i <= N; i++ ) {
            adj[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            adj[u].add(v);
            
            indegree[v]++;
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(" ");
            
            for (int i : adj[node]) {
                indegree[i]--;
                
                if (indegree[i] == 0) q.offer(i);
            }
        }
        
        System.out.println(sb);
    }
    


}
