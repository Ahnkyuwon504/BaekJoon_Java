package prj_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1012 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    
    static int width;
    static int height;
    static int numberOfCabbage;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static int[][] cabbageMap;
    static boolean[][] visit;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int testNumber = 1; testNumber <= T; testNumber++) {
            
            st = new StringTokenizer(br.readLine(), " ");
            
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            numberOfCabbage = Integer.parseInt(st.nextToken());
            
            cabbageMap = new int[width][height];
            visit = new boolean[width][height];
            
            // 배추지도에 저장
            for (int cabbageNumber = 1; cabbageNumber <= numberOfCabbage; cabbageNumber++) {
                st = new StringTokenizer(br.readLine());
                int xOfcabbage = Integer.parseInt(st.nextToken());
                int yOfcabbage = Integer.parseInt(st.nextToken());
                cabbageMap[xOfcabbage][yOfcabbage] = 1;
            }
            
            // 구역 수
            int count = 0;
            
            // 배추 있으면 dfs 탐색 시작
            for (int i = 0; i < width; i++) {
                for (int j= 0; j < height; j++) {
                    // 배추 있는데 방문 안했으면 dfs 탐색, 구역 1 증가
                    if (cabbageMap[i][j] == 1 && !visit[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static void dfs(int r, int c) {
        
        visit[r][c] = true;
        
        for (int i = 0; i < 4; i++) {
            
            // i=0일땐 좌, i=1일땐 우, i=2일땐 하, i=3일땐 상
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr >= 0 && nc >= 0 && nr < width && nc < height) {
                if (cabbageMap[nr][nc] == 1 && !visit[nr][nc]) {
                    dfs(nr, nc);
                }
            }
        }
    }
}
