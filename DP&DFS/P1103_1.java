package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1103_1 {
    
    static int n, m;
    static int[][] map, dp;
    static boolean[][] visit;
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    static boolean isOver = false;
  
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        dp = new int[n][m];
        visit = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == 'H') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = Integer.parseInt(line.substring(j, j+1));
                }
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0));
    }
    
    static int dfs(int y, int x) {
        if (y < 0 || x < 0 || y >= n || x >= m || map[y][x] == 0) return 0;
        if (visit[y][x]) isOver = true;
        if (dp[y][x] != -1) return dp[y][x];
        
        visit[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + map[y][x] * dy[i];
            int nx = x + map[y][x] * dx[i];
            
            dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
        }
        
        visit[y][x] = false;
        
        if (isOver) return -1;
        return dp[y][x];
    }
}
