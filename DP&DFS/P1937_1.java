package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1937_1 {
    static int n;
    static int[][] forest;
    static int[][] dp;
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        forest = new int[n][n];
        dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < n; j++) {
               forest[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        System.out.println(ans);
    }
    
    static int dfs(int y, int x) {
        if (dp[y][x] != -1) return dp[y][x];
        
        dp[y][x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if (isAvail(ny, nx) && forest[ny][nx] > forest[y][x]) {
                dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
            }
        }
        
        return dp[y][x];
    }
    
    static boolean isAvail(int y, int x) {
        if (y >= 0 && x >= 0 && y < n && x < n) return true;
        return false;
    }
}
