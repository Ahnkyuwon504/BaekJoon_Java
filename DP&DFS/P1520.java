package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1520 {
    
    static int[][] map;
    static int[][] visited;
    
    static int height;
    static int width;
    
    static int[] goUpDown = {-1, 1, 0, 0};
    static int[] goLeftRight = {0, 0, -1, 1};
    
    static int result = 0;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        map = new int[510][510];
        visited = new int[510][510];
        
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine()); 
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        goLower(0, 0);
        
        System.out.println(result);
    }
    
    static void goLower(int y, int x) {
        
        for (int i = 0; i < 4; i++) {
            int newY = y + goUpDown[i];
            int newX = x + goLeftRight[i];
            
            
            if (newY >= 0 && newX >= 0 && newY < height && newX < width && map[y][x] > map[newY][newX]) {
                    if (newY == height - 1 && newX == width - 1) result++;
                    goLower(newY, newX);
                    
            }
        }
    }
}
