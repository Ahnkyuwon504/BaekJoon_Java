package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P2562 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = Integer.MIN_VALUE;
		int cur = 0;
		
		for (int i = 1; i <= 9; i++) {
			cur = Integer.parseInt(br.readLine());
			map.put(cur, i);
			
			if (cur > max) max = cur;
		}
		
		sb.append(max).append("\n").append(map.get(max));
		System.out.println(sb);
		
	}
}
