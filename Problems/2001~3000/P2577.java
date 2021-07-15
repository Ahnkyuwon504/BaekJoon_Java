package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2577 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int[] result = new int[10];
		
		String temp = Integer.toString(A * B * C);
		int cur;
		
		for (int index = 0; index < temp.length(); index++) {
			cur = temp.charAt(index) - '0'; 
			result[cur]++;
		}
		
		for (int i = 0; i < 10; i++) {
			sb.append(result[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}
