package minjaeIsMyGodHamster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10039 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int score = 0;
		
		for (int i = 0; i < 5; i++) {
			int num = Integer.parseInt(br.readLine());
			
			score += (num < 40)? 40 : num;
		}
		
		System.out.println(score / 5);
	}
}
