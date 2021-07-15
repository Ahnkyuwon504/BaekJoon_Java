package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3052 {
	
	static int[] result;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		result = new int[10];
		visit = new boolean[1001];
		
		for (int i = 0; i < 10; i++) {
			result[i] = Integer.parseInt(br.readLine()) % 42;
		}
		
		int cnt = 0;
		
		for (int cur : result) {
			if (!visit[cur]) cnt++;
			visit[cur] = true;
		}
		
		System.out.println(cnt);
				 
		
		
	}
}
