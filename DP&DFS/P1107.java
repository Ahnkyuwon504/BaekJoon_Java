package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1107 {
    
    static int N, M;
    static int[] broken;
    static int result;
    static int originalChannel;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        if (M == 0) {
            System.out.println(getLength(N));
            return;
        }
        
        originalChannel = N;
        broken = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            broken[i] = Integer.parseInt(st.nextToken());
        }
        
        if (M == 10) {
            System.out.println(Math.abs(originalChannel - 100)); 
        } else {
            getClick();
            System.out.println(Math.min(Math.abs(originalChannel - 100), result));
        }
    }
    
    static void getClick() {
        int newChannel = 0;
        int length = getLength(N);
        
        for (int i = 0; i < length; i++) {
            int nowButton = N % (int)Math.pow(10, i + 1) / (int)Math.pow(10, i);
            int newButton = getNewButton(nowButton);
            
            newChannel += newButton * (int)Math.pow(10, i);
            
            N = N - N%(int)Math.pow(10, i + 1);
        }
        
        result = Math.abs(newChannel - originalChannel) + length;
    }
    
    static int getLength(int channel) {
        int cnt = 0;
        while (true) {
            if (channel == 0) break;
            channel /= 10;
            cnt++;
        }
        return cnt;
    }
    
    static boolean isAvail(int num) {
        boolean avail = true;
        for (int i = 0; i < broken.length; i++) {
            if (broken[i] == num) avail = false;
        }
        return avail;
    }
    
    static int getNewButton(int nowButton) {
        int diff = Integer.MAX_VALUE;
        int newButton = 0;
        
        for (int i = 0; i < 10; i++) {
            if (!isAvail(i)) continue;
            if (Math.abs(nowButton - i) < diff) {
                diff = Math.abs(nowButton - i);
                newButton = i;
            }
        }
        return newButton;
    }
}
