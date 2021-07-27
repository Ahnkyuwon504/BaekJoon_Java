package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// -는 0, row
// |는 1, column

public class P1388 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	
	static int[] dy = new int[] {-1, 1, 0, 0};
	static int[] dx = new int[] {0, 0, -1, 1};
	
	static int ret = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = (input.charAt(j) == '-')? 0 : 1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j= 0; j < M; j++) {
				if (!visit[i][j]) {
					dfs(i, j, map[i][j]);
					ret++;
				}
			}
		}
		
		System.out.println(ret);
	}
	
	static void dfs(int y, int x, int type) {
		visit[y][x] = true;
		
		if (type == 0) {
			for (int i = 2; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (isAvail(ny, nx) && !visit[ny][nx] && map[ny][nx] == type) dfs(ny, nx, type);
			}
		} else if (type == 1) {
			for (int i = 0; i < 2; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (isAvail(ny, nx) && !visit[ny][nx] && map[ny][nx] == type) dfs(ny, nx, type);
			}
		}
	}
	
	static boolean isAvail(int y, int x) {
		return (0 <= y && y < N) && (0 <= x && x < M);
	}

}
