package lection_1_old;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int countA = sc.nextInt();
        int countB = sc.nextInt();
        int[] validRangeA = new int[]{1+(a+1)*(countA-1),1+(a+1)*(countA-1) + 2*a};
        int[] validRangeB = new int[]{1+(b+1)*(countB-1),1+(b+1)*(countB-1) + 2*b};
        if(validRangeB[0] > validRangeA[1] || validRangeA[0] > validRangeB[1]) System.out.println(-1);
        else {
            int resNach = Math.max(validRangeA[0],validRangeB[0]);
            int resCon = Math.min(validRangeA[1],validRangeB[1]);
            System.out.println(resNach + " " + resCon);
        }
    }
}
