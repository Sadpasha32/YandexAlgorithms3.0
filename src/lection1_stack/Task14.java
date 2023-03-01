package lection1_stack;

import java.util.Scanner;
import java.util.Stack;

public class Task14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int prevVal = 0;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x == prevVal + 1) {
                prevVal = x;
                while (!stack.isEmpty() && stack.peek() == prevVal + 1) {
                    stack.pop();
                    prevVal++;
                }
            } else{
                stack.push(x);
            }
        }
        System.out.println(stack.isEmpty() ? "YES" : "NO");
    }

}
