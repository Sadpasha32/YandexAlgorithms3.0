package lection4_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task28 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]), M = Integer.parseInt(s[1]);
        int[][] dp = new int[N][M];
        dp[0][0] = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(j-1 >= 0 && i - 2 >= 0) dp[i][j] += dp[i-2][j-1];
                if(j-2 >= 0 && i - 1 >= 0) dp[i][j] += dp[i-1][j-2];
            }
        }
        System.out.println(dp[N-1][M-1]);
    }
}
