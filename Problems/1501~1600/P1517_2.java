package baekjoon3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1517_2 {

    static long swapCount = 0;
    static long[] sorted;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int n = Integer.parseInt(br.readLine());
        
        long[] arr = new long[n + 1];
        sorted = new long[n + 1];
 
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
 
        mergeSort(arr, 1, n);
        
        System.out.println(swapCount);
    }
 
    static void mergeSort(long[] arr, int start, int end) {
    	
        if(start < end) {
        	
            int mid = (start+end)/2;
            
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            
            merge(arr, start, mid, end);
        }
    }
 
    static void merge(long[] arr, int start, int mid, int end) {
    	
        int i = start;
        int j = mid + 1;
        int index = start;
 
        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j])
                sorted[index++] = arr[i++];
            else {
                sorted[index++] = arr[j++];
                swapCount += (mid + 1 - i);
            }
        }
 
        while(i <= mid) 
            sorted[index++] = arr[i++];
        
        while(j <= end)
            sorted[index++] = arr[j++];
 
        for(int k = start; k <= end; k++)
            arr[k] = sorted[k];
    }
}
