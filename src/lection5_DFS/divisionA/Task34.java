package lection5_DFS.divisionA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task34 {
    static int N;
    static int K;
    static int[][] graph;
    static int[][] visited;
    static int[][] res;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static int[][] dir2 = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

    static int cntBombs = 0;
    static boolean flagOne = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        graph = new int[N][K];
        visited = new int[N][K];
        res = new int[N][K];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < K; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                if(res[i][j] == 0) {
                    flagOne = false;
                    visited = new int[N][K];
                    dfs(i, j, -1, -1,dir);
                }
            }
        }
        int res1 = cntBombs;
        cntBombs = 0;
        res = new int[N][K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                if(res[i][j] == 0) {
                    flagOne = false;
                    visited = new int[N][K];
                    dfs(i, j, -1, -1,dir2);
                }
            }
        }
        System.out.println(Math.min(res1,cntBombs));
    }

    public static void dfs(int i, int j, int previ, int prevj,int[][] dir) {
        if (res[i][j] == 1) {
            flagOne = true;
            return;
        }
        visited[i][j] = 1;
        int cnt = 0;
        for (int[] way : dir) {
            if (!(i + way[0] == previ && j + way[1] == prevj)) {
                if (i + way[0] >= 0 && i + way[0] < N &&
                        j + way[1] >= 0 && j + way[1] < K &&
                        graph[i][j] >= graph[i + way[0]][j + way[1]] && visited[i+way[0]][j+way[1]] == 0) {
                    dfs(i + way[0], j + way[1], i, j,dir);
                    if (flagOne) {
                        res[i][j] = 1;
                        break;
                    }
                    cnt++;
                }
            }
        }
        if (cnt == 0 && !flagOne) {
            res[i][j] = 1;
            cntBombs++;
            flagOne = true;
        }
    }
}
