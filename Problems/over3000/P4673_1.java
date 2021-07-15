package baekjoon2;

public class P4673 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		boolean[] selfNumArr = new boolean[10051];
		
		for (int i = 1; i <= 10000; i++) {
			selfNumArr[getSelfNum(i)] = true;
			
			if (!selfNumArr[i]) sb.append(i).append("\n");
		}
		
		System.out.println(sb);

	}
	
	static int getSelfNum(int i) {
		int sum = i;
		
		while (i != 0) {
			sum += i % 10;
			i /= 10;
		}
			
		return sum;
	}

}
