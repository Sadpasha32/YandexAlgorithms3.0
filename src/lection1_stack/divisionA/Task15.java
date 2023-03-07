package lection1_stack.divisionA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;

public class Task15 {
    static final String ALFAVIT = "absdefghijklmnopqrstuvwxyz></";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder copyS = new StringBuilder();
        int flagTotalRes = 0;
        for (int i = 0; i < s.length(); i++) {
            copyS.append(s.charAt(i));
        }
        for (int j = 0; j < s.length() && flagTotalRes == 0; j++) {
            if (j > 0) s.replace(j - 1, j, String.valueOf(copyS.charAt(j - 1)));
            for (int k = 0; k < ALFAVIT.length() && flagTotalRes == 0; k++) {
                Stack<String> stack = new Stack<>();
                s.replace(j, j + 1, String.valueOf(ALFAVIT.charAt(k)));
                StringBuilder sb = new StringBuilder();
                int falgRes = 0;
                int i = 0;
                while (i < s.length()) {
                    if (s.charAt(i) == '<') i++;
                    else {
                        falgRes = 1;
                        break;
                    }
                    if (s.charAt(i) == '/') {
                        i++;
                        sb = new StringBuilder();
                        while (i < s.length() && s.charAt(i) != '>') {
                            if(s.charAt(i) == '<' || s.charAt(i) == '|'){
                                falgRes = 1;
                                break;
                            }
                            sb.append(s.charAt(i));
                            i++;
                        }
                        if(stack.isEmpty() || sb.length() == 0){
                            falgRes = 1;
                            break;
                        }
                        String top = stack.pop();
                        if (!Objects.equals(top, sb.toString())) {
                            falgRes = 1;
                            break;
                        }
                        i++;
                    } else {
                        sb = new StringBuilder();
                        while (i < s.length() && s.charAt(i) != '>') {
                            if(s.charAt(i) == '<' || s.charAt(i) == '|'){
                                falgRes = 1;
                                break;
                            }
                            sb.append(s.charAt(i));
                            i++;
                        }
                        if(sb.length() == 0){
                            falgRes = 1;
                            break;
                        }
                        stack.push(sb.toString());
                        i++;
                    }
                }
                if (falgRes == 0 && stack.isEmpty()) {

                    flagTotalRes = 1;
                    System.out.println(s);
                }
            }
        }
    }
}
