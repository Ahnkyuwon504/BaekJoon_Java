package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
    int y, x;
    public Location(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class P2178_bfs {
    
    static int N, M;
    static int[][] map;
    static int[][] visited;
    
    static int[] moveX = {0, 0, -1, 1};
    static int[] moveY = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String oneLine = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(oneLine.substring(j, j+1)); 
            }
            Arrays.fill(visited[i], 0);
        }
        
        bfs();
    }
    
    static void bfs() {
        Queue<Location> readyToProcess = new LinkedList<>();
        readyToProcess.offer(new Location(0, 0));
        visited[0][0] = 1;
        
        while (!readyToProcess.isEmpty()) {
            Location nowLocation = readyToProcess.poll();
            int nowY = nowLocation.y;
            int nowX = nowLocation.x;
            
            for (int i = 0; i < 4; i++) {
                int newY = nowY + moveY[i];
                int newX = nowX + moveX[i];
                
                if (isInside(newY, newX) && visited[newY][newX] == 0 && map[newY][newX] != 0) {
                    visited[newY][newX] = visited[nowY][nowX] + 1;
                    Location newLocation = new Location(newY, newX);
                    readyToProcess.offer(newLocation);
                }
            }
        }
        
        System.out.println(visited[N - 1][M - 1]);
    }
    
    static boolean isInside(int y, int x) {
        return (y >= 0 && y < N) && (x >= 0 && x < M);
    }
}
