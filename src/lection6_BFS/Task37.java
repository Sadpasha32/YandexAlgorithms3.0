package lection6_BFS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task37 {
    static HashMap<Integer, int[]> graph;
    static Queue<Pair2> queue;
    static ArrayList<Integer> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        graph = new HashMap<>();
        queue = new ArrayDeque<>();
        String[] s;
        int[] arr;
        for (int i = 1; i <= N; i++) {
            arr = new int[N + 1];
            s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                if (!Objects.equals(s[j], "0")) arr[j + 1] = 1;
            }
            graph.put(i, arr);
        }
        s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int kon = Integer.parseInt(s[1]);
        if (start == kon) System.out.println("0");
        else {
            visited = new ArrayList<>();
            Pair2 res = bfs(start, kon);
            ArrayList<Integer> road = new ArrayList<>();
            if (res != null) {
                System.out.println(res.road);
                while (res != null) {
                    road.add(res.val);
                    res = res.prev;
                }
            } else {
                System.out.println("-1");
            }
            for (int i = road.size() - 1; i >= 0; i--) {
                System.out.print(road.get(i) + " ");
            }
        }
    }

    public static Pair2 bfs(int start, int end) {
        Pair2 first = new Pair2(start, 0, null);
        for (int i = 0; i < graph.get(start).length; i++) {
            if (graph.get(start)[i] != 0) queue.add(new Pair2(i, 1, first));
        }
        visited.add(start);
        while (!queue.isEmpty()) {
            Pair2 newStart = queue.poll();
            int[] arr = graph.get(newStart.val);
            if (newStart.val == end) {
                return newStart;
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0 && !visited.contains(i)) queue.add(new Pair2(i, newStart.road + 1, newStart));
            }
            visited.add(newStart.val);
        }
        return null;
    }
}

class Pair2 {
    int val;
    int road;

    Pair2 prev;

    public Pair2(int val, int road, Pair2 prev) {
        this.val = val;
        this.road = road;
        this.prev = prev;
    }
}
