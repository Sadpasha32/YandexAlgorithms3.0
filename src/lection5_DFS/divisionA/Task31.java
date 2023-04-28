package lection5_DFS.divisionA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task31 {
    static char[][] graph;
    static int[][] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        String s;
        for(int i = 0; i < N; i++){
            s = br.readLine();
            for(int j = 0; j < N; j++){
                graph[i][j] = s.charAt(j);
            }
        }
        visited = new int[N][N];
        String[] str = br.readLine().split(" ");
        int startX = Integer.parseInt(str[0])-1, startY = Integer.parseInt(str[1])-1;
        System.out.println(dfs(startX,startY));

    }
   public static int dfs(int start, int end){
       int res = 0;
        if(start >= 0 && start < N && end >= 0 && end < N && graph[start][end] == '.'){
            if (visited[start][end] == 0) {
                visited[start][end] = 1;
                res = 1 + dfs(start-1,end) + dfs(start,end-1) + dfs(start+1,end) + dfs(start,end+1);
            }
        }
        return res;
   }
}
