package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1074 {
    
    static int N, r, c;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); 
        r = Integer.parseInt(st.nextToken()); 
        c = Integer.parseInt(st.nextToken()); 
        
        System.out.println(getVisit(N));
    }
    
    static int getVisit(int N) {
        if (N == 0) return 0;
        
        double y = Math.pow(2, N - 1);
        double x = Math.pow(2, N - 1);
        double sum = 0;
        
        if (r < y && c < x) {
            sum = 0;
        } else if (r < y && c >= x) {
            sum = Math.pow(2, 2*N - 2);
        } else if (r >= y && c < x) {
            sum = 2 * Math.pow(2, 2*N - 2);
        } else {
            sum = 3 * Math.pow(2, 2*N - 2);
        }
        
        r %= y;
        c %= x;
        
        return (int)sum + getVisit(N - 1);
    }
}
