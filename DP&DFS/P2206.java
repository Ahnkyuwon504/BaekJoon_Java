package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class P2206 {
	
	static class Place {
		int y;
		int x;
		int dis;
		int drill;
		public Place(int y, int x, int dis, int drill) {
			super();
			this.y = y;
			this.x = x;
			this.dis = dis;
			this.drill = drill;
		}
	}
	
	static int N;
	static int M;
	static int ans
	;
	static int[][] map = new int[1001][1001];
	static int[][] visit = new int[1001][1001];
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		
		ans = Integer.MAX_VALUE;
		bfs();
		
		if (ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	
	static void bfs() {
		Queue<Place> q = new LinkedList<Place>();
		
		q.offer(new Place(0, 0, 1, 0));
		visit[0][0] = 0;
		
		while (!q.isEmpty()) {
			Place nowPlace = q.poll();
			
			if (nowPlace.y == N - 1 && nowPlace.x == M - 1) {
				ans = nowPlace.dis;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = nowPlace.y + dy[i];
				int nx = nowPlace.x + dx[i];
				
				if (!isAvail(ny, nx)) continue;
				if (visit[ny][nx] <= nowPlace.drill) continue;
				
				if (map[ny][nx] == 0) {
					visit[ny][nx] = nowPlace.drill;
					q.add(new Place(ny, nx, nowPlace.dis + 1, nowPlace.drill));
				} else {
					if (nowPlace.drill == 0) {
						visit[ny][nx] = nowPlace.drill + 1;
						q.add(new Place(ny, nx, nowPlace.dis + 1, nowPlace.drill + 1));
					}
				}
			}
		}
	}
	 
	static boolean isAvail(int y, int x) {
		if ((0 <= y && y < N) && (0 <= x && x < M)) return true;
		return false;
	}
}
