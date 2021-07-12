package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659_1 {
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Tree segmentTree = new Tree();
		segmentTree.arr = new int[N];
		segmentTree.tree =new int[N * 4];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			segmentTree.arr[i] = Integer.parseInt(st.nextToken());
		}
		
		segmentTree.init(0, segmentTree.arr.length - 1, 1);
		
		
		for (int tc = 0; tc < M; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			sb.append(segmentTree.sum(0, segmentTree.arr.length - 1, 1, u - 1, v - 1)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static class Tree {
		int[] arr;
		int[] tree;
		
		public int init(int start, int end, int node) {
			if (start == end) return tree[node] = arr[start];
			
			int mid = (start + end) / 2;
			
			return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
		}
		
		public int sum(int start, int end, int node, int left, int right) {
			if (right < start || end < left) return 0;
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
			
			return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
		}
	}
}
