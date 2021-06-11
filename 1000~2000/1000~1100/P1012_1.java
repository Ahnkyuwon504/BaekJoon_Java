package prj_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1012_1 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    
    static int widthOfGround;
    static int heightOfGround;
    static int numberOfCabbage;
    
    static int[][] ground;
    static boolean[][] visit;
    
    static int[] goLeftOrRight = {-1, 1, 0, 0};
    static int[] goUpOrDown = {0, 0, -1, 1};
    

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int numberOfInsect = 0;
            
            widthOfGround = Integer.parseInt(st.nextToken());
            heightOfGround = Integer.parseInt(st.nextToken());
            numberOfCabbage = Integer.parseInt(st.nextToken());
            
            ground = new int[widthOfGround][heightOfGround];
            visit = new boolean[widthOfGround][heightOfGround];
            
            for (int i = 0; i < numberOfCabbage; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int xOfCabbage = Integer.parseInt(st.nextToken());
                int yOfCabbage = Integer.parseInt(st.nextToken());
                        
                ground[xOfCabbage][yOfCabbage] = 1;
            }
            
            for (int i = 0; i < widthOfGround; i++) {
                for (int j = 0; j < heightOfGround; j++) {
                    visit[i][j] = false;
                }
             }
            
            for (int i = 0; i < widthOfGround; i++) {
                for (int j = 0; j < heightOfGround; j++) {
                    
                    if (!visit[i][j] && ground[i][j] == 1) {
                        getVisit(i, j);
                        numberOfInsect++;
                    }
                    
                }
             }
            
            sb.append(numberOfInsect).append("\n");
        }
        
        System.out.println(sb);
    }
    
    public static void getVisit(int x, int y) {
        
        visit[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int newX = x + goLeftOrRight[i];
            int newY = y + goUpOrDown[i];
            
            if (newX >= 0 && newY >= 0 && newX < widthOfGround && newY < heightOfGround) {
                if (!visit[newX][newY] && ground[newX][newY] == 1) {
                    getVisit(newX, newY);
                }
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
}
