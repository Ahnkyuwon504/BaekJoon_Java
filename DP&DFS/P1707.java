package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1707 {
    
    static int V;
    static int E;
    static int[] color;
    static ArrayList<Integer>[] list;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            
            V = Integer.parseInt(st.nextToken()); // vertex
            E = Integer.parseInt(st.nextToken()); // edge
            
            // 매핑을 위한 double arrayList 초기화
            list = (ArrayList[]) new ArrayList[V];
            
            // list에 점 개수만큼 add
            for (int i = 0; i < V; i++) {
                list[i] = new ArrayList<Integer>();
            }
            
            // 색칠을 위한 double array 초기화
            color = new int[V];
            
            // color 모두 0으로 초기화, 0은 미방문
            // 색깔을 칠하는 dfs는 1부터 시작, 방문 후에는 1과 2 번갈아서
            Arrays.fill(color, 0);
            
            // node 저장
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                
                list[u - 1].add(v - 1);
                list[v - 1].add(u - 1);
            }
            
            for (int i = 0; i < V; i++) {
                if (color[i] == 0) {
                    dfs(i, 1);
                }
            }
            
            boolean isBipartite = true;
            
            for (int i = 0; i < V; i++) {
                for (int node : list[i]) {
                    if (color[i] == color[node]) {
                        isBipartite = false;
                    }
                }
            }
            
            if (isBipartite) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    
    static void dfs(int whatVertex, int nowColor) {
        color[whatVertex] = nowColor;
        
        for (int nextVertex : list[whatVertex]) {
            if (color[nextVertex] == 0) {
                dfs(nextVertex, 3 - nowColor);
            }
        }
    }
}
