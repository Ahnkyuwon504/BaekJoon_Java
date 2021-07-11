package baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1014 {
	
	static StringBuilder sb = new StringBuilder();
	
	static boolean[][] desksOfClassroom;
	static boolean[][] students;
	
	static int widthOfClassroom;
	static int heightOfClassroom;
	
	static int[] moveX = {-1, 1, -1, 1};
	static int[] moveY = {0, 0, -1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			heightOfClassroom = Integer.parseInt(st.nextToken());
			widthOfClassroom = Integer.parseInt(st.nextToken());
			
			desksOfClassroom = new boolean[heightOfClassroom + 1][widthOfClassroom + 2];
			students = new boolean[heightOfClassroom + 1][widthOfClassroom + 2];
			
			for (int height = heightOfClassroom; height >= 1 ; height--) {
				
				String oneLine = br.readLine();
				
				for (int width = 1; width <= widthOfClassroom; width++) {
					
					String seat = oneLine.substring(width - 1, width);
					
					if (seat.equals(".")) {
						desksOfClassroom[height][width] = true;
					} else {
						desksOfClassroom[height][width] = false;
					}
				}
			}
			
			getMaximumStudentNumber(desksOfClassroom, students);
		}
		
		System.out.println(sb);
		
		br.close();
	}

	static void getMaximumStudentNumber(
			boolean[][] desksOfClassroom,
			boolean[][] students) {
		
		int cnt = 0;
		
		for (int width = 1; width <= desksOfClassroom[0].length - 2; width++) {
			for (int height = 1; height <= desksOfClassroom.length - 1; height++) {
				
				int currentX;
				int currentY;
				
				boolean able = true;
				
				if (desksOfClassroom[height][width]) {
					
					for (int i = 0; i < 4; i++) {
						
						currentX = width + moveX[i];
						currentY = height + moveY[i];
						
						if (students[currentY][currentX]) {
							able = false;
						}
					}
					
					if (able) {
						students[height][width] = true;
						cnt++;
					}
				}
			}
		}
		sb.append(cnt).append("\n");
	}
}
