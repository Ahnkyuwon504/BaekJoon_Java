package dpdfsmemorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P1463 {

    static int N;
    static int[] calArr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        calArr = new int[N + 1];

        // dfs(N, 0);
        bfs();
        System.out.println(calArr[1]);
    }

    static void dfs(int num, int cal) {

        if (calArr[num] != 0) {
            calArr[num] = Math.min(calArr[num], cal);
        } else {
            calArr[num] = cal;
        }

        if (num == 1)
            return;

        if (num % 3 == 0)
            dfs(num / 3, cal + 1);
        if (num % 2 == 0)
            dfs(num / 2, cal + 1);
        if (num > 1)
            dfs(num - 1, cal + 1);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(N);
        calArr[N] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            if (node % 3 == 0) {

                if (calArr[node / 3] != 0) {
                    calArr[node / 3] = Math.min(calArr[node / 3], calArr[node] + 1);
                } else {
                    calArr[node / 3] = calArr[node] + 1;
                }
                q.offer(node / 3);
            }
            
            if (node % 2 == 0) {

                if (calArr[node / 2] != 0) {
                    calArr[node / 2] = Math.min(calArr[node / 2], calArr[node] + 1);
                } else {
                    calArr[node / 2] = calArr[node] + 1;
                }
                q.offer(node / 2);
            }
            
            if (node > 1) {

                if (calArr[node - 1] != 0) {
                    calArr[node - 1] = Math.min(calArr[node - 1], calArr[node] + 1);
                } else {
                    calArr[node - 1] = calArr[node] + 1;
                }
                q.offer(node - 1);
            }

            if (node == 1) break;
        }
    }
}
