package algorithmic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P6_FESTIVAL {
    
    static int N;
    static int L;
    
    static double[] cost;
    static double[][] dp;
             

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int C = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < C; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            cost = new double[N + 1];
            dp = new double[N + 1][N + 1];
            
            st = new StringTokenizer(br.readLine());
            for (int day = 1; day <= N; day++) {
                cost[day] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[day], -1);
            }
            
            double result = 100;
            
            for (int i = 1; i <= N; i++) {
                for (int j = L; j <= N; j++) {
                    if (dfs(i, j) > 0) {
                        result = Math.min((dfs(i, j) / j), result);
                    }
                }
            }
            System.out.println(result);
        }
    }
    
    static double dfs(int day, int howLong) {
        if (howLong < 1 || day > N || howLong > N || day+howLong > N) return 0;
        if (howLong == 1) return dp[day][howLong] = cost[day];
        if (dp[day][howLong] != -1) return dp[day][howLong];
        
        dp[day][howLong] = dfs(day, howLong - 1) + cost[day + howLong - 1];
        
        return dp[day][howLong];
    }
}
