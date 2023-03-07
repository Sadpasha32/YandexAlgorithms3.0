package lection6_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class Task40 {
    static HashMap<Integer, ArrayList<Integer>> graph;
    static HashMap<Integer, Integer> countPeres;
    static Deque<Node> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new HashMap<>();
        countPeres = new HashMap<>();
        deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            graph.put(i + 1, new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            for (int j = 0; j < x; j++) {
                int z = Integer.parseInt(s[j + 1]);
                for (int k = 0; k < x; k++) {
                    int y = Integer.parseInt(s[k + 1]);
                    if (z != y) graph.get(z).add(y);
                }
            }
        }
        String[] s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);
        if(start == end) System.out.println(0);
        else System.out.println(bfs(start,end));
    }

    public static int bfs(int start, int end) {
        for (Integer i : graph.get(start)) {
            countPeres.put(i, 0);
            deque.add(new Node(i, 0));
        }
        while (!deque.isEmpty()) {
            Node newNode = deque.poll();
            if(newNode.val == end){
                return newNode.road;
            }
            for (Integer i: graph.get(newNode.val)){
                if(!countPeres.containsKey(i)){
                    countPeres.put(i, newNode.road+1);
                    deque.add(new Node(i, newNode.road+1));
                }
            }
        }
        return -1;
    }
}

class Node {
    int val;
    int road;

    public Node(int val, int road) {
        this.val = val;
        this.road = road;
    }
}
