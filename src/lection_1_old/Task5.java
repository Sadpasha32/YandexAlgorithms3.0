package lection_1_old;

import java.util.ArrayList;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K1 = sc.nextInt();
        int M = sc.nextInt();
        int K2 = sc.nextInt();
        int P2 = sc.nextInt();
        int N2 = sc.nextInt();
        int P1 = 0,N1 = 0;
        int newP2, newN2;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 1; i <= 1000000; i++){
            newP2 = (int)Math.ceil((float)K2/(M*i));
            newN2 = (int)Math.ceil((float)K2/i) - (newP2-1)*M;
            if(newP2 == P2 && newN2 == N2) res.add(i);
        }
        if(res.size() == 0){
            P1 = -1;
            N1 = -1;
        } else {
            int prevP1 = -1, prevN1 = -1;
            int resP1 = -1, resN1 = -1;
            for(Integer i : res){
                P1 = (int)Math.ceil((float)K1/(M*i));
                N1 = (int)Math.ceil((float)K1/i) - (P1-1)*M;
                if(prevN1 != -1 && prevP1 != -1){
                    if(prevN1 != N1) resN1 = 0;
                    if(prevP1 != P1) resP1 = 0;
                }
                prevP1 = P1;
                prevN1 = N1;
            }
            if(resN1 == 0) N1 = 0;
            if(resP1 == 0) P1 = 0;
        }
        System.out.println(P1 + " " + N1);
    }
}
