package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1520_2 {
    
    static int M, N;
    static int[][] map, DP;
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[M][N];
        DP = new int[M][N];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                DP[i][j] = -1;
            }
        }
        System.out.println(dfs(M - 1, N - 1));
    }
    
    static int dfs(int y, int x) {
        if (y == 0 && x == 0) {
            return 1;
        }
        
        if (DP[y][x] == -1) {
            DP[y][x] = 0;
            for (int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];
                
                if (0 <= newX && newX < N && 0 <= newY && newY < M) {
                    if (map[newY][newX] > map[y][x]) {
                        DP[y][x] += dfs(newY, newX);
                    }
                }
            }
        }
        return DP[y][x];
    }
}
