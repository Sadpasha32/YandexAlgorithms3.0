package lection2_queue;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) throws IOException {
        Queue q = new Queue();
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String[] s;
        String line;
        while((line = br.readLine()) != null){
            s = line.split(" ");
            if(s[0].equals("push")){
                q.push(Integer.parseInt(s[1]));
                bw.write("ok\n");
            } else if(s[0].equals("pop")){
                Optional<Integer> res = q.pop();
                if(res.isPresent())  bw.write(res.get() + "\n");
                else  bw.write("error\n");
            } else if(s[0].equals("front")){
                Optional<Integer> res = q.front();
                if(res.isPresent())  bw.write(res.get()+"\n");
                else  bw.write("error\n");
            } else if(s[0].equals("size")){
                bw.write(q.size()+"\n");
            } else if(s[0].equals("clear")){
                q.clear();
                bw.write("ok\n");
            } else if(s[0].equals("exit")){
                bw.write("bye\n");
                break;
            }
        }
        bw.close();
        br.close();
    }
}
class Queue{
    private ArrayList<Integer> arr;
    private int head;

    public Queue() {
        arr = new ArrayList<>();
        head = 0;
    }
    public void push(int n){
        arr.add(n);
    }
    public Optional<Integer> pop(){
        if(head >= arr.size()){
            arr = new ArrayList<>();
            head = 0;
            return Optional.empty();
        }
        return Optional.ofNullable(arr.get(head++));
    }
    public Optional<Integer> front(){
        if(head >= arr.size()){
            arr = new ArrayList<>();
            head = 0;
            return Optional.empty();
        }
        return Optional.ofNullable(arr.get(head));
    }
    public int size(){
        if(head != -1) return arr.size() - head;
        else return 0;
    }
    public void clear(){
        arr = new ArrayList<>();
        head = 0;
    }

}
