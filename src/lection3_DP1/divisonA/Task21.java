package lection3_DP1.divisonA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Task21 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        Arrays.fill(dp,1000001);
        ArrayList<Integer> correctThree = new ArrayList<>();
        int k = 1;
        int flag = 0;
        while (k*k*k <= N){
            correctThree.add(k*k*k);
            if(k*k*k == N) flag = 1;
            k++;
        }
        dp[0] = 0;
        if(flag == 0) {
            for (Integer integer : correctThree) {
                for (int j = integer; j <= N; j++) {
                    if (integer == j) {
                        dp[j] = 1;
                    } else {
                        dp[j] = Math.min(dp[j], dp[j - integer] + 1);
                    }
                }
            }
            System.out.println(dp[N]);
        } else {
            System.out.println(1);
        }
    }
}
