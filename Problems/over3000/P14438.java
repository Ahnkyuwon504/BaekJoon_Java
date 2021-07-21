package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14438 {
	
	static int N;
	static int impossibleNum = Integer.MAX_VALUE;
	
	static class SegmentTree {
		int[] arr;
		int[] tree;
		
		public int init(int start, int end, int node) {
			if (start == end) return tree[node] = start;
			
			int mid = (start + end) / 2;
			
			int leftMinIndex = init(start, mid, node * 2);
			int rightMinIndex = init(mid + 1, end, node * 2 + 1);
			
			return tree[node] = (arr[leftMinIndex] < arr[rightMinIndex]) ? leftMinIndex : rightMinIndex;
			
		}
		
		public int query(int start, int end, int node, int left, int right) {
			if (end < left || right < start) return impossibleNum;
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
			
			int leftMinIndex = query(start, mid, node * 2, left, right);
			int rightMinIndex = query(mid + 1, end, node * 2 + 1, left, right);
			
			if (leftMinIndex == impossibleNum) return rightMinIndex;
			if (rightMinIndex == impossibleNum) return leftMinIndex;
			
			return (arr[leftMinIndex] < arr[rightMinIndex]) ? leftMinIndex : rightMinIndex;
		}
		
		public int update(int start, int end, int node, int index) {
			if (index < start || end < index) return tree[node];
			if (start == end) return tree[node];
			
			int mid = (start + end) / 2;
			
			int leftMinIndex = update(start, mid, node * 2, index);
			int rightMinIndex = update(mid + 1, end, node * 2 + 1, index);
			
			if (leftMinIndex == impossibleNum) return rightMinIndex;
			if (rightMinIndex == impossibleNum) return leftMinIndex;
			
			return tree[node] = (arr[leftMinIndex] < arr[rightMinIndex]) ? leftMinIndex : rightMinIndex;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		SegmentTree segmentTree = new SegmentTree();
		
		segmentTree.arr = new int[N + 1];
		segmentTree.tree = new int[N * 4];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			segmentTree.arr[i] = Integer.parseInt(st.nextToken());
		
		}
		
		segmentTree.init(1, N, 1);
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				segmentTree.arr[b] = c;
				segmentTree.update(1, N, 1, b);
				
			} else if (a == 2) {
				sb.append(segmentTree.arr[segmentTree.query(1, N, 1, b, c)]).append("\n");
			}
		}
		System.out.println(sb);
		
	}

}
