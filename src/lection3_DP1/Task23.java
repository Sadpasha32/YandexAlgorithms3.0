package lection3_DP1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Task23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        dp[1] = 0;
        int[] prev = new int[N + 1];
        prev[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;
            if (i % 2 == 0) {
                if (dp[i / 2] + 1 < dp[i]) {
                    dp[i] = dp[i / 2] + 1;
                    prev[i] = i / 2;
                }
            }
            if (i % 3 == 0) {
                if (dp[i / 3] + 1 < dp[i]) {
                    dp[i] = dp[i / 3] + 1;
                    prev[i] = i / 3;
                }
            }
        }
        System.out.println(dp[N]);
        ArrayList<Integer> res = new ArrayList<>();
        res.add(N);
        int j = N;
        for (int i = 0; i < dp[N]; i++) {
            res.add(prev[j]);
            j = prev[j];
        }
        Collections.sort(res);
        for(Integer i: res){
            System.out.print(i + " ");
        }
    }
}
