package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11720 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int sum = 0;
		
		for (int index = 0; index < N; index++) {
			sum += str.charAt(index) - '0';
		}
		
		System.out.println(sum);
	}

}
