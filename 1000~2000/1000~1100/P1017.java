package prj_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class P1017 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Integer> result = new ArrayList<Integer>();
        
        int T = Integer.parseInt(br.readLine()); // 첫 번째 줄, 리스트의 크기 N
        
        st = new StringTokenizer(br.readLine()); // 두 번째 줄, 리스트의 숫자 나열
        int firstNumber = Integer.parseInt(st.nextToken()); // 첫 번째 숫자
        
        List<Integer> arrayOfNumbers = new ArrayList<Integer>();   // 첫 번째 숫자를 제외한 숫자들을 담을 array
                
        for (int tc = 0; tc < T - 1; tc++) { // 첫째 숫자와 쌍을 이루어 줌.. 테스트 개수
            int pairOfFirstNumber = 0;
            
            for (int i = 0; i < T - 1; i++) {
                if (i == tc) {
                    pairOfFirstNumber = Integer.parseInt(st.nextToken());
                    continue;
                }
                arrayOfNumbers.add(Integer.parseInt(st.nextToken())); // 이후 숫자들을 array에 삽입
            }
            
            if (!isPrime(firstNumber + pairOfFirstNumber)) continue;
            
            
            
            
        }

    }
    
    static boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2) return true;
        
        double m = Math.sqrt(n);
        
        for (int i = 2; i < m; i++) {
           if (n%i == 0) {
               return false; 
           }
        }
        
        return true;
    }
}
