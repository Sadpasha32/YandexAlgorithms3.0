package lection6_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Task39 {
    static int startLayer;
    static int startX;
    static int startY;
    static Deque<Unit> deque;
    static int N;
    static char[][][] labirint;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        labirint = new char[N][N][N];
        visited = new int[N][N][N];
        deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            br.readLine();
            for (int j = 0; j < N; j++) {
                String s = br.readLine();
                for (int k = 0; k < N; k++) {
                    labirint[i][j][k] = s.charAt(k);
                    if (s.charAt(k) == 'S') {
                        startLayer = i;
                        startX = j;
                        startY = k;
                    }
                }
            }
        }
        if (startLayer == 0) System.out.println(0);
        else {
            int res = bfs();
            System.out.println(res);
        }
    }

    public static int bfs() {
        addMove(startLayer, startX, startY, 1);
        while (!deque.isEmpty()) {
            Unit unit = deque.poll();
            if (unit.layer == 0) {
                return unit.road;
            }
            addMove(unit.layer, unit.x, unit.y, unit.road + 1);
        }
        return -1;
    }

    public static void addMove(int layer, int x, int y, int road) {
        if (x + 1 < N && labirint[layer][x + 1][y] != '#' && visited[layer][x + 1][y] == 0) {
            visited[layer][x + 1][y] = road;
            deque.add(new Unit(x + 1, y, layer, road));
        }
        if (x - 1 >= 0 && labirint[layer][x - 1][y] != '#' && visited[layer][x - 1][y] == 0) {
            visited[layer][x - 1][y] = road;
            deque.add(new Unit(x - 1, y, layer, road));
        }
        if (y - 1 >= 0 && labirint[layer][x][y - 1] != '#' && visited[layer][x][y - 1] == 0) {
            visited[layer][x][y - 1] = road;
            deque.add(new Unit(x, y - 1, layer, road));
        }
        if (y + 1 < N && labirint[layer][x][y + 1] != '#' && visited[layer][x][y + 1] == 0) {
            visited[layer][x][y + 1] = road;
            deque.add(new Unit(x, y + 1, layer, road));
        }
        if (layer + 1 < N && labirint[layer + 1][x][y] != '#' && visited[layer + 1][x][y] == 0) {
            visited[layer + 1][x][y] = road;
            deque.add(new Unit(x, y, layer + 1, road));
        }
        if (layer - 1 >= 0 && labirint[layer - 1][x][y] != '#' && visited[layer - 1][x][y] == 0) {
            visited[layer - 1][x][y] = road;
            deque.add(new Unit(x, y, layer - 1, road));
        }
    }
}

class Unit {
    int x;
    int y;
    int layer;
    int road;

    public Unit(int x, int y, int layer, int road) {
        this.x = x;
        this.y = y;
        this.layer = layer;
        this.road = road;
    }
}