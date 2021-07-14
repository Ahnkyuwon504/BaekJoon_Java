package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10809 {
	
	static int[] result = new int[26];
	static String S;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		Arrays.fill(result, -1);
		
		getResult();
		print();
	}
	
	static void getResult() {
		
		for (int index = 0; index < S.length(); index++) {
			int loc = (int)S.charAt(index) - 97;
			if (result[loc] == -1) {
				result[loc] = index;
			}
		}
	}
	
	static void print() {
		
		for (int index = 0; index < 26; index++) {
			sb.append(result[index]).append(" ");
		}
		System.out.println(sb);
	}

}
