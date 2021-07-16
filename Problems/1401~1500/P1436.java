package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1436 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int num = 666;
		
		while (true) {
			if (Integer.toString(num).contains("666")) cnt++;
			
			if (cnt == N) break;
			
			num++;
		}
		
		System.out.println(num);
	}
}
