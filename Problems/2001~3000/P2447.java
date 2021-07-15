package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2447 {
	
	static int N;
	static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N][N];
		
		print(0, 0, N);
		
		for (int i = 0; i < visit.length; i++) {
			for (int j = 0; j < visit[i].length; j++) {
				if (visit[i][j]) {
					sb.append(" ");
				} else {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

		
	}
	
	static void print(int y, int x, int N) {
		int pre = N / 3;
		int cur = pre * 2;
		
		for (int i = y + pre; i < y + cur; i++) {
			for (int j = x + pre; j < x + cur; j++) {
				visit[i][j] = true;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (N == 3) break;
				
				print(y + (N / 3) * i, x + (N / 3) * j, N / 3);

			}
		}
	}
}
