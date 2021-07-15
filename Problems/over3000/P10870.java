package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(getFibonacci(N));
		
		
	}
	
	static int getFibonacci(int N) {
		if (N == 0) return 0;
		if (N == 1) return 1;
		
		return getFibonacci(N - 1) + getFibonacci(N - 2);
	}
}
