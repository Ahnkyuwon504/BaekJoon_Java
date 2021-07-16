package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11505_1 {
	
	static int mode = 1000000007;
	
	static class SegmentTree {
		long[] arr;
		long[] tree;
		
		public long init(int start, int end, int node) {
			if (start == end) return tree[node] = arr[start];
			
			int mid = (start + end) / 2;
			
			return tree[node] = init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1) % mode;
		}
		
		public long getMul(int start, int end, int node, int left, int right) {
			if (right < start || end < left) return 1;
			
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
			
			return getMul(start, mid, node * 2, left, right) * getMul(mid + 1, end, node * 2 + 1, left, right) % mode;
		}
		
		public long update(int start, int end, int node, int index, long val) {
			if (index < start || end < index) return tree[node];
			
			if (start == end) return tree[node] = val;
			
			int mid = (start + end) / 2;
			
			return tree[node] = update(start, mid, node * 2, index, val) * update(mid + 1, end, node * 2 + 1, index, val) % mode;
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
		int K = Integer.parseInt(st.nextToken());
		
		SegmentTree tree = new SegmentTree();
		tree.arr = new long[N];
		tree.tree = new long[N * 4];
		
		for (int i = 0; i < N; i++) {
			tree.arr[i] = Long.parseLong(br.readLine());
		}
		
		tree.init(0, tree.arr.length - 1, 1);
		
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) {
				tree.update(0, tree.arr.length - 1, 1, b - 1, c);
				tree.arr[b - 1] = c;
			} else if (a == 2) {
				sb.append(tree.getMul(0, tree.arr.length - 1, 1, b - 1, (int)c - 1)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
