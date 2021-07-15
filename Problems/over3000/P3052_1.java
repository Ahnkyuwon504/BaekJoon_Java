package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3052_1 {
	
	static int[] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		result = new int[42];
		int cnt = 0;
		
		for (int i = 0; i < 10; i++) {
			result[Integer.parseInt(br.readLine()) % 42]++;
		}
		
		for (int cur : result) {
			if (cur > 0) cnt++;
		}
		
		System.out.println(cnt);
	}
}
