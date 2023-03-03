package lection5_DFS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Task33 {
    static int[][] visited;
    static boolean flag = false;
    static HashMap<Integer, ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]), M = Integer.parseInt(s[1]);
        graph = new HashMap<>();
        for(int i = 0; i < N; i++){
            graph.put(i+1, new ArrayList<>());
        }
        int x,y;
        for(int i = 0; i < M; i++){
            s = br.readLine().split(" ");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        visited = new int[N+1][2];
        for(int i = 1; i <= N; i++){
            if(visited[i][0] == 0 && !flag){
                dfs(i,1);
            }
        }
        if(flag) System.out.println("NO");
        else System.out.println("YES");

    }
    public static void dfs(int current, int color){
        if(!flag){
            visited[current][0] = 1;
            visited[current][1] = color;
            for(Integer i: graph.get(current)){
                if(visited[i][0] != 1){
                    dfs(i,3 - color);
                } else if(visited[i][1] == color){
                    flag = true;
                }
            }
        }
    }


}
