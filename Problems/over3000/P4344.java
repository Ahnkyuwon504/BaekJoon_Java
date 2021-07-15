package baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4344 {
	
	static int stuNum = 0;
	static double[] scoreArr;
	static double sum = 0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int C = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < C; tc++) {
			st = new StringTokenizer(br.readLine());
			
			stuNum = Integer.parseInt(st.nextToken());
			scoreArr = new double[stuNum];
			sum = 0;
			
			for (int stu = 0; stu < stuNum; stu++) {
				double score = Double.parseDouble(st.nextToken());
				scoreArr[stu] = score;
				sum += score;
			}
			
			getAvg(tc);
		}
		
		System.out.println(sb);
		
	}
	
	static void getAvg(int tc) {
		double avg = sum / stuNum;
		double cnt = 0;
		
		for (double score : scoreArr) {
			if (score > avg) cnt++;
		}
		
		double answer = cnt * 100 / stuNum;
		
		sb.append(String.format("%.3f%%", answer)).append("\n");
	}
}
