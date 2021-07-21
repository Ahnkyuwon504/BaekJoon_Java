package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6549_5 {
	
	static int imposibbleNum = Integer.MAX_VALUE;
	static int N;
	
	static class SegmentTree {
		int[] arr;
		int[] tree;
		
		public int init(int start, int end, int node) {
			if (start == end) return tree[node] = start;
			
			int mid = (start + end) / 2;
			
			int leftMinIndex = init(start, mid, node * 2);
			int rightMinIndex = init(mid + 1, end, node * 2 + 1);
			
			return tree[node] = (arr[leftMinIndex] < arr[rightMinIndex])? leftMinIndex : rightMinIndex;
		}
		
		public int query(int start, int end, int node, int left, int right) {
			if (end < left || right < start) return imposibbleNum;
			
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
			
			int leftMinIndex = query(start, mid, node * 2, left, right);
			int rightMinIndex = query(mid + 1, end, node * 2 + 1, left, right);
			
			if (leftMinIndex == imposibbleNum) return rightMinIndex;
			if (rightMinIndex == imposibbleNum) return leftMinIndex;
			
			return (arr[leftMinIndex] < arr[rightMinIndex]) ? leftMinIndex : rightMinIndex;
		}
		
		public long getMaxArea(int left, int right) {
			int minIndex = query(1, N, 1, left, right);
			
			int height = arr[minIndex];
			int width = right + 1 - left;
			
			long maxArea = height * (long)width;
			
			if (left < minIndex) maxArea = Math.max(maxArea, getMaxArea(left, minIndex - 1));
			if (minIndex < right) maxArea = Math.max(maxArea, getMaxArea(minIndex + 1, right));
			
			return maxArea;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			if (N == 0) break;
			
			SegmentTree segmentTree = new SegmentTree();
			segmentTree.arr = new int[N + 1];
			segmentTree.tree = new int[N * 4];
			
			for (int i = 1; i <= N; i++) {
				segmentTree.arr[i] = Integer.parseInt(st.nextToken());
			}
			
			segmentTree.init(1, N, 1);
			
			sb.append(segmentTree.getMaxArea(1, N)).append("\n");
		}
		
		System.out.println(sb);

	}

}
