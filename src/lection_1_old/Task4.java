package lection_1_old;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if(c < 0) System.out.println("NO SOLUTION");
        else {
            if(a == 0){
                if(b == c*c) System.out.println("MANY SOLUTIONS");
                else System.out.println("NO SOLUTION");
            } else {
                if((c*c - b) % a == 0) System.out.println((c*c - b)/a);
                else System.out.println("NO SOLUTION");
            }
        }
    }
}
