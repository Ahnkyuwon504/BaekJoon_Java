package baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1018 {
	
	static boolean[][] whiteStart = new boolean[8][8];
	static boolean[][] blackStart = new boolean[8][8];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[][] chess;
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (((i + j) % 2) == 0) {
					whiteStart[i][j] = false;
					blackStart[i][j] = true;
				} else {
					whiteStart[i][j] = true;
					blackStart[i][j] = false;
					
				}
			}
		}
		
		String firstLine = br.readLine();
		st = new StringTokenizer(firstLine);
		
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		chess = new boolean[height][width];
		
		for (int i = 0; i < height; i++) {
			String oneChessLine = br.readLine();
			for (int j = 0; j < width; j++) {
				if (oneChessLine.substring(j, j+1).equals("W")) {
					chess[i][j] = false;
				} else {
					chess[i][j] = true;					
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		
		for (int i = 0; i <= (height - 8); i++) {
			for (int j = 0; j <= (width - 8); j++) {
				boolean[][] chessEightbyEight = new boolean[8][8];
				
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						chessEightbyEight[k][l] = chess[k + i][l + j];
					}
				}
				
				result = Math.min(compareChess(chessEightbyEight), result);
			}
		}
		
		System.out.println(result);
	}
	
	static int compareChess (boolean[][] targetChess) {
		int cnt1 = 0;
		int cnt2 = 0;
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (whiteStart[i][j] != targetChess[i][j]) {
					cnt1++;
				}
			}
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (blackStart[i][j] != targetChess[i][j]) {
					cnt2++;
				}
			}
		}
		
		if (cnt1 > cnt2) {
			cnt1 = cnt2;
		} 
		
		return cnt1;
	}
}
