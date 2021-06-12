package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.io.IOException;

public class P1013 {

    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	String pattern = "^(100+1+|01)+$";
    	String testStr;
    	boolean result;
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int tc = 1; tc <= T; tc++) {
    		testStr = br.readLine();
    		
    		result = Pattern.matches(pattern, testStr);
    		sb.append(result).append("\n");
    	}
    	
    	System.out.println(sb);
    	
    	br.close();
    }
}
