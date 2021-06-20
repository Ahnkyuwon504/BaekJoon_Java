package baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1019 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numberArr = new int[10];

		for (int i = 1; i <= N; i++) {
			String oneNum = Integer.toString(i);
			
			for (int j = 0; j < oneNum.length(); j++) {
				char charOfoneNum = oneNum.charAt(j);
				
				switch (charOfoneNum) {
				case '0' : numberArr[0]++; break;
				case '1' : numberArr[1]++; break;
				case '2' : numberArr[2]++; break;
				case '3' : numberArr[3]++; break;
				case '4' : numberArr[4]++; break;
				case '5' : numberArr[5]++; break;
				case '6' : numberArr[6]++; break;
				case '7' : numberArr[7]++; break;
				case '8' : numberArr[8]++; break;
				case '9' : numberArr[9]++; break;
				
				}
			}
		}
		
		for (int result : numberArr) {
			System.out.printf(result + " ");
		}
	}
}
