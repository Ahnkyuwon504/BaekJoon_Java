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

public class P3665 {
    
    static int n, m;
    static int[] last;
    static int[] indegree;
    static List<Integer>[] list;

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
            list = new ArrayList[n + 1];
            
            st = new StringTokenizer(br.readLine());
            
            Arrays.fill(indegree, 0);
            list[0] = new ArrayList<Integer>();
            
            for (int i = 1; i <= n; i++) {
                last[i] = Integer.parseInt(st.nextToken());
                list[i] = new ArrayList<Integer>();
            }
            
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    list[last[i]].add(last[j]);
                    indegree[last[j]]++;
                }
            }
            
            m = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int win = Integer.parseInt(st.nextToken());
                int lose = Integer.parseInt(st.nextToken());
                
                if (list[win].contains(lose)) {
                    list[win].remove((Integer)lose);
                    list[lose].add(win);
                    indegree[win]++;
                    indegree[lose]--;
                } else {
                    list[lose].remove((Integer)win);
                    list[win].add(lose);
                    indegree[win]--;
                    indegree[lose]++;
                }
            }
            topologicalSort();
        }
    }
    
    static void topologicalSort() {
        Queue<Integer> q = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();
        
        int firstCnt = 0;
        
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                firstCnt++;
            }
        }
        
        if (firstCnt > 1) {
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
            
            for (int to : list[from]) {
                indegree[to]--;
                if (indegree[to] == 0) q.offer(to);
            }
        }
        System.out.println(sb);
    }
}
