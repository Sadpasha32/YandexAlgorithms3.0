package first_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i ++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        long res = 0;
        for(int i = 0; i < N; i++){
            if(i == 0 && N > 1) res += Math.min(arr[i],arr[i+1]);
            else if(i > 1){
                res += Math.min(arr[i-1],arr[i]);
            }
        }
        System.out.println(res);
    }
}
