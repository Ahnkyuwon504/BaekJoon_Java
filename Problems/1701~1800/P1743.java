package baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1743 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;
	static int[][] map;
	
	static int garbage;
	static int maxGarbage = Integer.MIN_VALUE;
	
	static int[] dy = new int[] {-1, 1, 0, 0};
	static int[] dx = new int[] {0, 0, -1, 1};
	
	static class Node {
		int y;
		int x;
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] valArr = getVal();
		
		N = valArr[0];
		M = valArr[1];
		int K = valArr[2];
		
		map = new int[N + 1][M + 1];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			map[y][x] = 1;
		}
		
		check();
		
		System.out.println(maxGarbage);
	}
	
	static void check() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] != 0) {
					garbage = 0;
					bfs(i, j);
					maxGarbage = Math.max(garbage, maxGarbage);
				}
			}
		}
	}
	
	static void bfs(int y, int x) {
		Queue<Node> q = new LinkedList<Node>();
		
		garbage++;
		map[y][x] = 0;
		q.offer(new Node(y, x));
		
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			int currY = curr.y;
			int currX = curr.x;
			
			for (int i = 0; i < 4; i++) {
				int nextY = currY + dy[i];
				int nextX = currX + dx[i];
				
				if (isAvail(nextY, nextX) && map[nextY][nextX] != 0) {
					garbage++;
					map[nextY][nextX] = 0;
					q.offer(new Node(nextY, nextX));
				}
			}
		}
	}
	
	static int[] getVal() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] valArr = new int[] {N, M, K};
		
		return valArr;
	}
	
	static boolean isAvail(int y , int x) {
		return ((1 <= y && y <= N) && (1 <= x && x <= M));
	}
}
