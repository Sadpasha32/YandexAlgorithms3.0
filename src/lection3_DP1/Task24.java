package lection3_DP1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task24 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 3];
        int[] B = new int[N + 3];
        int[] C = new int[N + 3];
        long[] dp = new long[N + 3];
        A[0] = A[1] = A[2] = Integer.MAX_VALUE;
        B[0] = B[1] = B[2] = Integer.MAX_VALUE;
        C[0] = C[1] = C[2] = Integer.MAX_VALUE;
        String[] s;
        for (int i = 3; i < N + 3; i++) {
            s = br.readLine().split(" ");
            A[i] = Integer.parseInt(s[0]);
            B[i] = Integer.parseInt(s[1]);
            C[i] = Integer.parseInt(s[2]);
        }
        dp[0] = dp[1] = dp[2] = 0;
        for (int i = 3; i < N + 3; i++) {
            dp[i] = Math.min(A[i] + dp[i - 1], B[i - 1] + dp[i - 2]);
            dp[i] = Math.min(dp[i], C[i - 2] + dp[i - 3]);
        }
        System.out.println(dp[N + 2]);
    }
}
