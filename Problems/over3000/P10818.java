package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10818 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int cur = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int tc = 0; tc < N; tc++) {
			cur = Integer.parseInt(st.nextToken());
			
			if (cur > max) max = cur;
			if (cur < min) min = cur;
		}
		
		sb.append(min).append(" ").append(max);
		System.out.println(sb);
	}
}
