package dpdfs;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class P2206_3 {
	
	static int N, M, ans;
	static int[][] map = new int[1001][1001];
	static int[][] broken = new int[1001][1001];
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	static class Node {
		int y, x, dis, hasBroken;
		public Node(int y, int x, int dis, int hasBroken) {
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
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
				broken[i][j] = Integer.MAX_VALUE;
			}
		}
		ans = Integer.MAX_VALUE;
		bfs();
		if (ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(0, 0, 1, 0));
		broken[0][0] = 0;
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			
			if (node.y == N - 1 && node.x == M - 1) {
				ans = node.dis;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if (!isAvail(ny, nx)) continue;
				if (broken[ny][nx] <= node.hasBroken) continue;
				
				if (map[ny][nx] == 0) {
					broken[ny][nx] = node.hasBroken;
					q.offer(new Node(ny, nx, node.dis + 1, node.hasBroken));
				} else {
					if (node.hasBroken == 0) {
						broken[ny][nx] = node.hasBroken + 1;
						q.offer(new Node(ny, nx, node.dis + 1, node.hasBroken + 1));
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
