package lection1_stack.divisionA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Task14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long square = 0;
        int n = s.length-1;
        ArrayList<Squar> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(new Squar(i,Long.parseLong(s[i+1])));
        }
        Stack<Squar> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            if(stack.isEmpty()) stack.push(arr.get(i));
            else{
                if(stack.peek().height <= arr.get(i).height){
                    stack.push(arr.get(i));
                } else {
                    while(!stack.isEmpty() && stack.peek().height > arr.get(i).height){
                        stack.pop().rightMin = arr.get(i).index;
                    }
                    stack.push(arr.get(i));
                }
            }
        }
        while (!stack.isEmpty()){
            stack.pop().rightMin = n;
        }
        for(int i = n-1; i >= 0; i--){
            if(stack.isEmpty()) stack.push(arr.get(i));
            else{
                if(stack.peek().height <= arr.get(i).height){
                    stack.push(arr.get(i));
                } else {
                    while(!stack.isEmpty() && stack.peek().height > arr.get(i).height){
                        stack.pop().leftMin = arr.get(i).index;
                    }
                    stack.push(arr.get(i));
                }
            }
        }
        while (!stack.isEmpty()){
            stack.pop().leftMin = -1;
        }
        for(int i = 0; i < n; i++){
            square = Math.max(square,(arr.get(i).rightMin - arr.get(i).leftMin-1)*arr.get(i).height);
        }
        System.out.println(square);
    }
}
class Squar{
    int index;
    long height;
    int leftMin;
    int rightMin;

    public Squar(int index, long height) {
        this.index = index;
        this.height = height;
    }

}
