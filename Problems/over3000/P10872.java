package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10872 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(getFactorial(N));
		
		
	}
	
	static int getFactorial(int N) {
		if (N == 0) return 1;
		
		return N * getFactorial(N - 1);
	}
}
