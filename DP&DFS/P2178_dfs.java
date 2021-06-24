package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2178_dfs {
    static int N, M, minVal;
    static int[][] map;
    static boolean[][] visited;
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        minVal = Integer.MAX_VALUE;
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            String oneLine = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(oneLine.substring(j, j+1)); 
            }
        }
        
        dfs(0, 0, 1);
        System.out.println(minVal);
    }
    
    static void dfs(int y, int x, int count) {
        if ((y == N - 1) && (x == M - 1)) {
            minVal = Math.min(minVal, count);
            return;
        }
        
        if (count > minVal) return;
        
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if (isInside(ny, nx) && map[ny][nx] != 0 && !visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(ny, nx, count + 1);
                visited[ny][nx] = false;
            }
        }
    }
    
    static boolean isInside(int y, int x) {
        return (y >= 0 && y < N) && (x >= 0 && x < M);
    }
}
