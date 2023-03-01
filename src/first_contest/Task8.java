package first_contest;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int minX = Integer.MAX_VALUE,minY = Integer.MAX_VALUE,maxX = Integer.MIN_VALUE,maxY = Integer.MIN_VALUE;
        int x,y;
        for(int i = 0; i < K; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            if(x > maxX) maxX = x;
            if(x < minX) minX = x;
            if(y >maxY) maxY = y;
            if(y < minY) minY = y;
        }
        System.out.println(minX+" " + minY + " " + maxX + " " + maxY);
    }
}
