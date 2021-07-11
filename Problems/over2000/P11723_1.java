package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11723_1 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int bitSet = 0;
		
		for (int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine());
			String ope = st.nextToken();
			
			if (ope.equals("add")) {
				
				int num = Integer.parseInt(st.nextToken());
				bitSet |= (1 << (num - 1));
				
			} else if (ope.equals("remove")) {
				
				int num = Integer.parseInt(st.nextToken());
				bitSet &= ~(1 << (num - 1));
				
			} else if (ope.equals("check")) {
				
				int num = Integer.parseInt(st.nextToken());
				sb.append((bitSet & (1 << (num - 1))) == 0? "0" : "1").append("\n");
				
			} else if (ope.equals("toggle")) {
				
				int num = Integer.parseInt(st.nextToken());
				bitSet ^= (1 << (num - 1));
				
			} else if (ope.equals("all")) {
				
				bitSet |= (~0);
				
			} else if (ope.equals("empty")) {
				
				bitSet &= 0;
				
			}
		}
		
		System.out.println(sb);
	}
}
