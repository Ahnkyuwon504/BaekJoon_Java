package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17090 {
    
    static int height;
    static int width;
    
    static char[][] map = new char[510][510];
    static boolean[][] visited = new boolean[510][510];
    
    static int result = 0;
    
    static int[] goUpDown = {-1, 1, 0, 0};
    static int[] goLeftRight = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < height; i++) {
            String oneLine = br.readLine();
                    
            for (int j = 0; j < width; j++) {
                map[i][j] = oneLine.charAt(j);
            }
        }
        
        
        for (int i = 0; i < height; i++) {
            
            for (int j = 0; j < width; j++) {
                
               for (int m = 0; m < height; m++) {
                   Arrays.fill(visited[m], false);
               }
               escape(i, j);
            }
        }
        
        System.out.println(result);
    }
    
    static void escape(int y, int x) {
        visited[y][x] = true;
        
        int newY = 0;
        int newX = 0;
        
        switch (map[y][x]) {
        case 'U' : newY = y + goUpDown[0];
                   newX = x + goLeftRight[0];
                   
                   if (newY == height || newX == width || newY == -1 || newX == -1) {
                       result++;
                       break;
                   }
                   
                   if (!visited[newY][newX]) {
                       escape(newY, newX);
                   }
                   break;
                   
        case 'D' : newY = y + goUpDown[1];
                   newX = x + goLeftRight[1];
                   
                   if (newY == height || newX == width || newY == -1 || newX == -1) {
                       result++;
                       break;
                   }
                   if (!visited[newY][newX]) {
                       escape(newY, newX);
                   }
                   break;
                   
                   
        case 'L' : newY = y + goUpDown[2];
                   newX = x + goLeftRight[2];
                   
                   if (newY == height || newX == width || newY == -1 || newX == -1) {
                       result++;
                       break;
                   }
                   if (!visited[newY][newX]) {
                       escape(newY, newX);
                   }
                   break;
                   
                   
        case 'R' : newY = y + goUpDown[3];
                   newX = x + goLeftRight[3];
                   
                   if (newY == height || newX == width || newY == -1 || newX == -1) {
                       result++;
                       break;
                   }
                   if (!visited[newY][newX]) {
                       escape(newY, newX);
                       
                   }
                   break;
        }
    }
}
