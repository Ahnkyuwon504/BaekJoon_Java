package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2941 {
	
	static String str;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		
		result += getCroatianCnt("c=");
		result += getCroatianCnt("c-");
		result += getCroatianCnt("dz=");
		result += getCroatianCnt("d-");
		result += getCroatianCnt("lj");
		result += getCroatianCnt("nj");
		result += getCroatianCnt("s=");
		result += getCroatianCnt("z=");
		
		for (int index = 0; index < str.length(); index++) {
			if ((int)str.charAt(index) != 43) result++;
		}
		
		System.out.println(result);
	}
	
	static int getCroatianCnt(String cro) {
		String replaceStr = "";
		
		for (int i = 0; i < cro.length(); i++) {
			replaceStr += "++";
		}
		
		int pre = str.length();
		str = str.replace(cro, replaceStr);
		
		int cur = str.length();
		
		return (cur - pre) / cro.length();
	}

}
