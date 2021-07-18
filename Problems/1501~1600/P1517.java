package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1517 {
	
	static int N;
	
	static class SegmentTree {
		int[] arr;
		int[] tree;
		
		public int init(int start, int end, int node) {
			if (start == end) return tree[node] = start;
			
			int mid = (start + end) / 2;
			
			int leftMinIndex = init(start, mid, node * 2);
			int rightMinIndex = init(mid + 1, end, node * 2 + 1);
			
			return tree[node] = (arr[leftMinIndex] <= arr[rightMinIndex]) ? leftMinIndex : rightMinIndex;
		}
		
		public int query(int start, int end, int node, int left, int right) {
			if (end < left || right < start) return Integer.MAX_VALUE;
			
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
			
			int leftMinIndex = query(start, mid, node * 2, left, right);
			int rightMinIndex = query(mid + 1, end, node * 2 + 1, left, right);
			
			if (leftMinIndex == Integer.MAX_VALUE) return rightMinIndex;
			else if (rightMinIndex == Integer.MAX_VALUE) return leftMinIndex;
			
			return (arr[leftMinIndex] <= arr[rightMinIndex]) ? leftMinIndex : rightMinIndex;
		}
		
		
		public long getBubble(int left, int right, int rank) {
			int minIndex = query(1, N, 1, left, right);
			long bubble = minIndex - rank;
			
			if (left < minIndex) bubble += getBubble(left, minIndex - 1, rank);
			if (minIndex < right) bubble += getBubble(minIndex + 1, right, rank + 1);
			
			return bubble;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		SegmentTree segmentTree = new SegmentTree();
		segmentTree.arr = new int[N + 1];
		segmentTree.tree = new int[N  * 4];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			segmentTree.arr[i] = Integer.parseInt(st.nextToken());
		}
		
		segmentTree.init(1, N, 1);
		
		System.out.println(segmentTree.getBubble(1, N, 1));
	}

}
