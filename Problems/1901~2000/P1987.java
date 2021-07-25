package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1987 {
	
	static int R, C;
	static int[][] map;
	static boolean[] visit = new boolean[26];
	static int result = 0;
	static int[] dy = new int[] {-1, 1, 0, 0};
	static int[] dx = new int[] {0, 0, -1, 1};
	
	static class Node {
		int y;
		int x;
		int ret;
		
		public Node(int y, int x, int ret) {
			this.y = y;
			this.x = x;
			this.ret = ret;
		
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j) - 65;
			}
		}
		
		dfs(0, 0, 0);
		
		System.out.println(result);
	}
	
	static void dfs(int y, int x, int length) {
		visit[map[y][x]] = true;
		result = Math.max(result, length + 1);
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (isAvail(ny, nx) && !visit[map[ny][nx]]) {
				dfs(ny, nx, length + 1);
				visit[map[ny][nx]] = false;
			}
		}
	}
	
	static boolean isAvail(int y, int x) {
		return (0 <= y && y < R) && (0 <= x && x < C);
	}
	
	
	

}
