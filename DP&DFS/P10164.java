package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10164 {
    
    static int n;
    static int m;
    static int k;
    static int tarN, tarM;
    
    
    static int[][] board;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
       board = new int[n][m];
       int cnt = 1;
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < m; j++) {
               if (k == cnt) {
                   tarN = i;
                   tarM = j;
               }
               board[i][j] = cnt++;
           }
       }
       
       int result = 0;
       
       if (k == 0) {
           result = getNumOfRoute(0, 0, n - 1, m - 1);
       } else {
           result = getNumOfRoute(0, 0, tarN, tarM) * getNumOfRoute(tarN, tarM, n - 1, m - 1);
       }
       System.out.println(result);
    }
    
    static int getNumOfRoute(int x1, int y1, int x2, int y2) {
        int up = 1;
        int down = 1;
        
        for (int i = 1; i <= (y2 - y1); i++) {
            down *= i;
        }
        for (int i = (x2 - x1 + 1); i <= (y2 - y1 + x2 - x1); i++) {
            up *= i;
        }
        return up/down;
    }
}
