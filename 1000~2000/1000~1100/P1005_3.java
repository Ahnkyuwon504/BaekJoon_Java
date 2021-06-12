package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1005_3 {
	
	static StringBuilder sb = new StringBuilder();
	
	static int numberOfTowers;
	static int numberOfRules;
	
	static int[] timeToBuildTowers;
	static int[] numberOfInputNodes;
	static List<List<Integer>> numberOfOutputNodes;
	
	static int winTower;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			
			numberOfTowers = Integer.parseInt(st.nextToken());
			numberOfRules = Integer.parseInt(st.nextToken());
			
			timeToBuildTowers = new int[numberOfTowers + 1];
			numberOfInputNodes = new int[numberOfTowers + 1];
			numberOfOutputNodes = new ArrayList<List<Integer>>();
			
			for (int i = 0; i < numberOfTowers + 1; i++) {
				numberOfOutputNodes.add(new ArrayList<Integer>());
				numberOfInputNodes[i] = 0;
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int ruleIndex = 1; ruleIndex <= numberOfTowers; ruleIndex++) {
				timeToBuildTowers[ruleIndex] = Integer.parseInt(st.nextToken()); 
			}
			
			for (int i = 0; i < numberOfRules; i++) {
				
				st = new StringTokenizer(br.readLine());
				int startTower = Integer.parseInt(st.nextToken());
				int arriveTower = Integer.parseInt(st.nextToken());
				
				numberOfOutputNodes.get(startTower).add(arriveTower);
				numberOfInputNodes[arriveTower]++;
			}
			
			winTower = Integer.parseInt(br.readLine());

			getTopologicalSort(numberOfInputNodes, numberOfOutputNodes, winTower);
		}
		
		System.out.println(sb);
	}
	
	static void getTopologicalSort(
			int[] numberOfInputNodes,
			List<List<Integer>> numberOfOutputNodes,
			int winTower) {
		
		Queue<Integer> readyToProcessing = new LinkedList<>();
		int[] results = new int[numberOfTowers + 1];
		
		for (int i = 1; i <= numberOfTowers; i++) {
			
			if (numberOfInputNodes[i] == 0) {
				readyToProcessing.add(i);
			}
			
			results[i] = timeToBuildTowers[i];
		}
		
		while(!readyToProcessing.isEmpty()) {
			int nowProcessingTower = readyToProcessing.poll();
			
			for (int i = 0; i < numberOfOutputNodes.get(nowProcessingTower).size(); i++) {
				int arriveTower = numberOfOutputNodes.get(nowProcessingTower).get(i);
				
				results[arriveTower] = Math.max(
						results[arriveTower],
						results[nowProcessingTower] + timeToBuildTowers[arriveTower]);
				
				numberOfInputNodes[arriveTower]--;
				
				if (numberOfInputNodes[arriveTower] == 0) {
					readyToProcessing.offer(arriveTower);
				}
			}
		}
		sb.append(results[winTower]).append("\n");
	}
}
