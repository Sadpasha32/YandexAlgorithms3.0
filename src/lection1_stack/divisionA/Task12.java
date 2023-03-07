package lection1_stack.divisionA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Task12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int flag = 0;
        int flagRes = 0;
        Stack<Character> checkScob = new Stack<>();
        int i = 0;
       while(i < s.length()) {
            char c = s.charAt(i);
            if(c == ' '){
                i++;
            } else {
                if (c == '(' || c == ')') {
                    if (c == '(') {
                        checkScob.push('(');
                    } else {
                        if (!checkScob.isEmpty()) checkScob.pop();
                        else {
                            flagRes = 1;
                            break;
                        }
                    }
                } else if (flag == 0) {
                    if (c == '+' || c == '-' || c == '*' || c > 57) {
                        flagRes = 1;
                        break;
                    } else {
                        while(i+1 < s.length() && s.charAt(i+1) != '*' && s.charAt(i+1) != '-' && s.charAt(i+1) != '+' && s.charAt(i+1) != ' ' && s.charAt(i+1) != '(' && s.charAt(i+1) != ')'){
                            i++;
                        }
                        flag = 1;
                    }
                } else {
                    if (c != '+' && c != '-' && c != '*') {
                        flagRes = 1;
                        break;
                    } else {
                        flag = 0;
                    }
                }
                i++;
            }
        }
        if (!checkScob.isEmpty()) {
            flagRes = 1;
        }
        if(flagRes == 1 || flag == 0) System.out.println("WRONG");
        else {
            String[] sarr = infToPref(s).split(" ");
            Stack<Integer> stack = new Stack<>();
            for (String value : sarr) {
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
    public static String infToPref(String s){
        Stack<Character> res = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char c;
        int i = 0;
        while(i < s.length()){
            c = s.charAt(i);
            if(c == '+' || c == '-' || c =='*'){
                if(c == '+'){
                    while (!res.isEmpty() && (res.peek() == '-' || res.peek() == '*')){
                        sb.append(res.pop() + " ");
                    }
                    res.push(c);
                } else if(c == '-'){
                    while (!res.isEmpty() && (res.peek() == '+' || res.peek() == '*')){
                        sb.append(res.pop()+ " ");
                    }
                    res.push(c);
                } else {
                    while (!res.isEmpty() && res.peek() == '*'){
                        sb.append(res.pop()+" ");
                    }
                    res.push(c);
                }
            } else if(c == '(' || c == ')'){
                if(c == '(') res.push('(');
                else {
                    while (res.peek() != '('){
                        sb.append(res.pop() + " ");
                    }
                    res.pop();
                }
            } else if(c != ' '){
                sb.append(c);
                while(i+1 < s.length() && s.charAt(i+1) != '*' && s.charAt(i+1) != '-' && s.charAt(i+1) != '+' && s.charAt(i+1) != ' ' && s.charAt(i+1) != '(' && s.charAt(i+1) != ')'){
                    i++;
                    sb.append(s.charAt(i));
                }
                sb.append(" ");
            }
            i++;
        }
        while (!res.isEmpty()){
            sb.append(res.pop() + " ");
        }
        return sb.toString();
    }
}
