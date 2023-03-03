package lection5_DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Task32 {
    static int[] visited;
    static HashMap<Integer, ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        graph = new HashMap<>();
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        for (int i = 0; i < N; i++) {
            graph.put(i + 1, new ArrayList<>());
        }
        int M = Integer.parseInt(s[1]);
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        visited = new int[N+1];
        int conn = 1;
        HashMap<Integer, ArrayList<Integer>> connect = new HashMap<>();
        for (Integer i : graph.keySet()) {
            if (visited[i] == 0) {
                connect.put(conn, new ArrayList<>());
                connect.get(conn).add(i);
                dfs(i, connect.get(conn));
                conn++;
            }
        }
        bw.write(connect.keySet().size() + "\n");
        for (Integer i : connect.keySet()) {
            bw.write(connect.get(i).size() + "\n");
            for (Integer j : connect.get(i)) {
                bw.write(j + " ");
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
    public static void dfs(Integer current, ArrayList<Integer> conn) {
        visited[current] = 1;
        for (Integer i : graph.get(current)) {
            if (visited[i] == 0) {
                conn.add(i);
                dfs(i, conn);
            }
        }
    }
}
