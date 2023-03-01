package lection3_DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task21 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];
        if (n == 1) System.out.println(2);
        else if (n == 2) System.out.println(4);
        else {
            dp[0] = 1;
            dp[1] = 2;
            dp[2] = 4;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
            System.out.println(dp[n]);
        }
    }
}
