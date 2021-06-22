package prj_baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1029 {
    
    static int numArtists;
    static int[][] tradeMap;
    static boolean[] visit;
    static int price;
    static int result;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        numArtists = Integer.parseInt(br.readLine());
        tradeMap = new int[numArtists + 1][numArtists + 1];
        visit = new boolean[numArtists + 1];
        
        for (int i = 1; i <= numArtists; i++) {
            String oneLine = br.readLine();
            for (int j = 1; j <= numArtists; j++) {
                tradeMap[i][j] = Integer.parseInt(oneLine.substring(j-1, j));
            }
        }
        
        result = 0;
        Arrays.fill(visit, false);
        find(1, 0, 1);
        System.out.println(result);
        

    }
    
    static void find(int cur, int price, int count) {
        
        visit[cur] = true;
        
        for (int i = 2; i <= numArtists; i++) {
            if (visit[i] == false && tradeMap[cur][i] >= price) {
                find(i, tradeMap[cur][i], count++);
            }
            
            if (count > result) {
                result = count;
            }
        }
       
        
        
    }

}
