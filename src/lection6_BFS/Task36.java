package lection6_BFS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task36 {
    static HashMap<Integer, int[]> graph;
    static Queue<Pair> queue;
    static ArrayList<Integer> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int N = Integer.parseInt(br.readLine());
        graph = new HashMap<>();
        queue = new ArrayDeque<>();
        String[] s;
        int[] arr;
        for (int i = 1; i <= N; i++) {
            arr = new int[N+1];
            s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++){
                if(!Objects.equals(s[j], "0")) arr[j+1] = 1;
            }
            graph.put(i, arr);
        }
        s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int kon = Integer.parseInt(s[1]);
        if(start == kon) System.out.println("0");
        else {
            visited = new ArrayList<>();
            System.out.println(bfs(start, kon));
        }
    }

    public static int bfs(int start, int end) {
        for (int i = 0; i < graph.get(start).length; i++) {
            if(graph.get(start)[i] != 0) queue.add(new Pair(i, 1));
        }
        visited.add(start);
        while (!queue.isEmpty()) {
            Pair newStart = queue.poll();
            int[] arr = graph.get(newStart.val);
            if (newStart.val == end) {
                return newStart.road;
            }
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] != 0 && !visited.contains(i)) queue.add(new Pair(i, newStart.road+1));
            }
            visited.add(newStart.val);
        }
        return -1;
    }
}

class Pair {
    int val;
    int road;

    public Pair(int val, int road) {
        this.val = val;
        this.road = road;
    }
}
