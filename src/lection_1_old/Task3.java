package lection_1_old;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = formNumber(sc.nextLine());
        String number1 = formNumber(sc.nextLine());
        String number2 = formNumber(sc.nextLine());
        String number3 = formNumber(sc.nextLine());
        if(number.equals(number1)) System.out.println("YES");
        else System.out.println("NO");
        if(number.equals(number2)) System.out.println("YES");
        else System.out.println("NO");
        if(number.equals(number3)) System.out.println("YES");
        else System.out.println("NO");
    }
    public static String formNumber(String number){
        number = number.replace("-","");
        number = number.replace("(","");
        number = number.replace(")","");
        if(number.charAt(0) == '+') number = number.substring(1);
        if(number.length() == 7){
            number = "495" + number;
        } else if(number.length() == 11) {
            number = number.substring(1);
        }
        return number;
    }
}
