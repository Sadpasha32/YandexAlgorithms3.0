package lection5_DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Task34 {
    static int[][] visited;
    static boolean flag = false;
    static ArrayList<Integer> res = new ArrayList<>();
    static HashMap<Integer, ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]), M = Integer.parseInt(s[1]);
        graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i + 1, new ArrayList<>());
        }
        int x, y;
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            graph.get(x).add(y);
        }
        visited = new int[N + 1][2];
        int color = 1;
        for (int i = 1; i <= N; i++) {
            if (visited[i][0] == 0) {
                dfs(i, 1);
            }
        }
        if (res.size() == 0 || flag) {
            bw.write("-1");
        } else {
            for (int i = res.size() - 1; i >= 0; i--) {
                bw.write(res.get(i) + " ");
            }
        }
        br.close();
        bw.close();
    }

    public static void dfs(int current, int color) {
        visited[current][0] = 1;
        visited[current][1] = color;
        for (Integer i : graph.get(current)) {
            if (visited[i][0] == 0) {
                dfs(i, 1);
            } else if (visited[i][1] != 2) {
                flag = true;
            }
        }
        if (!flag) res.add(current);
        visited[current][1] = 2;
    }
}
