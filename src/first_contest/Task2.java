package first_contest;

import java.util.HashMap;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        HashMap<Character, Integer> dic = new HashMap<>();
        int l = 0,r = -1;
        int maxRes = 0;
        int n = s.length();
        if(k >= s.length()) System.out.println(s.length());
        else {
            int maxSame = -1;
            while (r < n && l < n) {
                while (r == -1 || (r - l + 1) - maxSame <= k) {
                    r++;
                    if (r == n) break;
                    if (dic.containsKey(s.charAt(r))) {
                        dic.put(s.charAt(r), dic.get(s.charAt(r)) + 1);
                    } else {
                        dic.put(s.charAt(r), 1);
                    }
                    maxSame = Math.max(maxSame,dic.get(s.charAt(r)));
                }
                if (r == n) {
                    if (s.charAt(l) == s.charAt(r - 1) || (r - l) - Math.max(dic.get(s.charAt(l)),dic.get(s.charAt(r-1))) <= k) maxRes = Math.max(maxRes, (r - l));
                    break;
                } else {
                    dic.put(s.charAt(r), dic.get(s.charAt(r)) - 1);
                    r--;
                    maxRes = Math.max(maxRes, (r - l + 1));
                }
                dic.put(s.charAt(l), dic.get(s.charAt(l)) - 1);
                l++;
            }
            System.out.println(maxRes);
        }
    }
}
