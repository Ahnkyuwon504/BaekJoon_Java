package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2908 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String firPre = st.nextToken();
		int firCur = getRev(firPre);
		
		String secPre = st.nextToken();
		int secCur = getRev(secPre);
		
		if (firCur > secCur) {
			System.out.println(firCur);
		} else {
			System.out.println(secCur);
		}
	}
	
	static int getRev(String pre) {
		String cur = "";
		
		for (int i = pre.length() - 1; i >= 0; i--) {
			cur += pre.charAt(i);
		}
		
		return Integer.parseInt(cur);
	}

}
