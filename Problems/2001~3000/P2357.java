package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2357 {
	
	static class SegmentTree {
		int[] arr;
		int[][] tree; // 최소최대
		
		public int[] init(int start, int end, int node) {
			if (start == end) {
				
				tree[node][0] = arr[start];
				tree[node][1] = arr[start];

				return tree[node] = new int[] {arr[start], arr[start]};
			}
			
			int mid = (start + end) / 2;
			
			int[] leftTree = init(start, mid, node * 2);
			int[] rightTree = init(mid + 1, end, node * 2 + 1);
			
			int min = Math.min(leftTree[0], rightTree[0]);
			int max = Math.max(leftTree[1], rightTree[1]);
			
			return tree[node] = new int[] {min, max};
		}
		
		public int[] getMinMax(int start, int end, int node, int left, int right) {
			if (end < left || right < start) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
			
			if (left <= start && end <= right) return new int[] {tree[node][0], tree[node][1]};
			
			int mid = (start + end) / 2;
			
			int[] leftTree = getMinMax(start, mid, node * 2, left, right);
			int[] rightTree = getMinMax(mid + 1, end, node * 2 + 1, left, right);
			
			int min = Math.min(leftTree[0], rightTree[0]);
			int max = Math.max(leftTree[1], rightTree[1]);
			
			return new int[] {min, max};
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		SegmentTree segmentTree = new SegmentTree();
		segmentTree.arr = new int[N + 1];
		segmentTree.tree = new int[N * 4][2];
		
		for (int i = 1; i <= N; i++) {
			segmentTree.arr[i] = Integer.parseInt(br.readLine());
		}
		
		segmentTree.init(1, N, 1);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int[] minMax = segmentTree.getMinMax(1, N, 1, a, b);
			
			sb.append(minMax[0]).append(" ").append(minMax[1]).append("\n");
		}
		
		System.out.println(sb);
	}
}
