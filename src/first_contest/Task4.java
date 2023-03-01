package first_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int partaB = Integer.parseInt(br.readLine());
        int mestoB = Integer.parseInt(br.readLine());
        int res1 = -1, res2 = -1;
        if(((partaB-1)*2 + mestoB + K) <= N){
            res1 = (partaB-1)*2 + mestoB + K;
        }
        if(((partaB-1)*2 + mestoB - K) > 0){
            res2 = (partaB-1)*2 + mestoB - K;
        }
        if(res1 == -1 && res2 == -1) {
            System.out.println(-1);
        }
        if(res1 != -1 && res2 != -1){
            if(partaB - (res2/2 + res2%2) >= ((res1/2 + res1%2) - partaB)){
                System.out.println((res1/2 + res1%2) + " " + (res1%2 == 0 ? 2 : 1));
            } else {
                System.out.println((res2/2 + res2%2) + " " + (res2%2 == 0 ? 2 : 1));
            }
        } else if(res1 != -1){
            System.out.println((res1/2 + res1%2) + " " + (res1%2 == 0 ? 2 : 1));
        } else if(res2 != -1) {
            System.out.println((res2/2 + res2%2) + " " + (res2%2 == 0 ? 2 : 1));
        }
    }
}
