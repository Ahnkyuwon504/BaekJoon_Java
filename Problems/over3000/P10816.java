package baekjoon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10816 {
	
	static class Node {
		int num;
		int cnt;
		Node left;
		Node right;
		
		public Node(int num) {
			this.num = num;
			this.cnt = 1;
		}
		
		public void insert(int num) {
			if (this.num == num) this.cnt++;
			
			if (this.num < num) {
				if (this.right == null) this.right = new Node(num);
				else this.right.insert(num);
			} else if (this.num > num) {
				if (this.left == null) this.left = new Node(num);
				else this.left.insert(num);
			}
		}
		
		public int check(int num) {
			if (this.num == num) return this.cnt;
			
			if (this.num < num && this.right != null) return this.right.check(num);
			else if (this.num > num && this.left != null) return this.left.check(num);
			
			return 0;
		}
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		Node root = new Node(Integer.parseInt(st.nextToken()));
		
		for (int i = 1; i < N; i++) {
			root.insert(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			sb.append(root.check(Integer.parseInt(st.nextToken()))).append(" ");
		}
		
		System.out.println(sb);

		
	}

}
