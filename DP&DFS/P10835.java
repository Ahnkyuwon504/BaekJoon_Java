package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10835 {
    
    static int n;
    static int[] left;
    static int[] right;
    
    static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        left = new int[n];
        right = new int[n];
        dp = new int[n][n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            right[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        System.out.println(dfs(0, 0));
    }
    
    static int dfs(int usedleftCard, int usedrightCard) {
        
        if (usedleftCard == n || usedrightCard == n) return 0;
        if (dp[usedleftCard][usedrightCard] != -1) return dp[usedleftCard][usedrightCard];
        
        int ret = 0;
        
        if (left[usedleftCard] > right[usedrightCard]) {
            ret = Math.max(ret, dfs(usedleftCard + 1, usedrightCard + 1));
            ret = Math.max(ret, dfs(usedleftCard + 1, usedrightCard));
            ret = Math.max(ret, dfs(usedleftCard, usedrightCard + 1) + right[usedrightCard]);
        } else {
            ret = Math.max(ret, dfs(usedleftCard + 1, usedrightCard + 1));
            ret = Math.max(ret, dfs(usedleftCard + 1, usedrightCard));
        }
        
        dp[usedleftCard][usedrightCard] = ret;
        return dp[usedleftCard][usedrightCard];
    }
}
