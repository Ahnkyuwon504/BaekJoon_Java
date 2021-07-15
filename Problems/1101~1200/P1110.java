package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1110 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = N;
		
		int cnt = 0;
		
		
		while (true) {
			
			if (N < 10) {
				N *= 11;
			} else {
				N = (N % 10) * 10 + (((N / 10) + (N % 10)) % 10);
				
			}
			
			cnt++;
			
			if (N == M) break;
			
		}
		System.out.println(cnt);
		
	}
}
