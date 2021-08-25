package baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2523 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= 2 * N - 1; i++) {
			for (int j = 1; j <= ((i > N)? 2 * N - i : i); j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
