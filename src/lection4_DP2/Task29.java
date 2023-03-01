package lection4_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Task29 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N];
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }
        long[][] dp = new long[N + 1][N + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(cost[i - 1] + dp[i - 1][j], dp[i - 1][j + 1]);
                } else {
                    if (cost[i - 1] > 100) {
                        if (j != N) {
                            dp[i][j] = Math.min(dp[i - 1][j - 1] + cost[i - 1], dp[i - 1][j + 1]);
                        } else {
                            dp[i][j] = dp[i - 1][j - 1] + cost[i - 1];
                        }
                    } else {
                        if (j != N) {
                            dp[i][j] = Math.min(dp[i - 1][j] + cost[i - 1], dp[i - 1][j + 1]);
                        } else {
                            dp[i][j] = dp[i - 1][j] + cost[i - 1];
                        }
                    }
                }
            }
        }
        long res = Integer.MAX_VALUE;
        ArrayList<Integer> dayOfCoupon = new ArrayList<>();
        int K1 = -1, K2 = 0;
        for (int i = 0; i <= N; i++) {
            if (res >= dp[N][i]) {
                res = dp[N][i];
                K1 = i;
            }
            res = Math.min(res, dp[N][i]);
        }
        int j = K1;
        int i = N;
        while (i - 1 >= 0 && j < N) {
            if (dp[i - 1][j + 1] == dp[i][j]) {
                dayOfCoupon.add(i);
                i--;
                j++;
                K2++;
            } else if (dp[i - 1][j] + cost[i-1] == dp[i][j]) {
                i--;
            } else if(j-1 >= 0 && dp[i - 1][j-1] + cost[i-1] == dp[i][j]){
                i--;
                j--;
            }
        }
        Collections.sort(dayOfCoupon);
        System.out.println(res);
        System.out.println(K1 + " " + K2);
        for (Integer val : dayOfCoupon) {
            System.out.println(val);
        }
    }
}
