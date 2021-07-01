package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class Location {
	int y;
	int x;
	
	public Location(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}

public class P2667_bfs_class {
	
	static int N;
	static int[][] map = new int[25][25];
	static boolean[][] visit = new boolean[25][25];
	static int[] homeOfApart = new int[25 * 25];
	static int numOfHome;
	static int numOfApart = 0;
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					numOfApart++;
					bfs(i, j);
				}
			}
		}
		
		Arrays.sort(homeOfApart);
		System.out.println(numOfApart);
		for (int i = 0; i < homeOfApart.length; i++) {
			if (homeOfApart[i] != 0) System.out.println(homeOfApart[i]);
		}
	}
	
	static void bfs(int y, int x) {
		
		Queue<Location> q = new LinkedList<Location>();
		q.offer(new Location(y, x));
		visit[y][x] = true;
		homeOfApart[numOfApart]++;
		
		while (!q.isEmpty()) {
			int nowX = q.peek().x;
			int nowY = q.peek().y;
			q.poll();
					
			for (int i = 0; i < 4; i++) {
				int ny = nowY + dy[i];
				int nx = nowX + dx[i];
				
				if (isInside(ny, nx) && !visit[ny][nx] && map[ny][nx] == 1) {
					q.offer(new Location(ny, nx));
					visit[ny][nx] = true;
					homeOfApart[numOfApart]++;
				}
			}
		}
	}
	
	static boolean isInside(int y, int x) {
		if ((0 <= y && y < N) && (0 <= x && x <= N)) return true;
		return false;
	}
}