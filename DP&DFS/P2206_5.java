package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206_5 {
	
	static int N, M;
	static int[][] map;
	static boolean[][][] visit;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	static class Node {
		int y, x, distance, broken;
		int[][] route;
		
		public Node(int y, int x, int distance, int broken, int[][] route) {
			this.y = y;
			this.x = x;
			this.distance = distance;
			this.broken = broken;
			this.route = route;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[2][N][M];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		Node node = bfs();
		System.out.println(node.distance);
		
		for (int i = 0; i < node.route.length; i++) {
			System.out.println(Arrays.toString(node.route[i]));
		}
	}
	
	static Node bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(0, 0, 1, 0, new int[][] {{0, 0}}));
		visit[0][0][0] = true;
		
		while (!q.isEmpty()) {
			Node nowNode = q.poll();
			
			int y = nowNode.y;
			int x = nowNode.x;
			int distance = nowNode.distance;
			int broken = nowNode.broken;
			int[][] nowRoute = nowNode.route;
			
			if (isDestination(y, x)) return nowNode;
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (!isAvail(ny, nx)) continue;
				
				int[][] nRoute = new int[distance + 1][2];
				
				for (int j = 0; j < distance; j++) {
					nRoute[j][0] = nowRoute[j][0];
					nRoute[j][1] = nowRoute[j][1];
				}
				
				nRoute[distance][0] = ny;
				nRoute[distance][1] = nx;
				
				if (broken == 1) {
					if (!visit[broken][ny][nx] && map[ny][nx] == 0) {
						visit[broken][ny][nx] = true;
						q.offer(new Node(ny, nx, distance + 1, broken, nRoute));
					}
				} else if (broken == 0) {
					if (!visit[broken][ny][nx] && map[ny][nx] == 0) {
						visit[broken][ny][nx] = true;
						q.offer(new Node(ny, nx, distance + 1, broken, nRoute));
					} else if (!visit[broken + 1][ny][nx] && map[ny][nx] == 1) {
						visit[broken + 1][ny][nx] = true;
						q.offer(new Node(ny, nx, distance + 1, broken + 1, nRoute));
					}
				}
			}
		}
	
		return new Node(0, 0, -1, 0, new int[][] {{0, 0}});
	}
	
	static boolean isAvail(int y, int x) {
		if ((0 <= y && y < N) && (0 <= x && x < M)) return true;
		return false;
	}
	
	static boolean isDestination(int y , int x) {
		if (y == N - 1 && x == M - 1) return true;
		return false;
	}
}
