package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1389 {
    
    static int N, M;
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[][] result;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        result = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<Integer>();
        }
                
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            adj[u].add(v);
            adj[v].add(u);
        }
        
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            bfs(i);
        }
        
        int kevin = Integer.MAX_VALUE;
        int minKevin = 0;
        
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += result[i][j];
            }
            
            if (sum < kevin) {
                kevin = sum;
                minKevin = i;
            }
        }
        
        System.out.println(minKevin);
    }
    
    static void bfs(int who) {

        Queue<Integer> q = new LinkedList<Integer>();
        
        result[who][who] = 0;
        visited[who] = true;
        q.offer(who);
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int next : adj[now]) {
                if (visited[next]) continue;
                
                result[who][next] = result[who][now] + 1;
                visited[next] = true;
                q.offer(next);
            }
        }
    }
}
