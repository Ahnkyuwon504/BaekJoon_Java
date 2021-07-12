package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SegmentTree {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Tree segmentTree = new Tree(); // 배열만 들어감
		segmentTree.init(0, segmentTree.arr.length - 1, 1); // 트리 생성, 트리는 1번노드부터 시작
		
		segmentTree.print();
		
		System.out.println("n번부터 m번까지 구간합을 구해드립니다. n과 m을 입력하세요.");
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		System.out.println(segmentTree.sum(0, segmentTree.arr.length - 1, 1, n, m));
		
		segmentTree.print();
		
		System.out.println("n번 값을 m으로 업데이트를 해드립니다. n과 m을 입력하세요.");
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		segmentTree.update(0, segmentTree.arr.length - 1, 1, n, m - segmentTree.arr[n]);
		
		segmentTree.print();
		
		
		
	}
}

class Tree {
	int arr[];
	int tree[];
	
	public Tree() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		System.out.println("배열 크기 입력 : ");
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		tree = new int[N * 4];
		
		System.out.println("배열 요소 입력 : ");
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	public int init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start + end) / 2;
		
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}
	
	public int sum(int start, int end, int node, int left, int right) {
		if (right < start || left > end) return 0;
		if (left <= start && end <= right) return tree[node];
		
		int mid = (start + end) / 2;
		
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}
	
	public void update(int start, int end, int node, int index, int dif) {
		if (index < start || index > end) return;
		tree[node] += dif;
		
		if (start == end) {
			return;
		}
		
		int mid = (start + end) / 2;
		
		update(start, mid, node * 2, index, dif);
		update(mid + 1, end, node * 2 + 1, index, dif);
	}
	
	public void print() {
		System.out.println(Arrays.toString(tree));
	}
}
