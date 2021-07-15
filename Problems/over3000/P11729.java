package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11729 {
	
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Hanoi(N, 1, 2, 3);
		System.out.println(cnt);
		System.out.println(sb);

	}
	
	static void Hanoi(int N, int start, int mid, int to) {
		if (N == 1) {
			sb.append(start).append(" ").append(to).append("\n");
			cnt++;
			return;
		}
		
		Hanoi(N - 1, start, to, mid);
		Hanoi(1, start, mid, to);
		Hanoi(N - 1, mid, start, to);

		
	}

}
