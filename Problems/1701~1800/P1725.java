package baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1725 {
	
	static int N;
	static int impossible = 100_001;
	static long ret = Long.MIN_VALUE;
	
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
			if (end < left || right < start) return impossible;
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
			
			int leftMinIndex = query(start, mid, node * 2, left, right);
			int rightMinIndex = query(mid + 1, end, node * 2 + 1, left, right);
			
			if (leftMinIndex == impossible) return rightMinIndex;
			if (rightMinIndex == impossible) return leftMinIndex;
			
			return (arr[leftMinIndex] < arr[rightMinIndex]) ? leftMinIndex : rightMinIndex;
		}
		
		public long getMaxArea(int start, int end) {
			if (start == end) return 0;
			
			int minIndex = query(1, N, 1, start, end);
			long area = (long)(end - start + 1) * arr[minIndex];
			
			if (start < minIndex) area = Math.max(area, getMaxArea(start, minIndex - 1));
			if (minIndex < end) area = Math.max(area, getMaxArea(minIndex + 1, end));
			
			return area;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		SegmentTree segmentTree = new SegmentTree();
		segmentTree.arr = new int[N + 1];
		segmentTree.tree = new int[N * 4];
		
		for (int i = 1; i <= N; i++) {
			segmentTree.arr[i] = Integer.parseInt(br.readLine());
		}
		
		segmentTree.init(1, N, 1);
		
		System.out.println(segmentTree.getMaxArea(1, N));
		
	}

}
