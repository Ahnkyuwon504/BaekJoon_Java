package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1520_1 {
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map, dp;
    static int m, n;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        map = new int[m][n];
        dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()); 
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(m-1, n-1));
        System.out.println(dp[0][0]);
        
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

    }
    
    static int dfs(int y, int x) {
        System.out.println("=============================");
        System.out.println("y is " + y + " and x is " + x);

        
        if (y == 0 && x == 0) {
            System.out.println("dp[" + y + "][" + x + "] is " + dp[y][x]);
            return 1;
        }
        
        if (dp[y][x] == -1) {
            System.out.println("if문을 탄다");
            dp[y][x] = 0;
            for (int i = 0; i < 4; i++) {
                
                if (i == 0) {
                    System.out.println("왼쪽 for문을 탄다");
                }
                
                if (i == 1) {
                    System.out.println("위쪽 for문을 탄다");
                }
                
                if (i == 2) {
                    System.out.println("오른쪽 for문을 탄다");
                }
                
                if (i == 3) {
                    System.out.println("아래쪽 for문을 탄다");
                }
                
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (map[y][x] < map[ny][nx]) {
                        System.out.println("ny is " + ny + " and nx is " + nx);
                        dp[y][x] += dfs(ny, nx);
                    }
                }
            }
            
            
            
        }
        System.out.println("dp[" + y + "][" + x + "] is " + dp[y][x]);
        return dp[y][x];
                
        
        
        
        
    }

}
