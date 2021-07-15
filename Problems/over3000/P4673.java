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
		int cur = 0;
		
		if (1 <= i && i < 10) {
			cur = i + i % 10;
		} else if (10 <= i && i < 100) {
			cur = i + (i / 10) + (i % 10);
		} else if (100 <= i && i < 1000) {
			cur = i + (i / 100) + ((i % 100) / 10) + ((i % 100) % 10);
		} else if (1000 <= i && i <= 10000) {
			cur = i + (i / 1000) + ((i % 1000) / 100) + (((i % 1000) % 100) / 10) + (((i % 1000) % 100) % 10);
		}
			
		return cur;
	}

}
