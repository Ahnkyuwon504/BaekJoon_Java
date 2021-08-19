package baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P19944 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if (M == 1 || M == 2) {
			System.out.println("NEWBIE!");
		} else if (2 < M && M <= N) {
			System.out.println("OLDBIE!");
		} else {
			System.out.println("TLE!");
		}
				

	}

}
