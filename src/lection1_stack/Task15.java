package lection1_stack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Task15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        ArrayList<City> res = new ArrayList<>();
        String[] str = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            City c = new City(Integer.parseInt(str[i]),i);
            res.add(c);
        }
        Stack<City> stack = new Stack<>();
        int index = 0;
        for(int i = 0; i < N; i++){
            if(stack.isEmpty() || stack.peek().pay <= res.get(i).pay){
                stack.push(res.get(i));
            } else{
                while(!stack.isEmpty() && stack.peek().pay > res.get(i).pay){
                    stack.pop().index = res.get(i).index;
                }
                stack.push(res.get(i));
            }
        }
        for(City cit: stack){
            cit.index = -1;
        }
        for(int i = 0; i < N-1; i++){
            System.out.print(res.get(i).index + " ");
        }
        System.out.println(res.get(N-1).index);
    }
}
class City{
    int pay;
    int index;

    public City(int pay, int index) {
        this.pay = pay;
        this.index = index;
    }
}
