package baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16173 {
	
	static int N;
	
	static int[][] map;
	static boolean[][] visit;
	
	static int[] dy = new int[] {1, 0};
	static int[] dx = new int[] {0, 1};
	
	static class Node {
		int y;
		int x;
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0, 0);
		
		System.out.println((visit[N - 1][N - 1])? "HaruHaru" : "Hing");
	}
	
	public static void bfs(int y, int x) {
		Queue<Node> q = new LinkedList<Node>();
		
		q.offer(new Node(y, x));
		visit[y][x] = true;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			int curY = cur.y;
			int curX = cur.x;
			
			for (int i = 0; i < 2; i++) {
				int nextY = curY + dy[i] * map[curY][curX];
				int nextX = curX + dx[i] * map[curY][curX];
				
				if (isAvail(nextY, nextX) && map[nextY][nextX] != 0 && !visit[nextY][nextX]) {
					q.offer(new Node(nextY, nextX));
					visit[nextY][nextX] = true;
				}
			}
		}
	}
	
	public static boolean isAvail(int y, int x) {
		return ((0 <= y && y < N) && (0 <= x && x < N));
	}
}
