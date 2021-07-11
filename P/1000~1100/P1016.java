package prj_baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1016 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        
        int count = 1;
        
        while (Math.pow(count, 2) <= max) {
            count++;
        }
        
        System.out.println(max - min + 2 - count);
    }
}
