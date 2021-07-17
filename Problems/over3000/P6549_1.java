package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P6549_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			if (n == 0) break;
			
			int[] histogram = new int[n];
			
			for (int i = 0; i < n; i++) {
				histogram[i] = Integer.parseInt(st.nextToken());
			}
			
			long maxArea = 0;
			Stack<Integer> stack = new Stack<Integer>();
			
			for (int i = 0; i < n; i++) {
				
				while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
					int height = histogram[stack.pop()];
					
					long width = stack.isEmpty()? i : i - 1 - stack.peek();
					
					maxArea = Math.max(maxArea, height * width);
				}
				
				stack.push(i);
			}
			
			while (!stack.isEmpty()) {
				int height = histogram[stack.pop()];
				
				long width = stack.isEmpty()? n : n - 1 - stack.peek();
				
				maxArea = Math.max(maxArea, width * height);
			}
			
			sb.append(maxArea).append("\n");
		}
		
		System.out.println(sb);
	}
}
