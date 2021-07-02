package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1003 {
    
    static class Fibonacci{
        int cntZero;
        int cntOne;
        
        public Fibonacci(int cntZero, int cntOne) {
            this.cntZero = cntZero;
            this.cntOne = cntOne;
        }
    }
    
    static Fibonacci[] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            dp = new Fibonacci[N + 1];
            
            System.out.printf("%d %d\n", DP(N).cntZero, DP(N).cntOne);
        }
    }
    
    static Fibonacci DP(int N) {
        if (dp[N] != null) return dp[N];
        
        if (N == 0) {
            dp[0] = new Fibonacci(1, 0);
            return dp[0];
        }
        if (N == 1) {
            dp[1] = new Fibonacci(0, 1);
            return dp[1];
        }
        
        dp[N] = new Fibonacci(DP(N - 1).cntZero + DP(N - 2).cntZero, DP(N - 1).cntOne + DP(N - 2).cntOne);
        
        return dp[N];
    }
}
