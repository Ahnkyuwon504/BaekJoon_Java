package dpdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
	
	static int N, M;
	static int[][] tomatoBox = new int[1000][1000];
	static ArrayList<int[]> nowRipped = new ArrayList<int[]>();
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomatoBox[i][j] = Integer.parseInt(st.nextToken());
				if (tomatoBox[i][j] == 1) nowRipped.add(new int[]{i, j});
			}
		}
		
		int result = 0;
		boolean able = true;
		
		bfs();
		
		// 안 익은 토마토 존재 체크
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomatoBox[i][j] == 0) able = false;
				result = Math.max(result, tomatoBox[i][j]);
			}
		}
		// 안 익은 토마토 존재에 따라 결과출력 다름
		if (able) {
			System.out.println(result - 1);
		} else {
			System.out.println(-1);
		}
	}
	
	static void bfs() {
		
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < nowRipped.size(); i++) {
			q.offer(nowRipped.get(i));
		}
		
		while (!q.isEmpty()) {
			int nowY = q.peek()[0];
			int nowX = q.peek()[1];
			q.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = nowY + dy[i];
				int nx = nowX + dx[i];
				
				if (isInside(ny, nx) && tomatoBox[ny][nx] == 0) {
					q.offer(new int[] {ny, nx});
					tomatoBox[ny][nx] = tomatoBox[nowY][nowX] + 1;
				}
			}
		}
		
	}
	
	static boolean isInside(int y, int x) {
		if ((0 <= y && y  < N) && (0 <= x && x < M)) return true;
		return false;
	}
}
