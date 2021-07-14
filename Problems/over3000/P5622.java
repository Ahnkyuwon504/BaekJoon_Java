package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5622 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String temp = br.readLine();
		int time = 0;
		
		for (int index = 0; index < temp.length(); index++) {
			time += getTime(temp.charAt(index));
		}
		
		System.out.println(time);
	}
	
	static int getTime(char alp) {
		int val = (int)alp;
		
		if (65 <= val && val < 68) {
			return 3;
		} else if (68 <= val && val < 71) {
			return 4;
		} else if (71 <= val && val < 74) {
			return 5;
		} else if (74 <= val && val < 77) {
			return 6;
		} else if (77 <= val && val < 80) {
			return 7;
		} else if (80 <= val && val < 84) {
			return 8;
		} else if (84 <= val && val < 87) {
			return 9;
		} else if (87 <= val && val < 91) {
			return 10;
		} 
		
		return 0;
	}
}
