package lection_1_old;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        ArrayList<Table> arr = new ArrayList<>();
        arr.add(new Table((x1+x2)*Math.max(y1,y2),(x1+x2),Math.max(y1,y2)));
        arr.add(new Table((x1+y2)*Math.max(x2,y1),(x1+y2),Math.max(x2,y1)));
        arr.add(new Table((y1+x2)*Math.max(y2,x1),(y1+x2),Math.max(y2,x1)));
        arr.add(new Table((y1+y2)*Math.max(x1,x2),(y1+y2),Math.max(x1,x2)));
        Collections.sort(arr);
        System.out.println(arr.get(0).height + " " + arr.get(0).width);
    }
}
class Table implements Comparable<Table>{
    int square;
    int height;
    int width;

    public Table(int square, int height, int width) {
        this.square = square;
        this.height = height;
        this.width = width;
    }

    @Override
    public int compareTo(Table o) {
        return square-o.square;
    }
}
