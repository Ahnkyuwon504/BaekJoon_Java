package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2268 {
	
	static class SegmentTree {
		long[] arr;
		long[] tree;
		
		public long query(int start, int end, int node, int left, int right) {
			if (end < left || right < start) return 0;
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
			
			return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
		}
		
		public void update(int start, int end, int node, int index, long val) {
			if (index < start || end < index) return;
			
			tree[node] += val;
			
			if (start == end) return;
			
			int mid = (start + end) / 2;
			
			update(start, mid, node * 2, index, val);
			update(mid + 1, end, node * 2 + 1, index, val);
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
		segmentTree.arr = new long[N + 1];
		segmentTree.tree = new long[N * 4];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int min = Math.min(b, c);
			int max = Math.max(b, c);
			
			if (a == 0) {
				sb.append(segmentTree.query(1, N, 1, min, max)).append("\n");
			} else if (a == 1) {
				segmentTree.update(1, N, 1, b, c - segmentTree.arr[b]);
				segmentTree.arr[b] = c;
			}
		}
		
		System.out.println(sb);
		
		

	}

}
