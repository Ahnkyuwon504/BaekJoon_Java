package baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10797 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int a = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 5; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num == a) cnt++;
		}

		System.out.println(cnt);
	}

}
