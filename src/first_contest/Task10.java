package first_contest;

import java.util.Scanner;
import java.util.TreeMap;

public class Task10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        TreeMap<Character,Long> dictionary = new TreeMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(dictionary.containsKey(ch)){
                dictionary.put(ch,dictionary.get(ch) + (long) (i + 1) *(n - i));
            } else {
                dictionary.put(ch, ((long) (i + 1) *(n - i)));
            }
        }
        for(Character ch: dictionary.keySet()){
            System.out.println(ch+": " + dictionary.get(ch));
        }
    }
}
