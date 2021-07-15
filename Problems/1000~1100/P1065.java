package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1065 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for (int i = 1; i <= N; i++) {
			if (i < 100) {
				cnt++;
				continue;
			}
			
			int pre = i / 100;
			int next = i % 10;
			int mid = (i % 100) / 10;
			
			if ((pre + next) == 2 * mid) cnt++;
			
		}
		
		System.out.println(cnt);
	}
}
