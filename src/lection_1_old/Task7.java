package lection_1_old;

import java.util.Scanner;

public class Task7 {
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int M = sc.nextInt();
        recursionRes(N,K,M);
        System.out.println(res);
    }
    public static void recursionRes(int N, int K, int M){
        if(N < K || M > K) return;
        res += N/K*(K/M);
        recursionRes((K%M)*(N/K) + N%K,K,M);
    }
}
