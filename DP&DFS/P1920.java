package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1920 {
    
    static int N, M;
    static int[] arrN, arrM;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arrN = new int[N];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        
        M = Integer.parseInt(br.readLine());
        arrM = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
            System.out.println(isExist(arrM[i]));
        }
    }
    
    static int isExist(int num) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i] == true) continue;
            
            if (arrN[i] == num) {
                result = 1;
                visited[i] = true;
            }
        }
        return result;
    }
}
