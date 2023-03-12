package lection4_DP2.divisionA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task29 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int M = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);
        long[][] dp = new long[N][M];
        dp[0][0] = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(j == 0 || i == 0){
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] + dp[i-1][j-1];
                }
            }
        }
        System.out.println(dp[N-1][M-1]);
    }
}
