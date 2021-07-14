package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1152 {
	
	static String S;
	static int cnt = 1;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp = br.readLine();
		
		if (isBlank(temp)) {
			System.out.println(0);
		} else {
			S = temp.trim();
			cnt = 1;
			
			
			for (int index = 0; index < S.length(); index++) {
				
				if (S.charAt(index) == ' ') {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
	
	static boolean isBlank(String temp) {
		return (temp.charAt(0) == ' ' && temp.length() == 1);
	}

}
