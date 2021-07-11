package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			sb.append(get_Number(x1, y1, r1, x2, y2, r2)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int get_Number(int x1, int y1, int r1, int x2, int y2, int r2) {
		int able;
		double distance = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
		distance = Math.sqrt(distance);

		double distance_fromCenter = r1 + r2;

		double smaller_radius = Math.min(r1, r2);

		if (distance < r1 || distance < r2) {
			if (x1 == x2 && y1 == y2 && r1 == r2) {
				able = -1;
			} else if (distance == r1 - r2 || distance == r2 - r1) {
				able = 1;
			} else if (distance + smaller_radius < r1 || distance + smaller_radius < r2) {
				able = 0;
			} else {
				able = 2;
			}

		} else {
			if (distance_fromCenter < distance) {
				able = 0;
			} else if (distance_fromCenter == distance) {
				able = 1;
			} else {
				able = 2;
			}

		}
		
		return able;
	}
}
