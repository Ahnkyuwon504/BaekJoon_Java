package dpdfsmemorization;

import java.util.Scanner;

public class P1563_1 {
    
    static int N;
    static int[][][] dp = new int[4][4][4];

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        System.out.println(dfs(0, 0, 0));
    }
    
    static int dfs(int attend, int late, int absent) {
        if (late == 2 || absent == 3) return 0;
        if (attend == 4) return 1;
        
        if (dp[attend][late][absent] == 0) {
            dp[attend][late][absent] = dfs(attend+1,late,0) + dfs(attend+1,late+1,0) + dfs(attend+1,late,absent+1);
        }
        return dp[attend][late][absent];
    }
}
