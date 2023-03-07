package lection1_stack.divisionA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Task11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int k = Integer.parseInt(s[0]);
            Stack<Double> stack = new Stack<>();
            double prevVal = -1;
            double x;
            int res = 1;
            for (int j = 1; j <= k; j++) {
                x = Double.parseDouble(s[j]);
                if (stack.isEmpty()) {
                    stack.push(x);
                } else {
                    if (stack.peek() < x) {
                        while (!stack.isEmpty() && stack.peek() < x) {
                            if(prevVal <= stack.peek()) prevVal = stack.pop();
                            else{
                                res = 0;
                                break;
                            }
                        }
                    }
                    stack.push(x);
                }
            }
            while (!stack.isEmpty()) {
                if(stack.peek() >= prevVal) prevVal = stack.pop();
                else{
                    res = 0;
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
