package prj_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class P1017_DFS {
    
    static int[] oddNums;
    static int[] evenNums;
    
    static ArrayList<ArrayList<Integer>> adj;
    
    static int[] oddToEven;
    static int[] evenToOdd;
    
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Integer> result = new ArrayList<Integer>();
        
        int T = Integer.parseInt(br.readLine()); // 첫 번째 줄, 리스트의 크기 N
        String secondLine = br.readLine();
        
        for (int tc = 0; tc < T - 1; tc++) { // 첫째 숫자와 쌍을 이루어 줌.. 테스트 개수
            st = new StringTokenizer(secondLine); // 두 번째 줄, 리스트의 숫자 나열
            int firstNumber = Integer.parseInt(st.nextToken()); // 첫 번째 숫자
            
            int pairOfFirstNumber = 0;
            ArrayList<Integer> arrayOfNumbers = new ArrayList<Integer>();   // 첫 번째 숫자를 제외한 숫자들을 담을 array
            
            for (int i = 0; i < T - 1; i++) {
                if (i == tc) {
                    pairOfFirstNumber = Integer.parseInt(st.nextToken());
                    continue;
                }
                arrayOfNumbers.add(Integer.parseInt(st.nextToken())); // 이후 숫자들을 array에 삽입
            }
            
            if (!isPrime(firstNumber + pairOfFirstNumber)) continue;
            
            oddNums = getOdd(arrayOfNumbers);
            evenNums = getEven(arrayOfNumbers);
            adj = getAdj(oddNums, evenNums);
            
            oddToEven = new int[oddNums.length];
            evenToOdd = new int[evenNums.length];
            
            visited = new boolean[oddNums.length];
            
            Arrays.fill(oddToEven, -1);
            Arrays.fill(evenToOdd, -1);
            
            int match = 0;
            
            for (int i = 0; i < oddNums.length; i++) {
                
                if (oddToEven[i] == -1) {
                    Arrays.fill(visited, false);
                    if (dfs(i)) match++;
                }
                
            }
            
            if (match == oddNums.length) result.add(pairOfFirstNumber);
        }
        
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int resultN : result) {
                System.out.print(resultN + " ");
            }
        }
    }
    
    static boolean dfs(int a) {
        visited[a] = true;
        
        for (int b : adj.get(a)) {
            if (evenToOdd[b] == -1 || !visited[evenToOdd[b]] && dfs(evenToOdd[b])) {
                oddToEven[a] = b;
                evenToOdd[b] = a;
                return true;
            }
        }
        return false;
    }
    
    static int[] getEven(ArrayList<Integer> arrayOfNumbers) {
       int[] evenNumArray = new int[arrayOfNumbers.size()];
       int i = 0;
        
        for (int num : arrayOfNumbers) {
            if (num%2 == 0) {
                evenNumArray[i] = num;
                i++;
            }
        }
        
        return evenNumArray;
    }
    
    static int[] getOdd(ArrayList<Integer> arrayOfNumbers) {
        int[] oddNumArray = new int[arrayOfNumbers.size()];
        int i = 0;
        
        for (int num : arrayOfNumbers) {
            if (num%2 != 0) {
                oddNumArray[i] = num;
                i++;
            }
        }
        
        return oddNumArray;
    }
    
    static ArrayList<ArrayList<Integer>> getAdj(int[] oddNums, int[] evenNums) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < oddNums.length; i++) {
            adj.add(new ArrayList<Integer>());
            
            for (int j = 0; j < evenNums.length; j++) {
                if (isPrime(oddNums[i] + evenNums[j])) {
                    adj.get(i).add(j);
                }
            }
        }
        
        return adj;
    }
    
    static boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2) return true;
        
        double m = Math.sqrt(n);
        
        for (int i = 2; i < m+1; i++) {
           if (n%i == 0) {
               return false; 
           }
        }
        
        return true;
    }

// 복습 필수...
}
