package prj_baekjoon;

public class Memorization {
    
    private static Integer[] memories;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        memories = new Integer[46];
        
        long start = System.currentTimeMillis();
        int answer1 = fibonacciNumber(45);
        long end = System.currentTimeMillis();
        
        System.out.println("단순 피보나치 재귀메소드에 대한 실행 시간 : " + (end - start));
        System.out.println("정답 : " + answer1);
        
        long start2 = System.currentTimeMillis();
        int answer2 = mmr_fibonacciNumber(45);
        long end2 = System.currentTimeMillis();
        
        System.out.println("메모라이제이션 응용한 실행 시간 : " + (end2 - start2));
        System.out.println("정답 : " + answer2);
    }
    
    static int fibonacciNumber(int n) {
        if (n == 1 || n == 2) return 1;
        
        return fibonacciNumber(n-1) + fibonacciNumber(n-2);
    }
    
    static int mmr_fibonacciNumber(int n) {
        if (n == 1 || n == 2) return 1;
        
        if (memories[n] != null) {
            return memories[n];
        } else {
            memories[n] = mmr_fibonacciNumber(n-1) + mmr_fibonacciNumber(n-2);
            return memories[n];
        }
                
    }

}
