package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1676 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		for (int i = 1; i <= N; i++) {
			if (i % 5 == 0) {
				ans += getAns(i);
			}
		}
		
		System.out.println(ans);
	}
	
	static int getAns(int i) {
		int cnt = 0;
		while(true) {
			i /= 5;
			cnt++;
			if (i/5 == 0) break;
		}
		return cnt;
	}

}
