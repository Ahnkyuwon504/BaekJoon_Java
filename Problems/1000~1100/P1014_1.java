package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1014_1 {
	
	static int DP[][];
	static boolean obstacles[][];
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			DP = new int[1 << N][M];
			obstacles = new boolean[N][M];
			
			for (int n = 0; n < (1 << N); n++) {
				Arrays.fill(DP[n], -1);
			}
			
			for (int n = 0; n < N; n++) {
				String input = br.readLine();
				for (int m = 0; m < M; m++) {
					if (input.substring(m, m + 1).equals("x")) obstacles[n][m] = true;
				}
			}
			System.out.println((1 << 0));
			System.out.println((1 << 1));
			bw.write(Integer.toString(getDP(0, 0)) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	// DP(n, m) = (m - 1) 번째 줄에서 n 상태로 사람이 앉았을 때 
	// m 번째 줄에서 나올 수 있는 가장 많은 학생의 수
	
	static int getDP(int n, int m) { // 저번 풀에서 사용한 것, m = 현재 풀
		
		if (m == M) {
			return 0; // 모든 풀 체크한 경우
		}
		
		if (DP[n][m] != -1) {
			return DP[n][m]; 
		}
		
		int lastN = n; // 현재 턴에서 사용 불가능한 자리 표시 위한 변수
		
		for (int i = 0; i < N; i++) {
			// 1 << i 는 
			// 1<<0 : 1
			if ((n & (1 << i)) > 0) {
				lastN |= (1 << (i + 1)); // 사용불가능
				lastN |= (1 << (i - 1)); // 사용불가능
			}
		}
		
		int result = getDP(0, m + 1); // 아무 학생도 앉히지 않고 다음 풀로 넘어가는경우
		
		for (int i = 1; i < (1 << N); i++) { // 학생을 앉히는 경우
			
			if ((i & lastN) > 0) continue; // 나올 수 없는 경우의 수
			
			int count = 0; // 학생 수(비트 연산)
			
			boolean isAvail = true;
			
			for (int j = 0; j < N && isAvail; j++) {
				System.out.println(isAvail);
				
				if ((i & (1 << j)) > 0) { // 이 자리 학생이 있으면
					
					count++;
					
					if (obstacles[j][m]) isAvail = false;
					// 이 자리 장애물 있으면 나올 수 없는 경우
				}
			}
			
			if (!isAvail) continue; // 장애물 체크
			
			result = Math.max(result, getDP(i, m + 1) + count); // 가능한 경우 재귀적 전달
			
		}
		return DP[n][m] = result;
	}
}




















