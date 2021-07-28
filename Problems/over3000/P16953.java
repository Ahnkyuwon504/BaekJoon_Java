package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16953 {
	
	static long A, B;
	static int ret = -1;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		bfs(A, 0);
		
		System.out.println(ret);
	}
	
	static void bfs(long num, int cnt) {
		if (num > B || num > 1000_000_000) return;
		if (num == B) {
			ret = cnt + 1;
			return;
		}
		
		bfs(num * 2, cnt + 1);
		bfs(num * 10 + 1, cnt + 1);
	}
}
