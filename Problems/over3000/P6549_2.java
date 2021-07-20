package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P6549_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			
			if (n == 0) break;
			
			int[] histogram = new int[n + 1];
			Stack<Integer> stack = new Stack<Integer>();
			long maxWidth = 0;
			
			for (int i = 1; i <= n; i++) {
				histogram[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= n; i++) {
				
				while (!stack.isEmpty() && histogram[stack.peek()] > histogram[i]) {
					int height = histogram[stack.pop()];
					
					if (!stack.isEmpty()) maxWidth = Math.max(maxWidth, height * (i - stack.peek() - 1));
				}
				
				stack.push(i);
			}
			
			while (!stack.isEmpty()) {
				int height = histogram[stack.pop()];
				
				if (!stack.isEmpty()) maxWidth = Math.max(maxWidth, height * (n + 1 - stack.peek()));
			}

			sb.append(maxWidth).append("\n");
		}
		
		System.out.println(sb);
	}

}
