package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10951 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int A = Integer.MAX_VALUE;
		int B = Integer.MAX_VALUE;
		String line;
		
		while ( (line = br.readLine()) != null ) {
			
			st = new StringTokenizer(line);
					
			A = Integer.parseInt(st.nextToken()); 
			B = Integer.parseInt(st.nextToken());
			
			sb.append(A + B).append("\n");
		}
		
		System.out.println(sb);
	}
}
