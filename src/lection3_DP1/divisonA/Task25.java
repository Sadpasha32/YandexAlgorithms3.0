package lection3_DP1.divisonA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task25 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int a = Integer.parseInt(s[1]);
        int b = Integer.parseInt(s[2]);
        int[] dp = new int[n+1];
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            int minVal = Integer.MAX_VALUE;
            for(int k = 1; k < i; k++){
                int x = Math.max(dp[k] + a, dp[i-k]+b);
                minVal = Math.min(x,minVal);
            }
            dp[i] = minVal;
        }
        System.out.println(dp[n]);
    }
}
