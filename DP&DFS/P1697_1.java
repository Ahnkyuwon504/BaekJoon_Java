package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1697_1 {
	
	static int N;
	static int K;
	static int[] time = new int[100001];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if (N == K) {
			System.out.println(0);
		} else {
			bfs();
		}
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		time[N] = 0;
		q.offer(N);
		
		while (!q.isEmpty()) {
			int now = q.poll();
			int next;
			
			for (int i = 0; i < 3; i++) {
				
				if (i == 0) {
					next = now + 1;
				} else if (i == 1) {
					next = now - 1;
				} else {
					next = now * 2;
				}
				
				if (isAvail(next) && time[next] == 0) {
					time[next] = time[now] + 1;
					q.offer(next);
				}
				
				if (next == K) {
					System.out.println(time[K]);
					return;
				}
			}
		}
	}
	
	static boolean isAvail(int now) {
		if (0 <= now && now <= 100000) return true;
		return false;
	}
}
