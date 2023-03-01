package lection_1_old;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        if(x*y*z <= 0) System.out.println("NO");
        else{
            if(x+y > z && y + z > x && x + z > y) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
