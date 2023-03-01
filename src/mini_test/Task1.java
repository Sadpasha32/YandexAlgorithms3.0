package mini_test;

import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long min_rez = 10000000000l;
        long max_rez = -1;
        int flag = 0;
        long curr = -1, prev = -1;
        for(int i = 0; i < n; i++){
            curr = sc.nextInt();
            if(prev != -1){
                if(prev > curr){
                    System.out.println("-1");
                    flag = 1;
                    break;
                }
            }
            min_rez = Math.min(curr,min_rez);
            max_rez = Math.max(curr,max_rez);
            prev = curr;
        }
        if(flag == 0) System.out.println(max_rez-min_rez);
    }
}
