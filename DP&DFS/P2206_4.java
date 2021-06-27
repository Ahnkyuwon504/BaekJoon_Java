package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206_4 {
	
	static int N, M;
	static int[][] map = new int[1001][1001];
	static boolean[][][] visit = new boolean[2][1001][1001];
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	static class Node {
		int y, x, dis, hasBroken;
		int[][] route = new int[100][2];
		
		public Node(int y, int x, int dis, int hasBroken, int[][] route) {
			super();
			this.y = y;
			this.x = x;
			this.dis = dis;
			this.hasBroken = hasBroken;
			this.route = route;
		}
	}

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
			}
		}
		
		Node node = bfs();
		System.out.println(node.dis);
		
		for (int i = 0; i < node.route.length; i++) {
			System.out.println(Arrays.toString(node.route[i]));
		}
	}
	
	static Node bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(0, 0, 1, 0, new int[][] {{0, 0}}));
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			
			int y = node.y;
			int x = node.x;
			int dis = node.dis;
			int hasBroken = node.hasBroken;
			int[][] route = node.route;
			
			if (y == N - 1 && x == M - 1) {
				return node;
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				int[][] newRoute = new int[dis + 1][2];
				
				for (int j = 0; j < dis; j++) {
					newRoute[j][0] = route[j][0];
					newRoute[j][1] = route[j][1];
				}
				newRoute[dis][0] = ny;
				newRoute[dis][1] = nx;
				
				if (!isAvail(ny, nx)) continue;
				
				if (hasBroken == 1) {
					if (!visit[hasBroken][ny][nx] && map[ny][nx] == 0) {
						visit[hasBroken][ny][nx] = true;
						q.offer(new Node(ny, nx, dis + 1, hasBroken, newRoute));
					}
				} else {
					if (map[ny][nx] == 1) {
						if (!visit[hasBroken + 1][ny][nx]) {
							visit[hasBroken + 1][ny][nx] = true;
							q.offer(new Node(ny, nx, dis + 1, hasBroken + 1, newRoute));
						}
					} else {
						if (!visit[hasBroken][ny][nx]) {
							visit[hasBroken][ny][nx] = true;
							q.offer(new Node(ny, nx, dis + 1, hasBroken, newRoute));
						}
					}
				}
			}
		}
		return null;
	}
	
	static boolean isAvail(int y, int x) {
		if ((0 <= y && y < N) && (0 <= x && x < M)) return true;
		return false;
	}

}
