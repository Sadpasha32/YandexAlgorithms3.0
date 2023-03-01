package lection2_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Task17 {
    public static void main(String[] args) {
       Queue<Integer> q1 = new LinkedList<>();
       Queue<Integer> q2 = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 5; i++){
            q1.add(sc.nextInt());
        }
        for(int i = 0; i < 5; i++){
            q2.add(sc.nextInt());
        }
        long counter = 0;
        int flag = 0;
        while(!q1.isEmpty() && !q2.isEmpty()){
            if(counter == 1000000){
                flag = 1;
                System.out.println("botva");
                break;
            }
            int x1 = q1.poll();
            int x2 = q2.poll();
            counter++;
            if(x1 == 0 && x2 == 9){
                q1.add(x1);
                q1.add(x2);
            } else if(x1 == 9 && x2 == 0){
                q2.add(x1);
                q2.add(x2);
            } else if(x1 > x2) {
                q1.add(x1);
                q1.add(x2);
            } else {
                q2.add(x1);
                q2.add(x2);
            }
        }
        if(flag == 0 && q1.isEmpty()){
            System.out.println("second " + counter);
        } else if(flag == 0){
            System.out.println("first " + counter);
        }
    }
}
