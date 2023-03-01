package lection_1_old;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int troom = sc.nextInt();
        int tcond = sc.nextInt();
        String mode = sc.next();
        if(mode.equals("freeze")){
            System.out.println(Math.min(tcond,troom));
        } else if(mode.equals("heat")){
            System.out.println(Math.max(tcond,troom));
        } else if(mode.equals("auto")) {
            System.out.println(tcond);
        } else {
            System.out.println(troom);
        }
    }
}
