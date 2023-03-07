package lection2_queue.divisionA;

import java.io.*;
import java.util.PriorityQueue;

public class Task16 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        s = br.readLine().split(" ");
        for(int i = 0; i < s.length; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        for(int i = 0; i < s.length; i++){
            if(i < k){
                heap.add(new Pair(arr[i],i));
            } else {
                if(i == k) bw.write(heap.peek().getVal() + "\n");
                while(!heap.isEmpty() && heap.peek().getIndex() <= i-k){
                    heap.poll();
                }
                heap.add(new Pair(arr[i],i));
                bw.write(heap.peek().getVal() + "\n");
            }
        }
        if(k == n) bw.write(heap.peek().getVal() + "\n");
        br.close();
        bw.close();
    }
}
class Pair implements Comparable<Pair>{
    private int val;

    private int index;

    public Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
    public int getVal() {
        return val;
    }

    public int getIndex() {
        return index;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(Pair o) {
        return val - o.getVal();
    }
}
