package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206_2 {
	
	static int N, M;
	static int ans = Integer.MAX_VALUE;
	static int[] dx = new int[] {0, 0, -1, 1};
	static int[] dy = new int[] {-1, 1, 0, 0};
	static int[][] map = new int[1001][1001];
	static boolean[][][] visited = new boolean[2][1001][1001];
	
	static class Node {
		int y, x, dis, hasBroken;

		public Node(int y, int x, int dis, int hasBroken) {
			super();
			this.y = y;
			this.x = x;
			this.dis = dis;
			this.hasBroken = hasBroken;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(0, 0, 1, 0));
		
		while (!q.isEmpty()) {
			Node nowNode = q.poll();
			if (nowNode.y == N - 1 && nowNode.x == M - 1) return nowNode.dis;
			
			for (int i = 0; i < 4; i++) {
				int ny = nowNode.y + dy[i];
				int nx = nowNode.x + dx[i];
				
				if (!isAvail(ny, nx)) continue;
				
				// hasBroken = 0일 때
				if (nowNode.hasBroken == 0) {
					
					if (map[ny][nx] == 1) {
						if (!visited[1][ny][nx]) {
							visited[1][ny][nx] = true;
							q.offer(new Node(ny, nx, nowNode.dis + 1, 1));
						}
						
					} else {
						if (!visited[0][ny][nx]) {
							visited[0][ny][nx] = true;
							q.offer(new Node(ny, nx, nowNode.dis + 1, 0));
						}
					}
					
					
				// hasBroken = 1일 때
				} else {
					if (map[ny][nx] == 0 && !visited[1][ny][nx]) {
						visited[1][ny][nx] = true;
						q.offer(new Node(ny, nx, nowNode.dis + 1, 1));
					}
				}
			}
		
		}
		
		return -1;
	}
	
	static boolean isAvail(int y, int x) {
		if ((0 <= y && y < N) && (0 <= x && x < M)) return true;
		return false;
	}
}
