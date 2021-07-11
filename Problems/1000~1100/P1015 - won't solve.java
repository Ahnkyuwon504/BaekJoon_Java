package prj_baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1014_3 {
    
    static int height, width;
    static int DP[][];
    static boolean obstacles[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            
            height = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            
            DP = new int[(1 << height)][width];
            obstacles = new boolean[height][width];
            
            for (int[] arrays : DP) {
                Arrays.fill(arrays, -1);
            }
            
            for (int i = 0; i < height; i++) {
                String oneLine = br.readLine();
                
                for (int j = 0; j < width; j++) {
                    if (oneLine.substring(j, j+1).equals("x")) obstacles[i][j] = true;
                }
            }
            
            sb.append(getDP(0, 0)).append("\n");
        }
        
        System.out.println(sb);

    }
    
    static int getDP(int n, int m) {
        if (m == width) return 0;
        if (DP[n][m] != -1) return DP[n][m];
        
        int lastN = n;
        
        for (int i = 0; i < height; i++) {
            if ((n & (1 << i)) > 0) {
                lastN |= (1 << (i + 1));
                lastN |= (1 << (i - 1));
            }
        }
        
        int result = getDP(0, m+1);
        
        for (int i = 1; i < (1 << height); i++) {
            if ((i & lastN) > 0) continue;
            
            int student = 0;
            boolean isAvail = true;
            
            for (int j = 0; j < height && isAvail; j++) {
                if ((i & (1 << j)) > 0) {
                    student++;
                    if (obstacles[j][m]) isAvail = false;
                }
            }
            
            if (!isAvail) continue;
            
            result = Math.max(result, getDP(i, m + 1) + student);
        }
        
        return DP[n][m] = result;
                
        
    }

}
