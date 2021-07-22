package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P4963 {
	
	static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	static int w;
	static int h;
	
	static int[][] map;
	static boolean[][] visit;
	
	static int island;
	
	static class Node {
		int y;
		int x;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			island = 0;
			
			if (w == 0 && h == 0) break;
			
			map = new int[h][w];
			visit = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visit[i][j] && map[i][j] == 1) {
						bfs(new Node(i, j));
						island++;
					}
					
					
				}
			}
			
			sb.append(island).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
	static void bfs(Node nowNode) {
		int nowY = nowNode.y;
		int nowX = nowNode.x;
		
		visit[nowY][nowX] = true;
		Queue<Node> q = new LinkedList<Node>();
		
		q.offer(nowNode);
		
		while (!q.isEmpty()) {
			Node node = q.poll();
			
			int y = node.y;
			int x = node.x;
			
			for (int i = 0; i < 8; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (isInside(ny, nx) && !visit[ny][nx] && map[ny][nx] == 1) {
					q.offer(new Node(ny, nx));
					visit[ny][nx] = true;
				}
			}
			
			
		}
		
		
		
		
	}
	
	static boolean isInside(int y, int x) {
		return (0 <= y && y < h) && (0 <= x && x < w);
	}

}
