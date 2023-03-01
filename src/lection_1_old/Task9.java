package lection_1_old;

import java.util.Arrays;
import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        int E = sc.nextInt();
        int[] arr = new int[]{A,B,C};
        Arrays.sort(arr);
        if(Math.min(D,E) >= arr[0] && Math.max(D,E) >= arr[1]) System.out.println("YES");
        else System.out.println("NO");
    }
}
