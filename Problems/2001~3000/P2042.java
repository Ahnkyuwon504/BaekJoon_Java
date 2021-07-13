package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2042 {
	
	static int N, M, K;
	
	static class Tree {
		long[] arr;
		long[] tree;
		
		public long init(int start, int end, int node) {
			if (start == end) return tree[node] = arr[start];
			
			int mid = (start + end) / 2;
			
			return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
		}
		
		public long sum(int start, int end, int node, int left, long right) {
			if (right < start || end < left) return 0;
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
			
			return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
		}
		
		public void update(int start, int end, int node, int index, long dif) {
			if (index < start || end < index) return;
			
			tree[node] += dif;
			
			if (start == end) return;
			
			int mid = (start + end) / 2;
			
			update(start, mid, node * 2, index, dif);
			update(mid + 1, end, node * 2 + 1, index, dif);
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
		
		Tree segmentTree = new Tree();
		segmentTree.arr = new long[N];
		segmentTree.tree = new long[N * 4];
		
		
		for (int i = 0; i < N; i++) {
			segmentTree.arr[i] = Long.parseLong(br.readLine());
		}
		
		segmentTree.init(0, segmentTree.arr.length - 1, 1);
		
		for (int tc = 0; tc < M + K; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) {
				segmentTree.update(0, segmentTree.arr.length -1, 1, b - 1, c - segmentTree.arr[b-1]);
				segmentTree.arr[b - 1] = c;
			} else if (a == 2) {
				sb.append(segmentTree.sum(0, segmentTree.arr.length - 1, 1, b - 1, c - 1)).append("\n");
			}
		}

		System.out.println(sb);
	}
}
