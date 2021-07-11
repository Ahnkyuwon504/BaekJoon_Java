package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9095 {
	
	static int[] dp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			dp = new int[n + 1];
			
			sb.append(dp(n)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int dp(int N) {
		if (dp[N] != 0) return dp[N];
		
		if (N == 1) return dp[1] = 1;
		if (N == 2) return dp[2] = 2;
		if (N == 3) return dp[3] = 4;
		
		
		return dp(N - 1) + dp(N - 2) + dp(N - 3);
	}
}
