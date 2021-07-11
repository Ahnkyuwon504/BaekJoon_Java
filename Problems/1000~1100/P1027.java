package prj_baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1027 {
    
    static int[] xOfBuildings;
    static int[] yOfBuildings;
    static int howManyBuilding;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        howManyBuilding = Integer.parseInt(br.readLine());
        xOfBuildings = new int[howManyBuilding + 1];
        yOfBuildings = new int[howManyBuilding + 1];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= howManyBuilding; i++) {
            xOfBuildings[i] = i;
            yOfBuildings[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = Integer.MIN_VALUE;
        
        for (int i = 1; i <= howManyBuilding; i++) {
            result = Math.max(leftHowManyWatch(i) + rightHowManyWatch(i), result);
        }
        
        System.out.println(result);

    }
    
    static int leftHowManyWatch(int i) {
        if (i == 1) return 0;
        int tan = 0;
        int result = 0;
        
        for (int buildingIndex = i-1; buildingIndex >= 1; buildingIndex--) {
            int x = xOfBuildings[i] - xOfBuildings[buildingIndex];
            int y = yOfBuildings[i] - yOfBuildings[buildingIndex];
            
            if (buildingIndex == (i - 1)) {
                tan = y / -1 * x;
                result++;
                continue;
            }
            
            if (y / -1 * x > tan) {
                tan = y / -1 * x; 
                result++;
            }
        }
        
        return result;
    }
    
    static int rightHowManyWatch(int i) {
        if (i == howManyBuilding) return 0;
        int tan = 0;
        int result = 0;
        
        for (int buildingIndex = i+1; buildingIndex <= howManyBuilding; buildingIndex++) {
            int x = xOfBuildings[i] - xOfBuildings[buildingIndex];
            int y = yOfBuildings[i] - yOfBuildings[buildingIndex];
            
            if (buildingIndex == (i + 1)) {
                tan = y / x;
                result++;
                continue;
            }
            
            if (y / x > tan) {
                tan = y / x;
                result++;
            }
        }
        
        return result;
    }
    
    
    
    
    
    

}
