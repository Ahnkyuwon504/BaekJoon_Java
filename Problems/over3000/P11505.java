package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11505 {
	
	static int N, M, K;
	static int mode = 1000000007;
	
	static class Tree {
		long[] arr;
		long[] tree;
		
		public long getTree(int start, int end, int node) {
			if (start == end) return tree[node] = arr[start];
			
			int mid = (start + end) / 2;
			
			return tree[node] = getTree(start, mid, node * 2) * getTree(mid + 1, end, node * 2 + 1) % mode;
		}
		
		public long getDiv(int start, int end, int node, int left, long right) {
			if (right < start || end < left) return 1;
			
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
			
			return getDiv(start, mid, node * 2, left, right) * getDiv(mid + 1, end, node * 2 + 1, left, right) % mode;
		}
		
		public long update(int start, int end, int node, int index, long val) {
			if (index < start || end < index) return tree[node];
			
			if (start == end) {
				return tree[node] = val;
			}
			
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
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Tree segmentTree = new Tree();
		
		segmentTree.arr = new long[N + 1]; 
		segmentTree.tree = new long[N * 4]; 
		
		for (int i = 1; i <= N; i++) {
			segmentTree.arr[i] = Integer.parseInt(br.readLine());
		}
		
		segmentTree.getTree(1, N, 1);
		
		for (int tc = 0; tc < M + K; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) {
				segmentTree.arr[b] = c;
				segmentTree.update(1, N, 1, b, c);
			} else {
				sb.append(segmentTree.getDiv(1, N, 1, b, c)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
