package baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1920 {
	
	static int N;
	
	static class Node {
		int num;
		Node left;
		Node right;
		
		public Node(int num) {
			this.num = num;
		}
		
		public void insert(int num) {
			if (num > this.num) {
				if (this.right == null) this.right = new Node(num);
				else this.right.insert(num);
			} else if (num < this.num) {
				if (this.left == null) this.left = new Node(num);
				else this.left.insert(num);
			}
		}
		
		public boolean isExist(int num) {
			if (this.num == num) return true;
			
			if (this.num < num && this.right != null) return this.right.isExist(num);
			else if (this.num > num && this.left != null) return this.left.isExist(num);
			
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		Node root = new Node(Integer.parseInt(st.nextToken()));
		
		for (int i = 1; i < N; i++) {
			root.insert(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (root.isExist(num)) sb.append("1");
			else sb.append("0");
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
