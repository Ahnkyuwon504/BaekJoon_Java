package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5543 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int bur = Integer.MAX_VALUE;
		int col = Integer.MAX_VALUE;
		
		for (int i = 0; i < 3; i++) {
			int newburger = Integer.parseInt(br.readLine());
			bur = (bur < newburger)? bur : newburger;
		}
		
		for (int i = 0; i < 2; i++) {
			int newcol = Integer.parseInt(br.readLine());
			col = (col < newcol)? col : newcol;
		}
		
		System.out.println(bur + col - 50);
	}
}
