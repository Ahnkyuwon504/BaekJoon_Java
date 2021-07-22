package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10999 {
	
	static int N, M, K;
	
	static class SegmentTree {
		long[] arr;
		long[] tree;
		long[] lazy;
		
		public long init(int start, int end, int node) {
			if(start == end) return tree[node] = arr[start];
			
			int mid = (start + end) / 2;
			
			return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
		}
		
		public long query(int start, int end, int node, int left, int right) {
			updateLazy(start, end, node);
			if (end < left || right < start) return 0;
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
			
			return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
		}
		
		public void update(int start, int end, int node, int left, int right, long val) {
			updateLazy(start, end, node);
			if (end < left || right < start) return;
			
			if (left <= start && end <= right) {
				lazy[node] += val;
				updateLazy(start, end, node);
				return;
			}
			
			int mid = (start + end) / 2;
			
			update(start, mid, node * 2, left, right, val);
			update(mid + 1, end, node * 2 + 1, left, right, val);
			tree[node] = tree[node * 2] + tree[node * 2 + 1];
			
		}
		
		public void updateLazy(int start, int end, int node) {
			if (lazy[node] == 0) return;
			
			tree[node] += (end - start + 1) * lazy[node];
			
			if(start != end) {
				lazy[node * 2] += lazy[node];
				lazy[node * 2 + 1] += lazy[node];
			}
			
			lazy[node] = 0;
			
		}
				 
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		SegmentTree segmentTree = new SegmentTree();
		segmentTree.arr = new long[N + 1];
		segmentTree.tree = new long[N * 4];
		segmentTree.lazy = new long[N * 4];
		
		for (int i = 1; i<= N; i++) {
			segmentTree.arr[i] = Long.parseLong(br.readLine());
		}
		
		segmentTree.init(1, N, 1);
		
		for (int tc = 0; tc < M + K; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				long d = Long.parseLong(st.nextToken());
				segmentTree.update(1, N, 1, b, c, d);
			} else if (a == 2) {
				sb.append(segmentTree.query(1, N, 1, b, c)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
