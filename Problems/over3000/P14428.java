package baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14428 {
	
	static int N;
	static int impossible = 100_000_001;
	
	static class SegmentTree {
		long[] arr;
		int[] tree;
		
		public int init(int start, int end, int node) {
			if (start == end) return tree[node] = start;
			
			int mid = (start + end) / 2;
			
			int leftMinIndex = init(start, mid, node * 2);
			int rightMinIndex = init(mid + 1, end, node * 2 + 1);
			
			return tree[node] = (arr[leftMinIndex] <= arr[rightMinIndex]) ? leftMinIndex : rightMinIndex;
		}
		
		public int query(int start, int end, int node, int left, int right) {
			if (end < left || right < start) return impossible;
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
			
			int leftMinIndex = query(start, mid, node * 2, left, right);
			int rightMinIndex = query(mid + 1, end, node * 2 + 1, left, right);
			
			if (leftMinIndex == impossible) return rightMinIndex;
			if (rightMinIndex == impossible) return leftMinIndex;
			
			return (arr[leftMinIndex] <= arr[rightMinIndex]) ? leftMinIndex : rightMinIndex;
		}
		
		public int update(int start, int end, int node, int index, long val) {
			if (end < index || index < start || start == end) return tree[node];
			
			int mid = (start + end) / 2;
			
			int leftMinIndex = update(start, mid, node * 2, index, val);
			int rightMinIndex = update(mid + 1, end, node * 2 + 1, index, val);
			
			return tree[node] = (arr[leftMinIndex] <= arr[rightMinIndex]) ? leftMinIndex : rightMinIndex;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		SegmentTree segmentTree = new SegmentTree();
		segmentTree.arr = new long[N + 1];
		segmentTree.tree = new int[N * 4];
		
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			segmentTree.arr[i] = Long.parseLong(st.nextToken());
		}
		
		segmentTree.init(1, N, 1);
		
		int M = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < M; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				int i = Integer.parseInt(st.nextToken());
				long v = Long.parseLong(st.nextToken());
				
				segmentTree.arr[i] = v;
				segmentTree.update(1, N, 1, i, v);
				
			} else if (a == 2) {
				int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                
				sb.append(segmentTree.query(1, N, 1, i, j)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
