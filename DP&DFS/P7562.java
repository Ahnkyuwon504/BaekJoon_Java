package prj_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {
    
    static int N;
    static int[][] dp = new int[300][300];
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N][N];
            
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
                    
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            bfs(x1, y1, x2, y2);
        }
        br.close();
    }
    
    static void bfs(int x1, int y1, int x2, int y2) {
        Queue<int[]> q = new LinkedList<int[]>();
        
        q.offer(new int[] {y1, x1});
        dp[y1][x1] = 0;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowProcessingY = now[0];
            int nowProcessingX = now[1];
            
            if (nowProcessingY == y2 && nowProcessingX == x2) {
                System.out.println(dp[nowProcessingY][nowProcessingX]);
                return;
            }
            
            for (int i = 0; i < 8; i++) {
                int nextProcessingY = nowProcessingY + dy[i];
                int nextProcessingX = nowProcessingX + dx[i];
                
                if (!isAvail(nextProcessingX, nextProcessingY)) continue;
                
                if (dp[nextProcessingY][nextProcessingX] != 0) continue;
                
                dp[nextProcessingY][nextProcessingX] = dp[nowProcessingY][nowProcessingX] + 1;
                q.offer(new int[] {nextProcessingY, nextProcessingX});
            }
        }
        System.out.println(0);
    }
    
    static boolean isAvail(int x, int y) {
        if ((0 <= x && x < N) && (0 <= y && y < N)) return true;
        return false;
    }

}
