package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1563 {
    
    static int[][][] cache = new int[5][5][5];
    
    static int N;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        System.out.println(dfs(0, 0, 0));
    }
    
    static int dfs(int day, int late, int absent) {
        if (late == 2 || absent == 3) return 0;
        
        if (day == N) return 1;
        
        if (cache[day][late][absent] == 0) {
            cache[day][late][absent] = dfs(day+1, late, 0) + dfs(day+1, late+1, 0) + dfs(day+1, late, absent+1);
        }
        
        return cache[day][late][absent];
    }
}
