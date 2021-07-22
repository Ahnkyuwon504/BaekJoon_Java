package baekjoon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P5639 {
	
	static List<Integer> numList = new ArrayList<Integer>();
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	static int[] tree;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int pre = 0;
		int cur = 0;
		
		int preNode = 0;
		int curNode = 0;
		
		String input;
		
		while (true) {
			input = br.readLine();
			
			if (input == null || input.equals("")) break;
			
			cur = Integer.parseInt(input);
			numList.add(cur);
			
			if (pre > cur) {
				curNode = preNode * 2;
				map.put(cur, curNode);
				
			} else if (pre < cur) {
				curNode = getNode(cur);
				map.put(cur, curNode);
			}
			
			pre = cur;
			preNode = curNode;
			
		}
		
		init();
		visit(1);
		
		System.out.println(sb);
	}
	
	static void visit(int node) {
		if (tree[node] == 0) return;
		
		visit(node * 2);
		visit(node * 2 + 1);
		
		sb.append(tree[node]).append("\n");
	}
	
	
	static void init() {
		tree = new int[40000000];
		
		if (map.isEmpty()) return;
		
		for (int key : map.keySet()) {
			tree[map.get(key)] = key;
		}
	}
	
	static int getNode(int val) {
		int node = 0;
		int near = 0;
		
		for (int num : numList) {
			if (num < val) {
				near = Math.max(num, near);
			}
		}
		
		node = (numList.size() == 1)? 0 : map.get(near);

		return node * 2 + 1;
	}
}
