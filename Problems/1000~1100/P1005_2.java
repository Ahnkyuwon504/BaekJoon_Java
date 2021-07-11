package prj_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1005_2 {
    
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int numberOfTowers;
    static int numberOfRules;
    static int[] timeToBuild;
    static int[] listOfEachTower_Indegree;
    static List<List<Integer>> listOfEachTower_OutDegree;

    static int startTower;
    static int arriveTower;

    static int winTower;

    public static void main(String[] args) throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");

            numberOfTowers = Integer.parseInt(st.nextToken());
            numberOfRules = Integer.parseInt(st.nextToken());
            timeToBuild = new int[numberOfTowers + 1];

            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 1; i <= numberOfTowers; i++) {
                timeToBuild[i] = Integer.parseInt(st.nextToken());
            }

            listOfEachTower_Indegree = new int[numberOfTowers + 1];
            listOfEachTower_OutDegree = new ArrayList<List<Integer>>();

            for (int i = 0; i < numberOfTowers + 1; i++) {
                listOfEachTower_OutDegree.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < numberOfTowers; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                startTower = Integer.parseInt(st.nextToken());
                arriveTower = Integer.parseInt(st.nextToken());

                listOfEachTower_Indegree[arriveTower]++;
                listOfEachTower_OutDegree.get(startTower).add(arriveTower);
            }

            winTower = Integer.parseInt(br.readLine());

            topologicalSort(listOfEachTower_Indegree, listOfEachTower_OutDegree, winTower);
        }

        System.out.println(sb);
    }

    static void topologicalSort(int[] listOfEachTower_Indegree, List<List<Integer>> listOfEachTower_OutDegree,
            int winTower) {

        Queue<Integer> queue_ReadyToProcess = new LinkedList<Integer>();
        int[] resultOfTime = new int[numberOfTowers + 1];

        for (int i = 1; i <= numberOfTowers; i++) {
            resultOfTime[i] = timeToBuild[i];

            if (listOfEachTower_Indegree[i] == 0) {
                queue_ReadyToProcess.offer(i);
            }
        }

        while (!queue_ReadyToProcess.isEmpty()) {
            int towerNowProcessing = queue_ReadyToProcess.poll();

            for (Integer i : listOfEachTower_OutDegree.get(towerNowProcessing)) {
                resultOfTime[i] = Math.max(resultOfTime[i], resultOfTime[towerNowProcessing] + timeToBuild[i]);
                listOfEachTower_Indegree[i]--;

                if (listOfEachTower_Indegree[i] == 0) {
                    queue_ReadyToProcess.offer(i);
                }
            }
        }

        sb.append(resultOfTime[winTower]).append("\n");
    }
}
