package lection3_DP1.divisonA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Task24 {
    static int startTime = 9*60*60;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[32400+1];
        HashMap<Integer,Integer> dictionary = new HashMap<>();
        for(int i = 0; i < N; i++){
            String[] s = br.readLine().split(" ");
            dictionary.put(convertTime(s[0]),Integer.parseInt(s[1]));
        }
        int currentTime = 0;
        for(int i = 0; i <= 14400; i++){
            if(dictionary.containsKey(i)){
                currentTime = dictionary.get(i);
            }
            if(i > 0) dp[i] = Math.max(dp[i-1],dp[i]);
            if(i + currentTime <= 14400) dp[i + currentTime] = Math.max(dp[i+currentTime], dp[i] + 1);
        }
        dp[17999] = dp[14400];
        for(int i = 14401; i <= 17999; i++){
            if(dictionary.containsKey(i)){
                currentTime = dictionary.get(i);
            }
        }
        for(int i =  18000; i <= 32400; i++){
            if(dictionary.containsKey(i)){
                currentTime = dictionary.get(i);
            }
            dp[i] = Math.max(dp[i-1],dp[i]);
            if(i + currentTime <= 32400) dp[i + currentTime] = Math.max(dp[i+currentTime], dp[i] + 1);
        }
        System.out.println(dp[32400]);
    }
    public static int convertTime(String s){
        String[] str = s.split(":");
        return Integer.parseInt(str[0])*60*60 + Integer.parseInt(str[1])*60 + Integer.parseInt(str[2]) - startTime;
    }
}
