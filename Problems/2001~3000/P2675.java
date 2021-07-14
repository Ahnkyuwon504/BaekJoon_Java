package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2675 {
	
	static int R;
	static String S;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			R = Integer.parseInt(st.nextToken());
			S = st.nextToken();
					
			print();
		}
		
		System.out.println(sb);

	}
	
	static void print() {
		for (int index = 0; index < S.length(); index++) {
			for (int i = 0; i < R; i++) {
				sb.append(S.charAt(index));
			}
			
		}
		sb.append("\n");
	}
}
