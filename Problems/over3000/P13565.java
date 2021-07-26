package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13565 {
	
	static int M, N;
	static int[][] map;
	static boolean[][] visit;
	
	static int[] dy = new int[] {-1, 1, 0, 0};
	static int[] dx = new int[] {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visit = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (map[0][i] == 0 && !visit[0][i]) dfs(0, i);
		}
		
		boolean elec = false;
		
		for (int i = 0; i < N; i++) {
			if (visit[M - 1][i]) elec = true;
		}
		
		if (elec) System.out.println("YES");
		else System.out.println("NO");
		

	}
	
	static void dfs(int y, int x) {
		visit[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (isAvail(ny, nx) && map[ny][nx] == 0 && !visit[ny][nx]) dfs(ny, nx);
		}
	}
	
	static boolean isAvail(int y, int x) {
		return (0 <= y && y < M) && (0 <= x && x < N);
	}

}
