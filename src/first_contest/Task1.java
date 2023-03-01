package first_contest;

import java.util.Scanner;
import java.util.TreeMap;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Character,Integer> dic = new TreeMap<>();
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if(ch != ' ' && ch != '\n'){
                    if(dic.containsKey(ch)){
                        dic.put(ch,dic.get(ch) + 1);
                    } else {
                        dic.put(ch,1);
                    }
                }
            }
        }
        int maxCount = -1;
        for(Character ch: dic.keySet()){
            if(dic.get(ch) > maxCount){
                maxCount = dic.get(ch);
            }
        }
        for(int i = maxCount; i != 0; i--){
            for(Character ch: dic.keySet()){
                if(dic.get(ch) >= i){
                    System.out.print("#");
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for(Character ch: dic.keySet()){
            System.out.print(ch);
        }
    }
}
