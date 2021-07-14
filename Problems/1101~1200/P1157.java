package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1157 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine().toUpperCase();
		int[] result = new int[26];
		
		
		for (int index = 0; index < str.length(); index++) {
			int now = (int)str.charAt(index) - 65;
			
			result[now]++;
		}
		
		int max = Integer.MIN_VALUE;
		int answer = 0;
		
		for (int i = 0; i < 26; i++) {
			if (result[i] > max) {
				max = result[i];
				answer = i;
			}
		}
		
		boolean isMany = false;
		
		for (int i = 0; i < 26; i++) {
			if (i != answer && result[i] == max) {
				isMany = true;
			}
		}
		
		if (isMany) {
			System.out.println("?");
		} else {
			System.out.println((char)(answer + 65));
		}
	}

}
