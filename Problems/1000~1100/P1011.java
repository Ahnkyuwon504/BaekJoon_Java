package prj_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1011 {

    static int numberOfnodes;
    static int numberOfrules;
    static int[] timeTobuild;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int startingLocation = Integer.parseInt(st.nextToken());
            int arrivingLocation = Integer.parseInt(st.nextToken());
            
            int distance = arrivingLocation - startingLocation;
            int count = 1;
            
            while (true) {
                if (distance <= Math.pow(count, 2)) {
                    double beforenumber = Math.pow(count - 1, 2);
                    double afternumber = Math.pow(count, 2);
                    
                    if (distance >= (afternumber + beforenumber) / 2) {
                        sb.append((2*(count-1) + 1)).append("\n");
                    } else {
                        sb.append((2*(count-1))).append("\n");
                    }
                    break;
                }
                
                
                count++;
            }
            
        }
        
        System.out.println(sb);
    }
}
