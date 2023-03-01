package lection4_DP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class Task30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().replace(" ", ""));
        String[] s1 = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine().replace(" ", ""));
        String[] s2 = br.readLine().split(" ");
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (s1[i - 1].equals(s2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        ArrayList<String> res = new ArrayList<>();
        int i = N, j = M;
        while (dp[i][j] != 0 && i != 0 && j != 0) {
            if (dp[i-1][j] == dp[i][j]) {
                i--;
            } else if (dp[i][j-1] == dp[i][j]) {
                j--;
            } else if (dp[i - 1][j - 1] == dp[i][j] - 1) {
                res.add(s1[i-1]);
                i--;
                j--;
            }
        }
        for(int k = res.size()-1; k >= 0; k--){
            System.out.print(res.get(k) + " ");
        }
    }
}
