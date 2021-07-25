package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10026 {
	
	static int N;
	
	static int[][] map1;
	static int[][] map2;
	
	static int ret1 = 0;
	static int ret2 = 0;
	
	static int[] dy = new int[] {-1, 1, 0, 0};
	static int[] dx = new int[] {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map1 = new int[N][N];
		map2 = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				char color = input.charAt(j);
				
				if (color == 'R') {
					map1[i][j] = 1;
					map2[i][j] = 1;
				} else if (color == 'G') {
					map1[i][j] = 2;
					map2[i][j] = 1;
				} else if (color == 'B') {
					map1[i][j] = 3;
					map2[i][j] = 3;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int color1 = map1[i][j];
				int color2 = map2[i][j];
				
				if (color1 != 0) {
					color1(i, j, color1);
					ret1++;
				}
				
				if (color2 != 0) {
					color2(i, j, color2);
					ret2++;
				}
			}
		}
		
		System.out.println(ret1 + " " + ret2);
	}
	
	static void color1(int y, int x, int color) {
		map1[y][x] = 0;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (isAvail(ny, nx) && map1[ny][nx] == color) color1(ny, nx, color);
		}
	}
	
	static void color2(int y, int x, int color) {
		map2[y][x] = 0;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (isAvail(ny, nx) && map2[ny][nx] == color) color2(ny, nx, color);
		}
	}
	
	static boolean isAvail(int y, int x) {
		return (0 <= y && y < N) && (0 <= x && x < N);
	}

}
