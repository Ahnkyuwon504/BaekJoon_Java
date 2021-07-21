package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1275 {
	
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
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			segmentTree.arr[i] = Integer.parseInt(st.nextToken());
		}
		
		segmentTree.init(1, N, 1);
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int min = Math.min(x, y);
			int max = Math.max(x, y);
			
			sb.append(segmentTree.query(1, N, 1, min, max)).append("\n");
			segmentTree.update(1, N, 1, a, b - segmentTree.arr[a]);
			segmentTree.arr[a] = b;
		}
		
		System.out.println(sb);
		
		
		
		
		

	}

}
