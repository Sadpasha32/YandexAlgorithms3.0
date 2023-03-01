package first_contest;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A, B, C;
        String[] s = sc.nextLine().split(":");
        A = Long.parseLong(s[0]) * 60 * 60 + Long.parseLong(s[1]) * 60 + Long.parseLong(s[2]);
        s = sc.nextLine().split(":");
        B = Long.parseLong(s[0]) * 60 * 60 + Long.parseLong(s[1]) * 60 + Long.parseLong(s[2]);
        s = sc.nextLine().split(":");
        C = Long.parseLong(s[0]) * 60 * 60 + Long.parseLong(s[1]) * 60 + Long.parseLong(s[2]);
        if(A > C) C += 24*60*60;
        long secWay = Math.round((C-A)/2.);
        B += secWay;
        if(B > 24*60*60) B = B - 24*60*60;
        int hours = (int) (B/(60*60));
        int minutes = (int) ((B - hours*60*60)/60);
        int secunds = (int) (B-(hours*60*60+minutes*60));
        String h = hours/10 == 0 ? "0"+hours: hours+"";
        String m = minutes/10 == 0 ? "0"+minutes: minutes+"";
        String se = secunds/10 == 0 ? "0"+secunds: secunds+"";
        System.out.println(h + ":" + m + ":" + se);
    }
}
