package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1005 {

	    static int n;   // 노드 갯수
	    static int k;   // 간선 갯수
	    static int[] d;
		static StringBuilder sb = new StringBuilder();
	 
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	 
	        int tc = Integer.parseInt(br.readLine());
	 
	        for(int t=0; t<tc; t++) {
	            st = new StringTokenizer(br.readLine(), " ");
	            n = Integer.parseInt(st.nextToken()); // 건물 개수
	            k = Integer.parseInt(st.nextToken()); // 규칙 개수
	            d = new int[n+1];					  // 건물+1 크기의 int[] d : 건물개수만큼 건설소요시간 저장할것임. 단 0번째 안씀.
	 
	            List<List<Integer>> list = new ArrayList<List<Integer>>();
	            for(int i=0; i<n+1; i++)
	                list.add(new ArrayList<Integer>()); // 건물+1 개 만큼 ArrayList 만들어.. 즉 0번부터 (건물개수)번까지 ArrayList 생성
	 
	            int[] indegree = new int[n+1]; // 건물+1 크기의 int[] d
	 
	            st = new StringTokenizer(br.readLine(), " ");
	            for(int i=1; i<=n; i++)
	                d[i] = Integer.parseInt(st.nextToken()); // d에는 건설소요시간이 들어간다. 단, 0번째 안씀.
	    
	            for(int i=0; i<k; i++) { 									// 규칙 개수만큼 for문 실행
	                st = new StringTokenizer(br.readLine(), " ");			
	    
	                // v1 -> v2
	                int v1 = Integer.parseInt(st.nextToken());				// 건설규칙 읽을 때마다 v1, v2 초기화
	                int v2 = Integer.parseInt(st.nextToken());
	    
	                list.get(v1).add(v2);									// 1번째 건물이라면, 
	                indegree[v2]++;
	            }
	 
	            int w = Integer.parseInt(br.readLine());
	    
	            topologicalSort(indegree, list, w);    
	        }
	        
	        System.out.println(sb);
	    }
	 
	    static void topologicalSort(int[] indegree, List<List<Integer>> list, int w) {
	        Queue<Integer> q = new LinkedList<Integer>();
	        int[] result = new int[n+1];
	 
	        // 건물의 소요 기본 소요시간은 d[i]
	        // 선행조건이 없는, 가장 처음에 지을 수 있는 건물을 q에 넣는다
	        for(int i=1; i<=n; i++) {
	            result[i] = d[i];
	 
	            if(indegree[i] == 0)
	                q.offer(i);
	            System.out.println("result[" + i + "] : " + result[i]);
	        }
	        // result는 건물 소요시간을 담고 있다. 여기에 이전 소요시간을 더해주는 것...
	 
	        // 건물의 총 소요시간 = 이전까지의 소요시간 + 현재 건물 소요시간
	        // Max 해주는 이유는 이 테크가 다 올라야 현재 건물을 지을 수 있기 때문
	        while(!q.isEmpty()) {
	        	// 현재 node에 대해 놀겠다....
	            int node = q.poll();
	            System.out.println("\n\n\n===================================================\nQueue가 비었는가? : " + q.isEmpty() + "  /  현재 node는 무엇인가 ? : " + node);
	            
	            // 현재 node가 연결되는 건물만큼 돌린다...
	            for(Integer i : list.get(node)) {
	            	System.out.println("\n\n현재 " + node + "node에서 연결된 건물 중 " + i + "건물에 대해 시간 계산 중...");
	            	// 전자 : 현재건물까지의 소요시간, 현재
	            	System.out.println("해당 건물 소요시간, 혹은 기존 소요시간 : " + result[i]);
	                result[i] = Math.max(result[i], result[node] + d[i]);
	                System.out.println("최신화 소요시간 : " + result[i]);
	                // 결과 냈으니... 연결된 개수 빼 준다...
	                System.out.println("기존 연결 indegree : " + indegree[i]);
	                indegree[i]--;
	                System.out.println("최신화 연결 indegree : " + indegree[i]);
	                // 현재 node가 연결된 건물을 다 돌렸으면 
	                if(indegree[i] == 0) {
	                    q.offer(i);
	                    System.out.println("Queue에 추가되었다 : " + i);
	                }
	            }
	        }
	 
	        // 승리 타워까지의 건설시간이 답
	        sb.append(result[w]).append("\n");
	    }
	}
