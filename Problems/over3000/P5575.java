package baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5575 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = 0;
			int end = 0;
			
			start += 3600 * Integer.parseInt(st.nextToken());
			start += 60 * Integer.parseInt(st.nextToken());
			start += 1 * Integer.parseInt(st.nextToken());
			
			end += 3600 * Integer.parseInt(st.nextToken());
			end += 60 * Integer.parseInt(st.nextToken());
			end += 1 * Integer.parseInt(st.nextToken());
			
			int work = end - start;
			
			sb.append(work / 3600).append(" ");
			sb.append((work % 3600) / 60).append(" ");
			sb.append(work % 3600 % 60);

			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
