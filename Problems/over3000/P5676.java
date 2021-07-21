package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5676 {
	
	static int N, K;
	
	static class SegmentTree {
		int[] arr;
		int[] tree;
		
		public int init(int start, int end, int node) {
			if (start == end) return tree[node] = arr[start];
			
			int mid = (start + end) / 2;
			
			return tree[node] = init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1);
		}
		
		public int query(int start, int end, int node, int left, int right) {
			if (end < left || right < start) return 1;
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
			
			return query(start, mid, node * 2, left, right) * query(mid + 1, end, node * 2 + 1, left, right);
		}
		
		public int update(int start, int end, int node, int index, int val) {
			if (end < index || index < start) return tree[node];
			if (start == index && end == index) return tree[node] = val;
			
			int mid = (start + end) / 2;
			
			return tree[node] = update(start, mid, node * 2, index, val) * update(mid + 1, end, node * 2 + 1, index, val);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String input = "";
		
		while ((input = br.readLine()) != null) {
			st = new StringTokenizer(input);
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			SegmentTree segmentTree = new SegmentTree();
			segmentTree.arr = new int[N + 1];
			segmentTree.tree = new int[N * 4];
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 1; i <= N; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				if (num > 0) {
					segmentTree.arr[i] = 1;
					
				} else if (num == 0) {
					segmentTree.arr[i] = 0;
					
				} else if (num < 0) {
					segmentTree.arr[i] = -1;
					
				}
			}
			
			segmentTree.init(1, N, 1);
			
			for (int tc = 0; tc < K; tc++) {
				st = new StringTokenizer(br.readLine());
				
				String command = st.nextToken();
				int i = Integer.parseInt(st.nextToken());
				int V = Integer.parseInt(st.nextToken());
				
				if (command.charAt(0) == 'C') {
					// update
					if (V > 0) V = 1;
					if (V < 0) V = -1;
					
					segmentTree.update(1, N, 1, i, V);
				} else if (command.charAt(0) == 'P') {
					// calc
					int result = segmentTree.query(1, N, 1, i, V);
					char ret = ' ';
					
					if (result > 0) ret = '+';
					if (result == 0) ret = '0';
					if (result < 0) ret = '-';
					
					sb.append(ret);
					
				}
						
			}
			sb.append("\n");
			
			
			
		}
		
		System.out.println(sb);
		
		
		
	}

}
