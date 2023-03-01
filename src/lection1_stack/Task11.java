package lection1_stack;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Stack st = new Stack();
        Scanner sc = new Scanner(System.in);
        label:
        while(sc.hasNextLine()){
            String[] s = sc.nextLine().split(" ");
            switch (s[0]) {
                case "push":
                    st.push(Integer.parseInt(s[1]));
                    System.out.println("ok");
                    break;
                case "pop": {
                    Optional<Integer> res = st.pop();
                    if (res.isPresent()) {
                        System.out.println(res.get());
                    } else {
                        System.out.println("error");
                    }
                    break;
                }
                case "back": {
                    Optional<Integer> res = st.back();
                    if (res.isPresent()) {
                        System.out.println(res.get());
                    } else {
                        System.out.println("error");
                    }
                    break;
                }
                case "size":
                    System.out.println(st.size());
                    break;
                case "clear":
                    st.clear();
                    System.out.println("ok");
                    break;
                case "exit":
                    System.out.println("bye");
                    break label;
            }
        }
    }
}

class Stack{
    int head;
    ArrayList<Integer> arr;
    Stack(){
        arr = new ArrayList<>();
        head = -1;
    }
    public void push(int n){
        if(head == -1 && arr.size() != 0){
            arr.set(0,n);
        }
        else if(head >= 0 && head < arr.size()-1)
            arr.set(head+1,n);
        else arr.add(n);
        head++;
    }

    public Optional<Integer> pop(){
        if(head == -1) return Optional.empty();
        int res = arr.get(head);
        head--;
        return Optional.of(res);
    }

    public Optional<Integer> back(){
        if(head == -1) return Optional.empty();
        return Optional.ofNullable(arr.get(head));
    }

    public int size(){
        return head+1;
    }
    public void clear(){
        arr = new ArrayList<>();
        head = -1;
    }
}
