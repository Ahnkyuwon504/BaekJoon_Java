package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1697 {
	
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
		
		q.offer(N);
		
		while (!q.isEmpty()) {
			
			if (time[K] != 0) {
				System.out.println(time[K]);
				break;
			}
			
			int now = q.poll();
			
			if (isAvail(now + 1) && time[now + 1] == 0) {
				time[now + 1] = time[now] + 1;
				q.offer(now + 1);
			}
			if (isAvail(now - 1) && time[now - 1] == 0) {
				time[now - 1] = time[now] + 1;
				q.offer(now - 1);
			}
			if (isAvail(now * 2) && time[now * 2] == 0) {
				time[now * 2] = time[now] + 1;
				q.offer(now * 2);
			}
		}
	}
	
	static boolean isAvail(int now) {
		if (0 <= now && now <= 100000) return true;
		return false;
	}

}
