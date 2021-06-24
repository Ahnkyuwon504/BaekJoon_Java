package algorithmic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P6_FESTIVAL {
    
    static int N;
    static int L;
    
    static int[] cost;
    static int[][] dp;
             

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int C = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < C; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            cost = new int[N + 1];
            dp = new int[N + 1][N + 1];
            
            st = new StringTokenizer(br.readLine());
            for (int day = 1; day <= N; day++) {
                cost[day] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[day], -1);
            }
            
            double result = 100;
            
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    result = Math.min(result, dfs(i, j));
                }
            }
            System.out.println(result);
            
        }
        
        

    }
    
    static int dfs(int day, int howLong) {
        
        if (day > N || howLong > N || day+howLong > N) return 0;
        if (dp[day][howLong] != -1) return dp[day][howLong];
        
        if (howLong == 1) {
            return dp[day][howLong] = cost[day];
        }
        
        dp[day][howLong] = (dfs(day, howLong + 1) * (howLong + 1) - cost[day + 1]) / howLong;
        
        return dp[day][howLong];
    }
}
