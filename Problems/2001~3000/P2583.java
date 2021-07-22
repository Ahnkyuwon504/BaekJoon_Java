package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2583 {
	
	static int M, N, K;
	static boolean[][] map, visit;
	
	static int numArea = 0;
	static List<Integer> areaList = new ArrayList<Integer>();
	static int area;
	
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[M][N];
		visit = new boolean[M][N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			makeRectangleInMap(x1, y1, x2, y2);
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!map[i][j] && !visit[i][j]) {
					area = 0;
					bfs(new Node(i, j));
					areaList.add(area);
					
					numArea++;
				}
			}
		}
		
		sb.append(numArea).append("\n");
		
		Integer[] result = areaList.toArray(new Integer[] {0});
		Arrays.sort(result);
		
		for (int i : result) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(Node startNode) {
		Queue<Node> q = new LinkedList<Node>();
		
		visit[startNode.y][startNode.x] = true;
		q.offer(startNode);
		area++;
		
		while (!q.isEmpty()) {
			Node nowProcessingNode = q.poll();
			
			int y = nowProcessingNode.y;
			int x = nowProcessingNode.x;
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (isAvail(ny, nx) && !map[ny][nx] && !visit[ny][nx]) {
					
					visit[ny][nx] = true;
					q.offer(new Node(ny, nx));
					area++;
					
				}
			}
		}
	}
	
	static boolean isAvail(int y, int x) {
		return ((0 <= x && x < N) && (0 <= y && y < M));
	}
	
	static void makeRectangleInMap(int x1, int y1, int x2, int y2) {
		for (int i = y1; i < y2; i++) {
			for (int j = x1; j < x2; j++) {
				map[i][j] = true;
			}
		}
	}
}
