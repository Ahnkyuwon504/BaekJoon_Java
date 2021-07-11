package prj_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1004 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int numberStar = Integer.parseInt(br.readLine());
			
			while (numberStar-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				int x3 = Integer.parseInt(st.nextToken());
				int y3 = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				double d1 = getDis(x1, y1, x3, y3);
				double d2 = getDis(x2, y2, x3, y3);
				
				boolean in1 = d1 > r * r ? true : false;
				boolean in2 = d2 > r * r ? true : false;
				
				if (in1 != in2) cnt++;
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	public static double getDis(int x1, int y1, int x2, int y2) {
		double distance = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
		
		return distance;
	}
}
