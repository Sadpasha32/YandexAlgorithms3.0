package lection5_DFS.divisionA;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Task33 {
    static long[][] graph;
    static int[] visited;
    static int N;
    static int flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        N = Integer.parseInt(br.readLine());
        graph = new long[N][N];
        int[][] allTowers = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            allTowers[i][0] = Integer.parseInt(s[0]);
            allTowers[i][1] = Integer.parseInt(s[1]);
        }
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    long x = (long) (allTowers[j][0] - allTowers[i][0]) * (allTowers[j][0] - allTowers[i][0])
                            + (long) (allTowers[j][1] - allTowers[i][1]) * (allTowers[j][1] - allTowers[i][1]);
                    graph[i][j] = x;
                    set.add(x);
                }
            }
        }
        ArrayList<Long> allDiametrs = new ArrayList<>(set);
        Collections.sort(allDiametrs);
        long maxRadius = -1;
        int[] resColors = new int[N];
        int l = 0, r = allDiametrs.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            visited = new int[N];
            flag = 0;
            for(int i = 0; i < N; i++) {
                if(visited[i] == 0) paintGraph(i, allDiametrs.get(mid), 1);
            }
            if(flag == 0){
                if (allDiametrs.get(mid) > maxRadius){
                    maxRadius = allDiametrs.get(mid);
                    resColors = visited.clone();
                }
               l = mid+1;
            } else {
                r = mid-1;
            }
        }
        System.out.printf("%.15f\n",Math.sqrt(maxRadius)/2);
        for(int i = 0; i < N; i++){
            System.out.print(resColors[i] + " ");
        }
    }
    public static void paintGraph(int current, long radius, int color){
        visited[current] = color;
        for(int i = 0; i < N && flag != 1; i++){
            if(i != current) {
                if (visited[i] == 0 && graph[current][i] < radius) {
                    paintGraph(i, radius, 3 - color);
                } else if (visited[i] != 0 && visited[i] == color && graph[current][i] < radius) {
                    flag = 1;
                    return;
                }
            }
        }
    }
}
