package lection4_DP2.divisionA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Task30 {
    static HashMap<Range,Integer> memo;
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String[] s = br.readLine().split(" ");
        int L = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);
        arr = new ArrayList<>();
        s = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr.add(Integer.parseInt(s[i]));
        }
        memo = new HashMap<>();
        System.out.println(dp(0,L));
        System.out.println();
    }
    public static int dp(int start, int end){
        Range r = new Range(start,end);
        int res = 0;
        if(memo.containsKey(r)) return memo.get(r);
        else{
            int minVal = Integer.MAX_VALUE;
                for(Integer i: arr){
                if(i > start && i < end){
                    minVal = Math.min(dp(start,i) + dp(i,end),minVal);
                }
            }
            if(minVal != Integer.MAX_VALUE) {
                memo.put(r,minVal + end-start);
            }
            else {
                memo.put(r,0);
            }
        }
        return memo.get(r);
    }
}
class Range{
    int start;
    int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return start == range.start && end == range.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}