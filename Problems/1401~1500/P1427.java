package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1427 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String N = br.readLine();
		int[] arr = new int[10];
		
		for (int index = 0; index < N.length(); index++) {
			arr[N.charAt(index) - '0']++;
		}
		
		for (int i = 9; i >= 0; i--) {
			
			while (arr[i] > 0) {
				sb.append(i);
				arr[i]--;
			}
		}
		
		System.out.println(sb);

	}
}
