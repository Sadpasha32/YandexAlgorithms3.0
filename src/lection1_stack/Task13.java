package lection1_stack;

import java.util.Scanner;
import java.util.Stack;

public class Task13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        for (String value : s) {
            if (value.equals("+")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val1 + val2);
            } else if (value.equals("-")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 - val1);
            } else if (value.equals("*")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val1 * val2);
            } else {
                stack.push(Integer.parseInt(value));
            }
        }
        System.out.println(stack.pop());
    }
}
