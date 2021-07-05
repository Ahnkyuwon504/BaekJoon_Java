package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3665_1 {

    static int[] last;
    static int[] indegree;
    static List<Integer>[] adj;
    
    static int n;
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            
            last = new int[n + 1];
            indegree = new int[n + 1];
            adj = new ArrayList[n + 1];
            
            st = new StringTokenizer(br.readLine());
            
            for (int i = 1; i <= n; i++) {
                last[i] = Integer.parseInt(st.nextToken());
                adj[i] = new ArrayList<Integer>();
            }
            
            for (int i = 1; i <= n; i++) {
                int from = last[i];
                for (int j = i + 1; j <= n; j++) {
                    int to = last[j];
                    indegree[to]++;
                    adj[from].add(to);
                }
            }
            
            int m = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                
                int win = Integer.parseInt(st.nextToken());
                int lose = Integer.parseInt(st.nextToken());
                
                if (adj[lose].contains(win)) {
                    adj[lose].remove((Integer)win);
                    adj[win].add(lose);
                    indegree[lose]++;
                    indegree[win]--;
                } else {
                    adj[win].remove((Integer)lose);
                    adj[lose].add((Integer)win);
                    indegree[win]++;
                    indegree[lose]--;
                }
            }
            
            topologicalSort();
        }
    }
    
    static void topologicalSort() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<Integer>();
        
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                cnt++;
            }
        }
        
        if (cnt > 1) {
            System.out.println("?");
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (q.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }
            
            int from = q.poll();
            sb.append(from).append(" ");
            
            for (int to : adj[from]) {
                indegree[to]--;
                
                if (indegree[to] == 0) q.offer(to);
            }
        }
        
        System.out.println(sb);
    }
}
