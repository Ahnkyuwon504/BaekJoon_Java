package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7568 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		int[] rank = new int[N];
		int weight, height;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			weight = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			
			arr[i][0] = weight;
			arr[i][1] = height;
		}
		
		Arrays.fill(rank, 1);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				
				if ((arr[i][0] < arr[j][0]) && (arr[i][1] < arr[j][1])) rank[i]++;
				
			}
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(rank[i]).append(" ");
		}
		
		System.out.println(sb);

	}
}
