package lection4_DP2.divisionA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Task26 {
    static BigInteger[][] dp;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        dp = new BigInteger[N][M];
        for(int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                dp[i][j] = new BigInteger("0");
            }
        }
        dp[0][0] = new BigInteger("1");
        int i = 0, j = 0;
        while (i < N && j < M){
            int di = i, dj = j;
            while (dj < M && di >= 0){
                possibleStep(di--,dj++);
            }
             if(i == N-1){
                 j++;
             } else {
                 i++;
             }
        }
        System.out.println(dp[N-1][M-1]);
    }
    public static void possibleStep(int i, int j){
        if(j-1 >= 0 && i - 2 >= 0) dp[i][j] = dp[i][j].add(dp[i-2][j-1]);
        if(j+1 < M && i - 2 >= 0)  dp[i][j] = dp[i][j].add(dp[i-2][j+1]);
        if(j-2 >= 0 && i - 1 >= 0)  dp[i][j] = dp[i][j].add(dp[i-1][j-2]);
        if(j-2 >= 0 && i + 1 < N)  dp[i][j] = dp[i][j].add(dp[i+1][j-2]);
    }
}
