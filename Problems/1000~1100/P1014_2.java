package prj_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1014_2 {
    
    static int height, width;
    static int DP[][];
    static boolean obstacles[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            
            height = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            
            DP = new int[1 << height][width];
            obstacles = new boolean[height][width];
            
            for (int n = 0; n < (1 << height); n++) {
                Arrays.fill(DP[n], -1);
            }
            
            for (int n = 0; n < height; n++) {
                String oneLine = br.readLine();
                for (int m = 0; m < width; m++) {
                    if(oneLine.substring(m, m+1).equals("x")) obstacles[n][m] = true;
                }
            }
            
           sb.append(getDP(0, 0)).append("\n");
            
        }
        
        System.out.println(sb);
        
        br.close();
        
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
        
        int result = getDP(0, m+1); // 학생을 앉히지 않는 경우
        
        for (int i = 1; i < (1 << height); i++) { // 학생을 앉히는 경우
            if ((i & lastN) > 0) continue;
            
            int lineStudent = 0;
            
            boolean isAvail = true;
            
            for (int j = 0; j < height && isAvail; j++) {
                if ((i & (1 << j)) > 0) {
                    lineStudent++;
                    if (obstacles[j][m]) isAvail = false;
                }
            }
            
            if (!isAvail) continue;
            
            result = Math.max(result, getDP(i, m+1) + lineStudent);
        }
        
        return DP[n][m] = result;
    }
}
