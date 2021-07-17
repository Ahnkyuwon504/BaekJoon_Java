package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11723_2 {
	
	static int bit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		
		int bit = 0;
		char ope = ' ';
		int x = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			ope = st.nextToken().charAt(1);
			
			if (ope == 'd') {
				
				x = Integer.parseInt(st.nextToken());
				bit |= (1 << x);
				
				
			} else if (ope == 'e') {
				
				x = Integer.parseInt(st.nextToken());
				bit &= ~(1 << x);
				
			} else if (ope == 'h') {
				
				x = Integer.parseInt(st.nextToken());
				
				sb.append(((bit & (1 << x)) == 0)? 0 : 1).append("\n");

			} else if (ope == 'o') {
				
				x = Integer.parseInt(st.nextToken());
				bit ^= (1 << x);
				
			} else if (ope == 'l') {
				
				bit |= (~0);
				
			} else if (ope == 'm') {
				
				bit = 0;
				
			}
		}
		System.out.println(sb);
	}
}
