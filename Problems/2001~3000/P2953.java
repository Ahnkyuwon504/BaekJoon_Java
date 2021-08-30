package baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2953 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int won = 0;
		int score = Integer.MIN_VALUE;
		int cur = 0;
		
		for (int i = 1; i <= 5; i++) {
			st = new StringTokenizer(br.readLine());
			
			cur = 0;
			
			for (int j = 0; j < 4; j++) {
				cur += Integer.parseInt(st.nextToken());
			}
			
			if (score < cur) {
				score = cur;
				won = i;
			}
			
		}
		
		System.out.println(won + " " + score);
				

	}
}
