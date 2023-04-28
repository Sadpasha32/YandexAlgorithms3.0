package lection5_DFS.divisionA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Task32 {
    static HashMap<Integer, ArrayList<Integer>> graph;
    static HashSet<Integer> visited;
    static HashSet<Integer> res;
    static int flagFind = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        graph = new HashMap<>();
        for(int i = 0; i < N; i++){
            graph.put(i+1,new ArrayList<>());
        }
        visited = new HashSet<>();
        res = new HashSet<>();
        for(int i = 0; i < M; i++){
            s = br.readLine().split(" ");
            if(!s[0].equals(s[1])){
                graph.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
            }
        }
        for(int i = 0; i < N; i++){
            flagFind = 0;
            visited.clear();
            dfs(i+1);
        }
        ArrayList<Integer> otvet = new ArrayList<>(res);
        Collections.sort(otvet);
        for(Integer i: otvet){
            System.out.print(i + " ");
        }
    }
    public static void dfs(int start){
        if(start == 1){
            flagFind = 1;
            res.add(start);
            return;
        }
        if(!visited.contains(start)){
            visited.add(start);
            for(Integer i: graph.get(start)){
                dfs(i);
                if(flagFind == 1 || res.contains(i)) {
                    res.add(i);
                    res.add(start);
                    return;
                }
            }
        }
    }
}
