package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P1764 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> noListen2 = new HashSet<>();
		ArrayList<String> answer = new ArrayList<>();
		
		for (int tc = 0; tc < N; tc++) {
			noListen2.add(br.readLine());
		}
		
		for (int tc = 0; tc < M; tc++) {
			String noSee = br.readLine();
			
			if (noListen2.contains(noSee)) {
				answer.add(noSee);
			}
		}
		
		Collections.sort(answer);
		
		sb.append(answer.size()).append("\n");
		
		
		for (int i = 0; i < answer.size(); i++) {
			sb.append(answer.get(i)).append("\n");
		}
		
		System.out.println(sb);
	}

}
