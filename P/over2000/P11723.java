package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P11723 {
	
	static Set<Integer> set = new HashSet<Integer>();
	static Set<Integer> fullSet = new HashSet<Integer>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine());
					
			char ope = st.nextToken().charAt(1);
			
			switch (ope) {
			case 'd' : add(Integer.parseInt(st.nextToken())); break;
			case 'e' : remove(Integer.parseInt(st.nextToken())); break;
			case 'h' : check(Integer.parseInt(st.nextToken())); break;
			case 'o' : toggle(Integer.parseInt(st.nextToken())); break;
			case 'l' : all(); break;
			case 'm' : empty(); break;
			}
		}
		
		System.out.println(sb);
	}
	
	static void add(int x) {
		if (!set.contains(x)) {
			set.add(x);
		}
	}
	
	static void remove(int x) {
		if (set.contains(x)) {
			set.remove(x);
		}
	}
	static void check(int x) {
		sb.append((set.contains(x)) ? 1 : 0).append("\n");
	}
	
	static void toggle(int x) {
		if (set.contains(x)) {
			set.remove(x);
		} else {
			set.add(x);
		}
	}
	
	static void all() {
		set = new HashSet<Integer>();
		
		for (int i = 1; i <= 20; i++) {
			set.add(i);
		}
	}
	
	static void empty() {
		set = new HashSet<Integer>();
	}

}
