package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2042_1 {
	
	static class Tree {
		long[] arr;
		long[] tree;
		
		public long init(int start, int end, int node) {
			if (start == end) {
				return tree[node] = arr[start];
			}
			
			int mid = (start + end) / 2;
			
			return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
		}
		
		public long getSum(int start, int end, int left, int right, int node) {
			if (right < start || end < left) return 0;
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
			
			return getSum(start, mid, left, right, node * 2) + getSum(mid + 1, end, left, right, node * 2 + 1);
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
		
		Tree tree = new Tree();
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		tree.arr = new long[N];
		tree.tree = new long[N * 4];
		
		for (int i = 0; i < N; i++) {
			tree.arr[i] = Integer.parseInt(br.readLine());
		}
		
		tree.init(0, tree.arr.length - 1, 1);
		
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) {

				tree.update(0, tree.arr.length - 1, 1, b - 1, c - tree.arr[b - 1]);
				tree.arr[b - 1] = c;
				
			} else if (a == 2) {
				
				sb.append(tree.getSum(0, tree.arr.length - 1, b - 1, (int)c - 1, 1)).append("\n");
				
			}
		}
		
		System.out.println(sb);
	}
}
