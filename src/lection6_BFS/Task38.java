package lection6_BFS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task38 {
    static int[][] graph;
    static Queue<Flea> queue;
    static ArrayList<Integer> visited;
    static int n;
    static int m;

    static int endX;
    static int endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        graph = new int[n][m];
        queue = new ArrayDeque<>();
        endX = Integer.parseInt(s[2])-1;
        endY = Integer.parseInt(s[3])-1;
        int Q = Integer.parseInt(s[4]);
        int res = 0;
        int startX, startY;
        int x;
        int flag = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                graph[i][j] = -1;
            }
        }
        bfs(endX,endY);
        graph[endX][endY] = 0;
        for(int i = 0; i < Q; i++){
            s = br.readLine().split(" ");
            startX = Integer.parseInt(s[0]);
            startY = Integer.parseInt(s[1]);
            if( graph[startX-1][startY-1] != -1) res += graph[startX-1][startY-1];
            else{
                flag = 1;
                break;
            }
        }
        if(flag == 1) System.out.println(-1);
        else System.out.println(res);
    }
    public static void bfs(int startX, int startY){
        queue = new ArrayDeque<>();
        addMove(startX,startY,1);
        while (!queue.isEmpty()){
            Flea newFlea = queue.poll();
            addMove(newFlea.startX, newFlea.startY, newFlea.road+1);
        }
    }
    public static void  addMove(int startX, int startY, int road){
        if(startY-2 >= 0 && startX-1 >= 0 && graph[startX-1][startY-2] == -1){
            graph[startX-1][startY-2] = road;
            queue.add(new Flea(startX-1,startY-2,road));
        }
        if(startY-2 >= 0 && startX+1 < n && graph[startX+1][startY-2] == -1){
            graph[startX+1][startY-2] = road;
            queue.add(new Flea(startX+1,startY-2,road));
        }
        if(startY-1 >= 0 && startX-2 >= 0 && graph[startX-2][startY-1] == -1){
            graph[startX-2][startY-1] = road;
            queue.add(new Flea(startX-2,startY-1,road));
        }
        if(startY+1 < m && startX-2 >= 0 &&  graph[startX-2][startY+1] == -1){
            graph[startX-2][startY+1] = road;
            queue.add(new Flea(startX-2,startY+1,road));
        }
        if(startY+2 < m && startX-1 >= 0 && graph[startX-1][startY+2] == -1){
            graph[startX-1][startY+2] = road;
            queue.add(new Flea(startX-1,startY+2,road));
        }
        if(startY+2 < m && startX+1 < n && graph[startX+1][startY+2] == -1){
            graph[startX+1][startY+2] = road;
            queue.add(new Flea(startX+1,startY+2,road));
        }
        if(startY-1 >= 0 && startX+2 < n && graph[startX+2][startY-1] == -1){
            graph[startX+2][startY-1] = road;
            queue.add(new Flea(startX+2,startY-1,road));
        }
        if(startY+1 < m && startX+2 < n && graph[startX+2][startY+1] == -1){
            graph[startX+2][startY+1] = road;
            queue.add(new Flea(startX+2,startY+1,road));
        }
    }
}

class Flea {
    int startX;
    int startY;
    int road;

    public Flea(int startX, int startY, int road) {
        this.startX = startX;
        this.startY = startY;
        this.road = road;
    }

}
