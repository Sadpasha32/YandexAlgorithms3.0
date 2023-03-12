package lection3_DP1.divisonA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task22 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] dp = new int[N];
        int[] prev = new int[N];
        dp[0] = 1;
        prev[0] = -1;
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        for(int i = 1; i < N; i++){
            int maxLen = -1;
            int prevInd = -1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && maxLen < dp[j] + 1){
                    maxLen = dp[j] + 1;
                    prevInd = j;
                }
            }
            dp[i] = maxLen;
            prev[i] = prevInd;
        }
        int indexMax = -1;
        int maxVal = -1;
        for(int i = 0; i < N; i++){
            if(dp[i] > maxVal){
                maxVal = dp[i];
                indexMax = i;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(arr[indexMax]);
        int prevInd = indexMax;
        while (prev[prevInd] != -1){
            res.add(arr[prev[prevInd]]);
            prevInd = prev[prevInd];
        }
        for(int i = res.size()-1; i >= 0; i--){
            System.out.print(res.get(i) +" ");
        }
    }
}
