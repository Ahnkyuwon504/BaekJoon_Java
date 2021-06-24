package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2805 {
    
    static int N, M;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        
        int ans = 0;
        for (int i = 1; i < 1000000; i++) {
            int returnTree = getTree(i);
            
            if (returnTree == 0) break;
            if (returnTree >= M) {
                ans = Math.max(ans, i);
            }
        }
        System.out.println(ans);
    }
    
    static int getTree(int cutHeight) {
        int get = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] > cutHeight) get += (trees[i] - cutHeight);
        }
        return get;
    }
}
