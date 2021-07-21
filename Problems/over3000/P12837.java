package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P12837 {
	
	static class SegmentTree {
		long[] arr;
		long[] tree;
		
		public long init(int start, int end, int node) {
			if (start == end) return tree[node] = arr[start];
			
			int mid = (start + end) / 2;
			
			return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
		}
		
		public long query(int start, int end, int node, int left, int right) {
			if (end < left || right < start) return 0;
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
					
			return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
		}
		
		public void update(int start, int end, int node, int index, long val) {
			if (index < start || end < index) return;
			if (start <= index && index <= end) tree[node] += val;
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
		int Q = Integer.parseInt(st.nextToken());
		
		SegmentTree segmentTree = new SegmentTree();
		segmentTree.arr = new long[N + 1];
		segmentTree.tree = new long[N * 4];
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			long q = Long.parseLong(st.nextToken());
			System.out.println(Arrays.toString(segmentTree.arr));
			
			if (a == 1) {
				segmentTree.update(1, N, 1, p, q);
				segmentTree.arr[p] = q;
				
			} else if (a == 2) {
				sb.append(segmentTree.query(1, N, 1, p, (int)q)).append("\n");
				
			}
		}
		
		System.out.println(sb);
	}
}
