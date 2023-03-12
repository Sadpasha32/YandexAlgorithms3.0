package lection3_DP1.divisonA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task23 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];
        dp[0] = 0;
        long totalSumUp = 0;
        long totalSumDown = 0;
        long inkrDown = 2;
        long addLayout = 1;
        for(int i = 1; i <= N; i++){
            if(i == 1){
                dp[i] = 1;
            } else if(i == 2){
                dp[i] = 5;
            } else {
                dp[i] = dp[i-1] + totalSumUp + totalSumDown + addLayout;
                if(i == 3) totalSumDown = 1;
                if(i == 4) totalSumDown = 2;
                if(i > 4){
                    totalSumDown += inkrDown;
                    if(i % 2 == 0){
                        inkrDown++;
                    }
                }

            }
            addLayout += 2;
            totalSumUp += i;
        }
        System.out.println(dp[N]);
    }
}
