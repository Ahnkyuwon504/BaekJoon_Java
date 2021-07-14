package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1316 {
	
	static boolean[] visit = new boolean[26];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for (int tc = 0; tc < T; tc++) {
			Arrays.fill(visit, false);
			if (isGroup(br.readLine())) cnt++;
		}
		
		System.out.println(cnt);
	}
	
	static boolean isGroup(String line) {
		boolean isGroup = true;
		
		int pre = (int)' ';
		int cur = 0;
		
		
		for (int index = 0; index < line.length(); index++) {
			cur = line.charAt(index);
			
			if (pre != cur && visit[cur - 97]) isGroup = false;
			
			visit[cur - 97] = true;
			pre = cur;
			
		}
		return isGroup;
	}

}
