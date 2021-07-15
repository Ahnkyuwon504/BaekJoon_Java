package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P8958 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			sb.append(getScore(br.readLine())).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int getScore(String line) {
		int score = 0;
		int now = 0;
		
		for (char ch : line.toCharArray()) {
			if (ch == 'O') {
				now++;
			} else if (ch == 'X') {
				now = 0;
			}
			score += now;
		}
		return score;
	}
}
