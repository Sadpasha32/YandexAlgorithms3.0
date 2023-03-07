package lection2_queue.divisionA;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Task18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String[] s = br.readLine().split(" ");
        int K = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);
        PriorityQueue<Train> heapRange = new PriorityQueue<>();
        PriorityQueue<Integer> heapStop = new PriorityQueue<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int flag = 0;
        for (int i = 0; i < K; i++) {
            heapStop.add(i + 1);
        }
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            while (!heapRange.isEmpty() && heapRange.peek().end < Integer.parseInt(s[0])) {
                heapStop.add(heapRange.poll().num);
            }
            if (!heapStop.isEmpty()) {
                int x = heapStop.poll();
                heapRange.add(new Train(Integer.parseInt(s[0]), Integer.parseInt(s[1]), x));
                arr.add(x);
            } else {
                flag = 1;
                bw.write("0 " + (i + 1));
                break;
            }
        }
        if (flag == 0) {
            for (Integer i : arr) {
                bw.write(i + "\n");
            }
        }
        bw.close();
    }
}

class Train implements Comparable<Train> {
    int start;
    int end;
    int num;

    public Train(int start, int end, int num) {
        this.start = start;
        this.end = end;
        this.num = num;
    }

    @Override
    public int compareTo(Train o) {
        return end - o.end;
    }
}
