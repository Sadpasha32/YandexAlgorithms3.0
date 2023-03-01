package lection3_DP1;

import java.util.Scanner;

public class Task22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long[] dp = new long[N + K-1];
        for(int i = 0; i < K-1; i++){
            dp[i] = 0;
        }
        dp[K-1] = 1;
        for (int i = K; i < N+K-1; i++) {
            for (int j = 1; j <= K; j++) {
                dp[i] += dp[i - j];
            }
        }
        System.out.println(dp[N+K-2]);
    }
}
