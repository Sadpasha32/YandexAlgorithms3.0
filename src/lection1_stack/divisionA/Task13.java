package lection1_stack.divisionA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Task13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.replace("!","1-");
        String[] sarr = infToPref(s).split(" ");
        Stack<Integer> stack = new Stack<>();
        for (String value : sarr) {
            if (value.equals("-")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 - val1);
            } else if (value.equals("&")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 & val1);
            } else if (value.equals("|")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val1 | val2);
            } else if (value.equals("^")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val1 ^ val2);
            } else {
                stack.push(Integer.parseInt(value));
            }
        }
        System.out.println(stack.pop());
    }

    public static String infToPref(String s) {
        Stack<Character> res = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '-' || c == '^' || c == '&' || c == '|') {
                if (c == '|') {
                    while (!res.isEmpty() && (res.peek() == '-' || res.peek() == '&' || res.peek() == '^')) {
                        sb.append(res.pop()).append(" ");
                    }
                    res.push(c);
                } else if (c == '^') {
                    while (!res.isEmpty() && (res.peek() == '-' || res.peek() == '&' || res.peek() == '|')) {
                        sb.append(res.pop()).append(" ");
                    }
                    res.push(c);
                } else if (c == '&') {
                    while (!res.isEmpty() && (res.peek() == '-' || res.peek() == '&')) {
                        sb.append(res.pop()).append(" ");
                    }
                    res.push(c);
                } else {
                    while (!res.isEmpty() && res.peek() == '-') {
                        sb.append(res.pop()).append(" ");
                    }
                    res.push(c);
                }
            } else if (c == '(' || c == ')') {
                if (c == '(') res.push('(');
                else {
                    while (res.peek() != '(') {
                        sb.append(res.pop()).append(" ");
                    }
                    res.pop();
                }
            } else if (c != ' ') {
                sb.append(c);
                sb.append(" ");
            }
        }
        while (!res.isEmpty()) {
            sb.append(res.pop()).append(" ");
        }
        return sb.toString();
    }
}
