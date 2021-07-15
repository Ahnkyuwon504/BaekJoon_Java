package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1546 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		double[] score = new double[N];
		double max = Double.MIN_VALUE;
		double cur = 0;
		double sum = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			
			cur = Double.parseDouble(st.nextToken());
			
			if (cur > max) max = cur;
			
			score[i] = cur;
			sum += cur;
		}
		
		System.out.println(sum * 100 / (max * N));
	}
}
