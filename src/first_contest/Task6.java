package first_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Task6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        ArrayList<Pari> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String[] s = br.readLine().split(" ");
            list.add(new Pari(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
        }
        for(int i = N-1; i >= 0; i--){
                for(int j = i-1; j >= 0; j--){
                    if(checkPari(list.get(i),list.get(j)) && list.get(j).valid != 0){
                        list.get(j).valid = 0;
                    }
            }
        }
        int res = 0;
        for(int i = 0; i < N; i++){
            if(list.get(i).valid != 0){
                res++;
            }
        }
        System.out.println(res);
    }
    public static boolean checkPari(Pari p2, Pari p1){
        return p2.nach <= p1.kon && p2.kon >= p1.nach;
    }
}

class Pari{
    int nach;
    int kon;

    int valid = 1;

    public Pari(int nach, int kon) {
        this.nach = nach;
        this.kon = kon;
    }

    @Override
    public String toString() {
        return nach + " " + kon;
    }
}
