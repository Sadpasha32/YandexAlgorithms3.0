package mini_test;

import java.util.*;

public class Task2 {
    static class Note implements Comparable<Note>{
        int minutes;
        int eventType;

        public Note(int minutes, int eventType) {
            this.minutes = minutes;
            this.eventType = eventType;
        }

        @Override
        public int compareTo(Note o) {
            return minutes - o.minutes;
        }
    }

    public static int minutCounter(String[] s){
        return Integer.parseInt(s[0])*24*60 + Integer.parseInt(s[1])*60 + Integer.parseInt(s[2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        TreeMap<Integer, ArrayList<Note>> a = new TreeMap<>();
        String s;
        int eventType = 0;
        for(int i = 0; i < n; i++){
            s = sc.nextLine();
            String[] sSplit = s.split(" ");
            if(sSplit[4].equals("A")) eventType = 0;
            else if(sSplit[4].equals("C") || sSplit[4].equals("S")) eventType = 1;
            else continue;
            Note note = new Note(minutCounter(sSplit), eventType);
            int id = Integer.parseInt(sSplit[3]);
            if(a.containsKey(id)){
                a.get(id).add(note);
            } else{
                a.put(id,new ArrayList<>());
                a.get(id).add(note);
            }
        }
        for(Integer id : a.keySet()){
            int prev = -1;
            int res = 0;
            ArrayList<Note> arr = a.get(id);
            Collections.sort(arr);
            for(Note note : arr){
                if(note.eventType == 0){
                    prev = note.minutes;
                } else {
                    res += note.minutes - prev;
                }
            }
            System.out.print(res + " ");
        }
    }
}
