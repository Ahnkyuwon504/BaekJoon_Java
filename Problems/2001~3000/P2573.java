package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2573 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	
	static int[] dy = new int[] {-1, 1, 0, 0};
	static int[] dx = new int[] {0, 0, -1, 1};

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
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ret = Integer.MAX_VALUE;
		
		for (int i = 0; i <= 10; i++) {
			
			for (int index = 0; index < N; index++) {
				Arrays.fill(visit[index], false);
				
			}
			if (i > 0) melt();
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[j][k] != 0) {
						dfs(j, k);
						
						if (isSeperated()) ret = Math.min(ret, i); 
					}
				}
			}
		}
		
		if (ret == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(ret);
		}
	}
	
	static boolean isSeperated() {
		boolean ret = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visit[i][j]) ret = true;
			}
		}
		return ret;
	}
	
	static void dfs(int y, int x) {
		visit[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (isAvail(ny, nx) && map[ny][nx] != 0 && !visit[ny][nx]) dfs(ny, nx);
		}
	}
	
	static void melt() {
		int[][] mapAfterMelt = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if (map[i][j] != 0) {
					
					int adj = 0;
					
					for (int k = 0; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						
						if (map[ny][nx] == 0) {
							adj++;
						}
					}
					
					int after = map[i][j] - adj;
					
					mapAfterMelt[i][j] = (after < 0)? 0 : after; 

					
				}
			}
		}
		
		map = mapAfterMelt;
	}
	
	static boolean isAvail(int y, int x) {
		return (0 <= y && y < N) && (0 <= x && x < M);
	}

}
