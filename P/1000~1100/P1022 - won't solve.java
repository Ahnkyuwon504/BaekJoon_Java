package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1021 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int result = 0;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int length = N;
		
		int[] listOfNums = new int[N];
		
		for (int i = 0; i < N; i++) {
			listOfNums[i] = i + 1;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int tc = 0; tc < M; tc++) {
			
			int wantNum = Integer.parseInt(st.nextToken());
			int indexOfWantNum = 0;

			int[] savedList = new int[length];
			for (int i = 0; i< savedList.length; i++) {
				savedList[i] = listOfNums[i];
			}
			
			for (int i = 0; i < listOfNums.length; i++) {
				if (wantNum == listOfNums[i]) {
					indexOfWantNum = i;
					break;
				}
			}
			
			int moveLeft = indexOfWantNum;
			int moveRight = listOfNums.length - indexOfWantNum;
			
			if (moveLeft >= moveRight) {
				
				for (int i = 0; i < listOfNums.length - 1; i++) {
					
					if (i < moveRight - 1) {
						listOfNums[i] = savedList[i + 1 + indexOfWantNum];
					} else {
						listOfNums[i] = savedList[i + 1 - moveRight];
					}
				}
				
				result+=moveRight;
				
			} else {
				
				for (int i = 0; i < listOfNums.length - 1; i++) {
					if (i <= listOfNums.length - moveLeft - 2) {
						//System.out.println(i);
						listOfNums[i] = savedList[i + 1 + moveLeft];
					} else {
						//System.out.println(i);
						listOfNums[i] = savedList[i - (listOfNums.length - moveLeft - 1)];
					}
				}
				result+=moveLeft;
			}
			
			length = listOfNums.length - 1;
			savedList = new int[length];
			
			
			for (int i = 0; i < savedList.length; i++) {
				savedList[i] = listOfNums[i];
			}
			
			listOfNums = new int[length];
			
			for (int i = 0; i < listOfNums.length; i++) {
				listOfNums[i] = savedList[i];
			}
			
		}
		System.out.println(result);
	}
}
