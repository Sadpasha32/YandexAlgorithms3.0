package lection5_DFS;

import java.io.*;
import java.util.ArrayList;

public class Task35 {
    static int[][] graph;
    static int[] visited;
    static int N;
    static boolean flag = false;
    static boolean flagfind = false;
    static ArrayList<Integer> res = new ArrayList<>();
    static int startCycle = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        visited = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(s[j - 1]);
            }
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                dfs(i, -1);
            }
        }
        if (res.size() == 0) bw.write("NO");
        else {
            bw.write("YES\n");
            bw.write(res.size() + "\n");
            for (Integer i : res) {
                bw.write(i + " ");
            }
        }
        br.close();
        bw.close();

    }

    public static void dfs(int current, int prev) {

        visited[current] = 1;
        for (int i = 1; i <= N && !flagfind; i++) {
            if (graph[current][i] == 1 && visited[i] == 0) {
                dfs(i, current);
                if (flag && !flagfind) {
                    res.add(current);
                    if (current == startCycle) {
                        flagfind = true;
                    }
                    return;
                }
            } else if (graph[current][i] == 1 && visited[i] == 1 && i != prev) {
                startCycle = i;
                res.add(current);
                flag = true;
                return;
            }
        }
    }
}
