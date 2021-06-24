package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    
    static int N;
    static int M;
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
        
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            String oneLine = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(oneLine.substring(j, j+1));
            }
        }
        
        bfs(0, 0);
        System.out.println(map[N - 1][M - 1]);
    }
    
    static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {y, x});
        
        while (!queue.isEmpty()) {
            int[] nowlocation = queue.poll();
            int nowY = nowlocation[0];
            int nowX = nowlocation[1];
            visited[nowY][nowX] = true;
            
            for (int i = 0; i < 4; i++) {
                int newY = nowY + dy[i];
                int newX = nowX + dx[i];
                
                if (isInside(newY, newX) && map[newY][newX] != 0 && !visited[newY][newX]) {
                    queue.offer(new int[] {newY, newX});
                    visited[newY][newX] = true;
                    map[newY][newX] = map[nowY][nowX] + 1;
                }
            }
            
            
        }
        
        
        
        
    }
    
   
    
    static boolean isInside(int y, int x) {
        return (y >= 0 && y < N) && (x >= 0 && x < M);
    }
}
