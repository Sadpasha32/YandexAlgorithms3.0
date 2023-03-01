package lection_2_old;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int prevVal, currVal;
        prevVal = sc.nextInt();
        int flag = 0;
        while(sc.hasNextInt()){
            currVal = sc.nextInt();
            if(currVal <= prevVal){
                System.out.println("NO");
                flag = 1;
                break;
            }
            prevVal = currVal;
        }
        if(flag == 0) System.out.println("YES");
    }
}
