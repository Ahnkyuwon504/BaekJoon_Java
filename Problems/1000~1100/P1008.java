package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1008 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		double x = Double.parseDouble(st.nextToken());
		double y = Double.parseDouble(st.nextToken());

		sb.append("x is : " + x + "\n" + "y is : " + y + "\n").append("x/y is : " + x / y);

		System.out.println(sb);
	}

}
