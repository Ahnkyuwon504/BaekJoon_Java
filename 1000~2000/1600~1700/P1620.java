package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P1620 {
	
	static int N;
	static int M;
	static StringBuilder sb;
	static Map<Integer, String> pokeDexByNum = new HashMap<>();
	static Map<String, Integer> pokeDexByName = new HashMap<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		pokeDexByNum.put(0, null);
		pokeDexByName.put(null, 0);
		
		for (int tc = 1; tc <= N; tc++) {
			String pokeName = br.readLine();
			pokeDexByNum.put(tc, pokeName);
			pokeDexByName.put(pokeName, tc);
			
		}
		
		for (int tc = 1; tc <= M; tc++) {
			String str = br.readLine();
			if (isNumeric(str)) {
				sb.append(pokeDexByNum.get(Integer.parseInt(str))).append("\n");
			} else {
				sb.append(pokeDexByName.get(str)).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static boolean isNumeric(String str) {
		try {
			@SuppressWarnings("unused")
			int num = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
}
