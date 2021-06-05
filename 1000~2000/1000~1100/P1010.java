package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1010 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N, M;
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			sb.append(getBridgeNumber(N, M)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int getBridgeNumber(int N, int M) {
		
		if (N == M) {
			return 1;
		} else if (N == 1) {
			return M;
		} else {
		
			int BridgeNumber = 0;
		
			for (int i = N-1; i <= M-1; i++) {
				BridgeNumber += getBridgeNumber(N-1, i);
			}
		
			return BridgeNumber;
		}
	}
}
