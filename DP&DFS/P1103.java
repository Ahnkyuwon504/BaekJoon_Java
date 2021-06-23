package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1103 {
    // 조건의 위치 중요
    // map에서 나가도 된다면 dp통과 전 조건 거는게 낫고
    // map에서 나가면 안된다면 dp통과 후 조건 거는게 낫다..
    static int n, m;
    static int[][] map;
    static int[][] dp;
    static boolean[][] visit;
    static boolean overFlow = false;
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

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
            String oneLine = br.readLine();
            for (int j = 0; j < m; j++) {
                if (oneLine.substring(j, j+1).equals("H")) {
                    map[i][j] = 0;
                    dp[i][j] = -1;
                    continue;
                } 
                map[i][j] = Integer.parseInt(oneLine.substring(j, j+1));
                dp[i][j] = -1;
                
            }
        }
        System.out.println(dfs(0, 0));
    }
    
    static int dfs(int y, int x) {
        if (x < 0 || y < 0 || x >= m || y >= n || map[y][x] == 0) return 0;
        if (visit[y][x] == true) overFlow = true; 
        if (dp[y][x] != -1) return dp[y][x];
        
        visit[y][x] = true;
        dp[y][x] = 0;
        
        for (int i = 0; i < 4; i++) {
            int ny = y + map[y][x] * dy[i];
            int nx = x + map[y][x] * dx[i];
            dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
        }
        visit[y][x] = false;
        
        if (overFlow == true) return -1;
        return dp[y][x];
    }

}
