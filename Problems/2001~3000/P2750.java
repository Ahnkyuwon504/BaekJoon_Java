package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2750 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		boolean[] result = new boolean[2001];
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			result[num + 1000] = true;
		}
		
		for (int i = 0; i < result.length; i++) {
			if (result[i]) sb.append(i - 1000).append("\n");
		}
		
		System.out.println(sb);
	}
}
