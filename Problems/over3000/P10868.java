package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10868 {
	
	static class SegmentTree {
		int[] arr;
		int[] tree;
		
		public int init(int start, int end, int node) {
			if (start == end) return tree[node] = arr[start];
			
			int mid = (start + end) / 2;
			
			return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
		}
		
		public int getMin(int start, int end, int node, int left, int right) {
			if (end < left || right < start) return Integer.MAX_VALUE;
			
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
			
			return Math.min(getMin(start, mid, node * 2, left, right), getMin(mid + 1, end, node * 2 + 1, left, right));
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
		segmentTree.tree = new int[N * 4];
		
		for (int i = 1; i <= N; i++) {
			segmentTree.arr[i] = Integer.parseInt(br.readLine());
		}
		
		segmentTree.init(1, N, 1);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(segmentTree.getMin(1, N, 1, a, b)).append("\n");
		}
		
		System.out.println(sb);
	}
}
