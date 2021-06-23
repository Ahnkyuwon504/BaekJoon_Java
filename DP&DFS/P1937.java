package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1937 {
    
    static int n;
    static int[][] forest;
    static int[][] dp;
    static boolean[][] visit;
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        forest = new int[n][n];
        dp = new int[n][n];
        visit = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    Arrays.fill(visit[k], false);
                }
                result = Math.max(result, dfs(i, j));
            }
        }
        System.out.println(result + 1);
    }
    
    static int dfs(int y, int x) {
        if (visit[y][x]) return 0;
        visit[y][x] = true;
        
        if (dp[y][x] == -1) {
            dp[y][x] = 0;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny >= 0 && ny < n && nx >= 0 && nx < n && forest[ny][nx] > forest[y][x]) {
                    dp[y][x] =  Math.max(dp[y][x], dfs(ny, nx) + 1);
                }
            }
        }
        visit[y][x] = false;
        return dp[y][x];
    }
}
