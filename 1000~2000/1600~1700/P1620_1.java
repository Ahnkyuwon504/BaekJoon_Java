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
	static Map<String, Integer> pokeDexByName;
	static String[] pokeMons;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		pokeDexByName = new HashMap<>();
		pokeMons = new String[N + 1];
		
		pokeDexByName.put(null, 0);
		
		for (int tc = 1; tc <= N; tc++) {
			pokeMons[tc] = br.readLine();
			pokeDexByName.put(pokeMons[tc], tc);
		}
		
		for (int tc = 1; tc <= M; tc++) {
			String que = br.readLine();

			if( que.charAt( 0 ) >= 'A' && que.charAt( 0 ) <= 'Z' ) {
				sb.append(pokeDexByName.get(que)).append("\n");
			} else {
				sb.append(pokeMons[Integer.parseInt(que)]).append("\n");
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
