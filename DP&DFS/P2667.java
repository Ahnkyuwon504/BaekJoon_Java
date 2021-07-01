package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2667 {
	
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int numberOfHome;
	static int[] answer = new int[25*25];
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String oneLine = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(oneLine.substring(j, j+1));
			}
		}
		
		int numberOfDanGi = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j] && map[i][j] == 1) {
					numberOfDanGi++;
					numberOfHome = 0;
					dfs(i, j);
					answer[numberOfDanGi] = numberOfHome;
				}
			}
		}
		Arrays.sort(answer);
		
		System.out.println(numberOfDanGi);
		for (int i = 0; i < answer.length; i++) {
			if (answer[i] != 0) System.out.println(answer[i]);
		}
		
	}
	
	static void dfs(int y, int x) {
		numberOfHome++;
		visit[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dx[i];
			int nx = x + dy[i];
			
			if (isInside(ny, nx) && !visit[ny][nx] && map[ny][nx] == 1) {
				dfs(ny, nx);
			}
		}
		
	}
	
	static boolean isInside(int y, int x) {
		if ((0 <= y && y < N) && (0 <= x && x < N)) return true;
		return false;
	}
}
