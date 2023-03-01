package lection4_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task27 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        long[][] arr = new long[N][M];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Long.parseLong(s[j]);
            }
        }

        long[][] dp = new long[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (i == 1 && j == 1) dp[i][j] = arr[i - 1][j - 1];
                else {
                    dp[i][j] = arr[i - 1][j - 1] + Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[N][M]);
        System.out.println(findPath(dp, N, M, arr));
    }

    public static String findPath(long[][] dp, int N, int M, long[][] arr) {
        StringBuilder sb = new StringBuilder();
        int i = N, j = M;
        while (i != 1 || j != 1) {
            if (dp[i][j] - arr[i - 1][j - 1] == dp[i - 1][j]) {
                sb.append("D ");
                i--;
            } else {
                sb.append("R ");
                j--;
            }
        }
        String res = sb.reverse().toString();
        res = res.replaceFirst(" ","");
        return res;
    }
}
