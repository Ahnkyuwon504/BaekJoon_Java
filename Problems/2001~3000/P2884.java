package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2884 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int hour = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		
		int val = hour * 60 + time;
		
		if (val < 45) {
			val = val + 60 * 24 - 45;
			System.out.printf("%d %d", val / 60, val % 60);
		} else {
			val = val - 45;
			System.out.printf("%d %d", val / 60, val % 60);
		}

	}

}
