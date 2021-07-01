package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7569 {
	
	static int N;
	static int M;
	static int H;
	
	static int[][][] tomatoBox = new int[100][100][100];
	static ArrayList<int[]> startRipped = new ArrayList<int[]>();
	
	static int[] dx = {0, 0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, 0, 1, -1};
	static int[] dz = {1, -1, 0, 0, 0, 0};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken()); H = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					tomatoBox[j][k][i] = Integer.parseInt(st.nextToken());
					if (tomatoBox[j][k][i] == 1) {
						startRipped.add(new int[] {j, k, i});
					}
				}
			}
		}
		int result = 0; 
		boolean isAble = true;
		
		dfs();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					
					if (tomatoBox[j][k][i] == 0) isAble = false;
					result = Math.max(result, tomatoBox[j][k][i]);
				}
			}
		}
		
		if (!isAble) {
			System.out.println(-1);
		} else {
			System.out.println(result - 1);
		}
	}
	
	static void dfs() {
		
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < startRipped.size(); i++) {
			q.offer(startRipped.get(i));
		}
		
		while (!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			int z = q.peek()[2];
			q.poll();
			
			for (int i = 0; i < 6; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				int nz = z + dz[i];
				
				if (isInside(ny, nx, nz) && tomatoBox[ny][nx][nz] == 0) {
					tomatoBox[ny][nx][nz] = tomatoBox[y][x][z] + 1;
					q.offer(new int[] {ny, nx, nz});
				}
			}
		}
	}
	
	static boolean isInside(int y, int x, int z) {
		if ((0 <= y && y < N) && (0 <= x && x < M) && (0 <= z && z < H)) return true;
		return false;
	}
}
