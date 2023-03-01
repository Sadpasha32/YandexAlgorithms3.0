package first_contest;

import java.io.*;
import java.util.*;

public class Task3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        Writer bw = new FileWriter("output.txt");
        int n = Integer.parseInt(br.readLine());
        Set<Integer> diego = new HashSet<>();
        int x;
        String[] sArr = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            x = Integer.parseInt(sArr[i]);
            diego.add(x);
        }
        ArrayList<Integer> diegoSort = new ArrayList<>(diego);
        Collections.sort(diegoSort);
        int k = Integer.parseInt(br.readLine());
        int res;
        String[] colArr = br.readLine().split(" ");
        for(int i = 0; i < k; i++){
            x = Integer.parseInt(colArr[i]);
            res = Collections.binarySearch(diegoSort,x);
            if(res < 0) res = Math.abs(res)-1;
            bw.write(res +"\n");
        }
        bw.close();
    }
}
