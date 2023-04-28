package lection5_DFS.divisionA;

import java.io.*;
import java.util.*;

public class Task35 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> {
           if(Objects.equals(o1.getValue(), o2.getValue())){
               return o2.getKey() - o1.getKey();
           } else {
               return o1.getValue() - o2.getValue();
           }
        });
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Set<Integer>> graph = new HashMap<>();
        HashMap<Integer,Set<Integer>> invGraph = new HashMap<>();

        for(int i = 0; i < n; i++){
            graph.put(i+1,new HashSet<>());
            invGraph.put(i+1,new HashSet<>());
            map.put(i+1,0);
        }
        String[] s;
        for(int i = 0; i < n; i++){
            s = br.readLine().split(" ");
            int num = Integer.parseInt(s[0]);
            for(int j = 0; j < num; j++){
                graph.get(i+1).add(Integer.parseInt(s[j+1]));
                invGraph.get(Integer.parseInt(s[j+1])).add(i+1);
            }
        }
        for(Integer i: invGraph.keySet()){
            map.put(i,invGraph.get(i).size());
            priorityQueue.add(Map.entry(i,invGraph.get(i).size()));
        }
        int[] resArr = new int[n];
        while(n != 0){
            int res = priorityQueue.poll().getKey();
            for(Integer i: graph.get(res)){
                map.put(i,map.get(i)-1);
                priorityQueue.add(Map.entry(i,map.get(i)));
            }
            resArr[n-1] = res;
            n--;
        }
        for(int i: resArr){
            bw.write(i + " ");
        }
        bw.close();
    }

}
