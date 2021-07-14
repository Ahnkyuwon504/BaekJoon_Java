package baekjoon;

import java.io.IOException;

public class P1152_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int pre = ' ';
		int cur = 0;
		int ans = 0;
		
		while ((cur = System.in.read()) >= 32) {
			if (pre == 32 && cur != 32) ans++;
			pre = cur;
		}
		System.out.println(ans);
	}
}
