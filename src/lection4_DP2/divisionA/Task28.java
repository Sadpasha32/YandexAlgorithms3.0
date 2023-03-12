package lection4_DP2.divisionA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Task28 {
    static HashMap<Character, ArrayList<Character>> rules;
    static HashMap<Pair, Integer> memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        rules = new HashMap<>();
        String s = br.readLine();
        rules.put('N', fillRules(s));
        s = br.readLine();
        rules.put('S', fillRules(s));
        s = br.readLine();
        rules.put('W', fillRules(s));
        s = br.readLine();
        rules.put('E', fillRules(s));
        s = br.readLine();
        rules.put('U', fillRules(s));
        s = br.readLine();
        rules.put('D', fillRules(s));
        s = br.readLine();
        char start = s.split(" ")[0].charAt(0);
        int n = Integer.parseInt(s.split(" ")[1]);
        memo = new HashMap<>();
        System.out.println(dp(start,n));
    }

    public static ArrayList<Character> fillRules(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            arr.add(s.charAt(i));
        }
        return arr;
    }

    public static int dp(char start, int i) {
        int res = 0;
        if (i == 1) {
            res = 1;
            return res;
        } else {
            res += 1;
            Pair pr;
            for (Character ch : rules.get(start)) {
                pr = new Pair(ch,i-1);
                if(!memo.containsKey(pr)){
                    memo.put(pr,dp(ch,i-1));
                }
                res += memo.get(pr);
            }
            return res;
        }
    }
}
class Pair{
    char ch;
    int n;

    public Pair(char ch, int n) {
        this.ch = ch;
        this.n = n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return ch == pair.ch && n == pair.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ch, n);
    }
}
