package prj_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1003 {
	static int numberOf0 = 0;
	static int numberOf1 = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int target = Integer.parseInt(br.readLine());
			
			numberOf0 = 0;
			numberOf1 = 0;
			
			getFibonacci(target);
			
			sb.append(numberOf0 + " " + numberOf1).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int getFibonacci(int n) {
		if (n == 0) {
			numberOf0++;
			return 0;
		} else if (n == 1) {
			numberOf1++;
			return 1;
		} else {
			return getFibonacci(n-1) + getFibonacci(n-2);
		}
	}

}
