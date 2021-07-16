package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2475 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		
		for (int i = 0; i < 5; i++) {
			sum += Math.pow(Integer.parseInt(st.nextToken()), 2);
		}
		
		System.out.println(sum % 10);

		
	}
}
