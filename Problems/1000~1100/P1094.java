package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1094 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		int stick = 64;
		
		int cnt = 0;
		
		while (X > 0) {
			
			if (X >= stick) {
				X ^= stick;
				cnt++;
			}
			
			stick /= 2;
		}
		
		System.out.println(cnt);
	}
}
