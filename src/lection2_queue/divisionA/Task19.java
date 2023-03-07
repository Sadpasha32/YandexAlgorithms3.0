package lection2_queue.divisionA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Task19 {
    public static void main(String[] args) throws IOException {
        double res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(s[i]));
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (!queue.isEmpty()) {
                int y = queue.poll();
                res += (x + y) * 0.05;
                queue.add(x + y);
            }
        }
        System.out.printf("%.2f",res);
    }
}
