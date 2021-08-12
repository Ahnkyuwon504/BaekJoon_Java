package baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5522 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = 0;
		
		for (int i = 0; i < 5; i++) {
			a += Integer.parseInt(br.readLine());
		}
		
		System.out.println(a);

	}

}
