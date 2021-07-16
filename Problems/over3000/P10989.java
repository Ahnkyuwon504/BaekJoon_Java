package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] result = new int[10001];
		
		for (int i = 0; i < N; i++) {
			result[Integer.parseInt(br.readLine())]++;
		}
		
		for (int i = 1; i <= 10000; i++) {
			for (int j = 0; j < result[i]; j++) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
