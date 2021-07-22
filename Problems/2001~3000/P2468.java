package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2468 {

	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int maxHeight = Integer.MIN_VALUE;
	static int safe = Integer.MIN_VALUE;

	static int[] dy = new int[] { -1, 1, 0, 0 };
	static int[] dx = new int[] { 0, 0, -1, 1 };

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visit = new boolean[N][N];
		int height;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				height = Integer.parseInt(st.nextToken());
				map[i][j] = height;
				maxHeight = Math.max(maxHeight, height);

			}
		}
		

		for (int rain = 0; rain < maxHeight; rain++) {
			if (rain > 0) {
				updateMap();
			}

			initVisit();
			int cur = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > 0 && !visit[i][j]) {
						bfs(new Node(i, j));
						cur++;
					}
				}
			}
			safe = Math.max(safe, cur);

		}

		System.out.println(safe);

	}

	static void bfs(Node node) {
		int y = node.y;
		int x = node.x;

		Queue<Node> q = new LinkedList<Node>();
		q.offer(node);
		visit[y][x] = true;

		while (!q.isEmpty()) {
			Node n = q.poll();

			int ny = n.y;
			int nx = n.x;

			for (int i = 0; i < 4; i++) {
				int newy = ny + dy[i];
				int newx = nx + dx[i];

				if (isInside(newy, newx) && map[newy][newx] > 0 && !visit[newy][newx]) {
					q.offer(new Node(newy, newx));
					visit[newy][newx] = true;
				}
			}
		}
	}

	static void updateMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]--;
			}
		}
	}

	static boolean isInside(int y, int x) {
		return ((0 <= y && y < N) && (0 <= x && x < N));
	}

	static void initVisit() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(visit[i], false);
		}
	}

}
