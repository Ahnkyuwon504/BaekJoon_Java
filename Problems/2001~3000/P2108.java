package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P2108 {
	
	static int N;
	static int[] arr;
	static ArrayList<Integer>[] list;
	static int range;
	static StringBuilder sb = new StringBuilder();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[8001];
		list = new ArrayList[N + 1];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		int num = 0;
		double sum = 0;
		
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			arr[num + 4000]++;
			sum += num;
		}
		
		sb.append(Math.round(sum / N)).append("\n"); // 산술평균
		getMedian();
		getMode();
		sb.append(range);
		
		System.out.println(sb);
	}
	
	static void getMedian() {
		int cnt = 0;
		int min = 0;
		int max = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i]; j++) {
				cnt++;
				
				if (cnt == (N + 1) / 2) sb.append(i - 4000).append("\n");
				if (cnt == 1) min = i - 4000;
				if (cnt == N) max = i - 4000;
			}
		}
		
		range = max - min;
	}
	
	static void getMode() {
		int fre = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[i] != 0) {
				list[arr[i]].add(i - 4000);
			}
			
			if (arr[i] > fre) fre = arr[i];
			
		}
		
		int mode;
		
		if (list[fre].size() > 1) {
			mode = list[fre].get(1);
		} else {
			mode = list[fre].get(0);
		}
		
		sb.append(mode).append("\n");
	}
	
	static void getRange() {
		
	}
	
	
}
