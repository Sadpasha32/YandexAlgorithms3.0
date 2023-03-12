package lection4_DP2.divisionA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task27 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int M = s1.length();
        int N = s2.length();
        int[][] dp = new int[N+1][M+1];
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= M; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 0;
                }
                else if(j == 0 && i > 0){
                    dp[i][j] = dp[i-1][j] + 1;
                } else if(i == 0 && j > 0){
                    dp[i][j] = dp[i][j-1] + 1;
                } else {
                    if(s2.charAt(i-1) == s1.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                    else {
                        dp[i][j] = Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1] + 1);
                    }
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
