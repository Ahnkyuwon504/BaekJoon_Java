package prj_baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1024 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        String result = "-1";
        
        for (int i = L; i <= 100; i++) {
            int secondPart = (i - 1) * i / 2;
            if ((N - secondPart)%i == 0) {
                
                int startNum = (N - secondPart) / i;
                
                if (startNum < 0) {
                    break;
                }
                result = "";
                for (int j = 0; j < i; j++) {
                    result+=(startNum + j);
                    result+=" ";
                }
                
                break;
            }
        }
        System.out.println(result);

    }

}
