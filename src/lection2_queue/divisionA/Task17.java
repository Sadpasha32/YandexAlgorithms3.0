package lection2_queue.divisionA;

import java.io.*;
import java.util.ArrayDeque;

public class Task17 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        ArrayDeque<Integer> firstHalf = new ArrayDeque<>();
        ArrayDeque<Integer> secondHalf = new ArrayDeque<>();
        int n1 = 0;
        int n2 = 0;
        int N = Integer.parseInt(br.readLine());
        String[] s;
        for (int i = 0; i < N; i++) {
            while (secondHalf.size() > firstHalf.size()){
                firstHalf.add(secondHalf.poll());
                n1++;
                n2--;
            }
            s = br.readLine().split(" ");
            if (s[0].equals("+")) {
                if (n1 == 0) {
                    firstHalf.add(Integer.parseInt(s[1]));
                    n1++;
                } else if (n1 - n2 == 1) {
                    secondHalf.add(Integer.parseInt(s[1]));
                    n2++;
                } else if (n1 == n2) {
                    firstHalf.add(secondHalf.poll());
                    n1++;
                    secondHalf.add(Integer.parseInt(s[1]));
                }
            } else if (s[0].equals("*")) {
                if (n1 == 0) {
                    firstHalf.add(Integer.parseInt(s[1]));
                    n1++;
                } else if (n1 - n2 == 1) {
                    secondHalf.addFirst(Integer.parseInt(s[1]));
                    n2++;
                } else if (n1 == n2) {
                    firstHalf.add(Integer.parseInt(s[1]));
                    n1++;
                }
            } else {
                if (!firstHalf.isEmpty()) {
                    bw.write(firstHalf.poll()+"\n");
                    n1--;
                } else {
                    bw.write(secondHalf.poll()+"\n");
                    n2--;
                }
            }
        }
        bw.close();
    }
}
