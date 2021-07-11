package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1005_1 {
	
	static int numberOfnodes;
	static int numberOfrules;
	static int[] timeTobuild;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		
		///한개의 Test에 대하여...
		while (T-- > 0) {
			///////// 타워개수, 규칙개수 1줄
			st = new StringTokenizer(br.readLine(), " ");
			numberOfnodes = Integer.parseInt(st.nextToken());
			numberOfrules = Integer.parseInt(st.nextToken());
			timeTobuild = new int[numberOfnodes+1];
			
			List<List<Integer>> listOfEachTower_OutDegree = new ArrayList<List<Integer>>();
			
			for (int i = 0; i < numberOfnodes + 1; i++) {
				listOfEachTower_OutDegree.add(new ArrayList<Integer>());
			}
			
			int[] listOfEachTower_InDegree = new int[numberOfnodes + 1];
			
			////////////타워 건설 소요시간 1줄
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= numberOfnodes; i++) {
				timeTobuild[i] = Integer.parseInt(st.nextToken());
			}
			
			///////////타워 규칙. 규칙개수만큼 나옴
			for (int i = 0; i < numberOfrules; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int firstTowerNumber = Integer.parseInt(st.nextToken());
				int secondTowerNumber = Integer.parseInt(st.nextToken());
				
				listOfEachTower_OutDegree.get(firstTowerNumber).add(secondTowerNumber);
				listOfEachTower_InDegree[secondTowerNumber]++;
			}
			
			//////////이기기 위한 타워
			int winTower = Integer.parseInt(br.readLine());
			////// 이제 input, output, winTower 정리되었음.
			topologicalSort(listOfEachTower_InDegree, listOfEachTower_OutDegree, winTower);
		}
		System.out.println(sb);
	}
	
	static void topologicalSort(
			int[] listOfEachTower_InDegree
			, List<List<Integer>> listOfEachTower_OutDegree
			, int winTower) {
		
		Queue<Integer> queue_ReadyToProcess = new LinkedList<Integer>();
		int[] resultOfTime = new int[numberOfnodes + 1];
		
		for (int i = 1; i <= numberOfnodes; i++) {
			resultOfTime[i] = timeTobuild[i];
			
			if(listOfEachTower_InDegree[i] == 0) {
				queue_ReadyToProcess.offer(i);
			}
		}
		
		while(!queue_ReadyToProcess.isEmpty()) {
			int nodeNowProcessing = queue_ReadyToProcess.poll();
			
			for (Integer i : listOfEachTower_OutDegree.get(nodeNowProcessing)) {
				resultOfTime[i] = Math.max(resultOfTime[i], 
										resultOfTime[nodeNowProcessing] + timeTobuild[i]);
				listOfEachTower_InDegree[i]--;
				
				if (listOfEachTower_InDegree[i] == 0) {
					queue_ReadyToProcess.offer(i);
				}
				
			}
		}
		
		sb.append(resultOfTime[winTower]).append("\n");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
