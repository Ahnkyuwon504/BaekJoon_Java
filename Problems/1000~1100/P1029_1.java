package prj_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1029_1 {
    static int numArtists;
    static int[][] tradeMap;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        numArtists = Integer.parseInt(br.readLine());
        tradeMap = new int[numArtists][numArtists];
        
        for (int i = 0; i < numArtists; i++) {
            String oneLine = br.readLine();
            for (int j = 0; j < numArtists; j++) {
                tradeMap[i][j] = Integer.parseInt(oneLine.substring(j, j + 1));
            }
        }
        
        System.out.println(getMaxOwner(0, 1, 0));

    }
    
    static int getMaxOwner(int cur, int visit, int price) {
        
        int ret = 1;
        visit |= (1<<cur);
        
        for (int i = 0; i < numArtists; i++) {
            if (cur != i && tradeMap[cur][i] >= price && ((visit & (1 << i)) == 0)) {
                ret = Math.max(ret, getMaxOwner(i, visit, tradeMap[cur][i]) + 1);
            }
        }
        
        return ret;
    }

}
