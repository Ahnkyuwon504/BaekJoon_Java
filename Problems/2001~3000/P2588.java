package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1000 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		
		int three = A * (B % 10);
		int four = A * ((B % 100) / 10);
		int five = A * (B / 100);
		int six = A * B;
		
		System.out.println(three);
		System.out.println(four);
		System.out.println(five);
		System.out.println(six);
	}

}
