package lection2_queue;

import java.io.*;
import java.util.ArrayList;

public class Task20 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter  bw = new BufferedWriter(new FileWriter("output.txt"));
        int N = Integer.parseInt(br.readLine());
        HeapMin heap = new HeapMin();
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            heap.Insert(Integer.parseInt(s[i]));
        }
        for(int i = 0; i < N; i++){
            bw.write(heap.Extract() + " ");
        }
        br.close();
        bw.close();
    }
}
class HeapMin {
    private ArrayList<Integer> arr;

    HeapMin() {
        arr = new ArrayList<>();
    }

    public void Insert(int n) {
        arr.add(n);
        sieveUp();
    }

    public int Extract() {
        int res = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        sieveDown();
        arr.remove(arr.size()-1);
        return res;
    }

    private void sieveUp() {
        int i = arr.size() - 1;
        while (i != 0 && arr.get(i) < arr.get((i - 1) / 2)) {
            int c = arr.get((i - 1) / 2);
            arr.set((i - 1) / 2, arr.get(i));
            arr.set(i, c);
            i = (i - 1) / 2;
        }
    }

    public void sieveDown() {
        int i = 0;
        while (i < arr.size()) {
            if (2 * i + 1 < arr.size() && 2 * i + 2 < arr.size() && (arr.get(i) > arr.get(2 * i + 1) || arr.get(i) > arr.get(2 * i + 2))) {
                if (arr.get(2 * i + 1) < arr.get(2 * i + 2)) {
                    int c = arr.get(i);
                    arr.set(i, arr.get(2 * i + 1));
                    arr.set(2 * i + 1, c);
                    i = 2 * i + 1;
                } else {
                    int c = arr.get(i);
                    arr.set(i, arr.get(2 * i + 2));
                    arr.set(2 * i + 2, c);
                    i = 2 * i + 2;
                }
            } else if (2 * i + 1 < arr.size() && arr.get(i) > arr.get(2 * i + 1)) {
                int c = arr.get(i);
                arr.set(i, arr.get(2 * i + 1));
                arr.set(2 * i + 1, c);
                i = 2 * i + 1;
            } else {
                break;
            }
        }
    }
}