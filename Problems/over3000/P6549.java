package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6549 {
	
	static int n;
	
	private static class SegmentTree {
		int[] arr;
		int[] tree;
		
		// 최소높이를 갖는 index를 tree에 넣음
		public int init(int start, int end, int node) {
			if (start == end) return tree[node] = start;
			
			int mid = (start + end) / 2;
			
			int leftMinIndex = init(start, mid, node * 2);
			int rightMinIndex = init(mid + 1, end, node * 2 + 1);
			
			return tree[node] = arr[leftMinIndex] < arr[rightMinIndex] ? leftMinIndex : rightMinIndex;
		}
		
		
		public int query(int start, int end, int node, int left, int right) {
			if (end < left || right < start) return Integer.MAX_VALUE;
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
			
			int leftMinIndex = query(start, mid, node * 2, left, right);
			int rightMinIndex = query(mid + 1, end, node * 2 + 1, left, right);
			
			if (leftMinIndex == Integer.MAX_VALUE) return rightMinIndex;
			if (rightMinIndex == Integer.MAX_VALUE) return leftMinIndex;
			return arr[leftMinIndex] < arr[rightMinIndex]? leftMinIndex : rightMinIndex;
		}
		
		public long getMaxWidth(int left, int right) {
			long maxWidth, curWidth;
			int minIndex = query(1, n, 1, left, right);
			
			maxWidth = (long)(right - left + 1) * (long)arr[minIndex];
			
			if (left < minIndex) {
				curWidth = getMaxWidth(left, minIndex - 1);
				maxWidth = Math.max(maxWidth, curWidth);
			}
			
			if (minIndex < right) {
				curWidth = getMaxWidth(minIndex + 1, right);
				maxWidth = Math.max(maxWidth, curWidth);
			}
					
			return maxWidth;			
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			if (n == 0) break;
			
			SegmentTree segmentTree = new SegmentTree();
			segmentTree.arr = new int[n + 1];
			segmentTree.tree = new int[n * 4];
			
			for (int i = 1; i <= n; i++) {
				segmentTree.arr[i] = Integer.parseInt(st.nextToken());
			}
			
			segmentTree.init(1, n, 1);
			
			sb.append(segmentTree.getMaxWidth(1, n)).append("\n");
		}
		
		System.out.println(sb);
	}
}