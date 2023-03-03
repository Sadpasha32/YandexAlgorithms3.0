package lection5_DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Task31 {
    static ArrayList<Integer> firstComp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        for(int i = 0; i < N; i++){
            graph.put(i+1,new ArrayList<>());
        }
        int M = Integer.parseInt(s[1]);
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]);
            if(x != y){
                graph.get(x).add(y);
                graph.get(y).add(x);
            }
        }
        ArrayList<Integer> visited = new ArrayList<>();
        firstComp.add(1);
        dfs(graph, visited, 1);
        Collections.sort(firstComp);
        bw.write(firstComp.size() + "\n");
        for (Integer i : firstComp) {
            bw.write(i + " ");
        }
        bw.close();
        br.close();
    }

    public static void dfs(HashMap<Integer, ArrayList<Integer>> graph, ArrayList<Integer> visited, Integer current) {
        visited.add(current);
        if(graph.containsKey(current)) {
            for (Integer i : graph.get(current)) {
                if (!visited.contains(i)) {
                    firstComp.add(i);
                    dfs(graph, visited, i);
                }
            }
        }
    }
}
