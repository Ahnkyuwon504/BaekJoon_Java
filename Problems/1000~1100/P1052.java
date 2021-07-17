package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1052 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println(getBottle(N, K));
	}
	
	static int getBottle(int N, int K) {
		// 물병을 아무리 많이 사도 1<<(max - 1) 보단 안 삼
		int max = 0;
		
		for (int i = 1; i <= 1000; i++) {
			if (N <= (1 << (i - 1))) {
				max = i;
				break;
			}
		}
		
		int result = Integer.MAX_VALUE;
		
		for (int i = N; i <= (1 << max - 1); i++) {
			if (getNumOfOne(i) <= K) {
				result = Math.min(result, i - N);
			}
			
		}

		return result;
	}
	
	static int getNumOfOne(int num) {
		int sum = 0;
		
		for (int i = 0; i < 1000; i++) {
			
			int cur = (1 << i);
			
			if ((num & cur) != 0) {
				num &= ~(1<<i);
				sum++;
				
			}
			
			if (num == 0) break;
			
			
		}
		
		return sum;
	}
}
