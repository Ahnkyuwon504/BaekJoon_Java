package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1009 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int a, b; 
		int oneLineAnswer = 1;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken()); // 밑
			b = Integer.parseInt(st.nextToken()); // 지수
			oneLineAnswer = 1; // 각 테스트 케이스에 대해 초기화
			
			for (int i = 0; i < b; i++) {
				oneLineAnswer = oneLineAnswer * a; // b의 값만큼 a 곱
				oneLineAnswer = oneLineAnswer % 10; // 필요한 건 1의자릿수
			}
			
			sb.append(oneLineAnswer).append("\n");
		}
		
		System.out.println(sb);
	}
}
