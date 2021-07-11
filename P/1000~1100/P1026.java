package prj_baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1026 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int lengthOfArray = Integer.parseInt(br.readLine());
        
        int[] arrA = new int[lengthOfArray];
        int[] arrB = new int[lengthOfArray];
        
        int result = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lengthOfArray; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lengthOfArray; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        
        for (int i = 0; i < lengthOfArray; i++) {
            result += arrA[i] * arrB[lengthOfArray  - 1 - i];
        }
        
        System.out.println(result);
    }
}
