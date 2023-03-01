package first_contest;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int[][] arr1 = new int[N+1][M+1];
        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < M+1; j++){
                if(i == 0){
                    arr1[i][j] = 0;
                }
                else if(j == 0) arr1[i][j] = 0;
                else{
                    arr1[i][j] = sc.nextInt();
                    if(j != 1) arr1[i][j] += arr1[i][j-1];
                }
            }
        }
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < M+1; j++){
                arr1[i][j] += arr1[i-1][j];
            }
        }
        int x1,y1,x2,y2;
        for(int i = 0; i < K; i++){
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            long res = arr1[x2][y2]-arr1[x2][y1-1]-arr1[x1-1][y2] + arr1[x1-1][y1-1];
            System.out.println(res);
        }
    }
}
