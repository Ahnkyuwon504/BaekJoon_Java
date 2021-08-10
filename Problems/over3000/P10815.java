package baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10815 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		solve();
		
		System.out.println(sb);
	}
	
	public static void solve() throws IOException {
		
		N = Integer.parseInt(br.readLine()); // a
		
		readAndSplitOneLine(); // b
		
		Node root = new Node(Integer.parseInt(st.nextToken())); // b
		
		insertAll(root); // b
		
		M = Integer.parseInt(br.readLine()); // c
		
		readAndSplitOneLine(); // d
		
		check(root);
	}
	
	public static void insertAll(Node root) {
		for (int i = 0; i < N - 1; i++) {
			root.insert(Integer.parseInt(st.nextToken()));
		}
	}
	
	public static void check(Node root) {
		for (int i = 0; i < M; i++) {
			int curr = Integer.parseInt(st.nextToken());
			
			sb.append((root.isExist(curr))? "1" : "0").append(" ");
		}
	}
	
	public static void readAndSplitOneLine() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
	
	static class Node {
		int num;
		Node left;
		Node right;
		
		public Node(int num) {
			this.num = num;
		}
		
		public void insert(int num) {
			if (this.num < num) {
				insertRight(num);
			} else if (this.num > num) {
				insertLeft(num);
			}
		}
		
		public void insertRight(int num) {
			if (this.right == null) {
				this.right = new Node(num);
			} else {
				this.right.insert(num);
			}
		}
		
		public void insertLeft(int num) {
			if (this.left == null) {
				this.left = new Node(num);
			} else {
				this.left.insert(num);
			}
		}
		
		public boolean isExist(int num) {
			if (this.num == num) return true;
			
			if (this.num < num) {
				return isExistRight(num);
			} else {
				return isExistLeft(num);
			}
		}
		
		public boolean isExistRight(int num) {
			if (this.right == null) {
				return false;
			} else {
				return this.right.isExist(num);
			}
		}
		
		public boolean isExistLeft(int num) {
			if (this.left == null) {
				return false;
			} else {
				return this.left.isExist(num);
			}
		}
	}

}
