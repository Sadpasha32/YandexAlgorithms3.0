package lection3_DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task25 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        int[] dp = new int[N];
        dp[0] = arr[1]-arr[0];
        dp[1] = arr[1]-arr[0];
        for(int i = 2; i < N; i++){
            dp[i] = Math.min(arr[i]-arr[i-1] + dp[i-1], dp[i-2] + arr[i]-arr[i-1]);
        }
        System.out.println(dp[N-1]);
    }
}
