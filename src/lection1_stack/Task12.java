package lection1_stack;

import java.util.Scanner;
import java.util.Stack;

public class Task12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        String res = "yes";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            } else if(ch == ')'){
                if(!stack.empty() && stack.peek() == '(') stack.pop();
                else{
                    res = "no";
                    break;
                }
            } else if(ch == ']'){
                if(!stack.empty() && stack.peek() == '[') stack.pop();
                else{
                    res = "no";
                    break;
                }
            } else if(ch == '}'){
                if(!stack.empty() && stack.peek() == '{') stack.pop();
                else{
                    res = "no";
                    break;
                }
            }
        }
        if(!stack.empty()) res = "no";
        System.out.println(res);
    }
}
