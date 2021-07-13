package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17626 {
	
	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[50001];
		dp[1] = 1;
		
		getDP();
		
		System.out.println(dp[N]);
	}
	
	static void getDP() {
		
		for (int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			
			for (int j = 1; j * j <= i; j++) {
				int temp = i - j * j;
				min = Math.min(min, dp[temp]);
			}
			
			dp[i] = min + 1;
		}
	}
}
