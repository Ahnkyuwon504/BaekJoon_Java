package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2292 {
    
    static int[] cache = new int[1000];
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        N = (N-1)/6;
        
        int cnt = 0;
        Arrays.fill(cache, -1);
        while (N > getSum(cnt)) {
            cnt++;
        }
        System.out.println(cnt + 1);
    }
    
    static int getSum (int num) { 
        if (num == 0) return 0;
        if (cache[num] != -1) return cache[num];
        
        cache[num] = getSum(num - 1) + num;
        return cache[num];
    }
}
