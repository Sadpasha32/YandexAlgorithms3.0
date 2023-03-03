import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int countOf0 = 0;
            int res = 0;
            for (String str : s) {
                if (str.equals("0")) countOf0++;
            }
            Stack<Integer> bonus = new Stack<>();
            for (String str : s) {
                if (str.equals("0")) {
                    countOf0--;
                    if(!bonus.isEmpty()) res += bonus.pop();
                } else {
                    if (bonus.size() == countOf0) {
                        if (!bonus.isEmpty() && bonus.peek() < Integer.parseInt(str)) {
                            bonus.pop();
                            bonus.push(Integer.parseInt(str));
                        }
                    } else {
                        if (!bonus.isEmpty() && bonus.peek() < Integer.parseInt(str)) {
                            int x = bonus.pop();
                            bonus.push(Integer.parseInt(str));
                            bonus.push(x);
                        } else {
                            bonus.push(Integer.parseInt(str));
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}
