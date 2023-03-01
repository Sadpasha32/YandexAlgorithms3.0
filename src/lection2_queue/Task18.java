package lection2_queue;

import java.io.*;
import java.util.Optional;

public class Task18 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        Deq deq = new Deq();
        String line;
        String[] s;
        while ((line = br.readLine()) != null) {
            s = line.split(" ");
            if (s[0].equals("push_front")) {
                deq.push_front(Integer.parseInt(s[1]));
                bw.write("ok\n");
            } else if (s[0].equals("push_back")) {
                deq.push_back(Integer.parseInt(s[1]));
                bw.write("ok\n");
            } else if (s[0].equals("pop_front")) {
                Optional<Integer> res = deq.pop_front();
                if (res.isPresent()) {
                    bw.write(res.get() + "\n");
                } else {
                    bw.write("error\n");
                }
            } else if (s[0].equals("pop_back")) {
                Optional<Integer> res = deq.pop_back();
                if (res.isPresent()) {
                    bw.write(res.get() + "\n");
                } else {
                    bw.write("error\n");
                }
            } else if (s[0].equals("front")) {
                Optional<Integer> res = deq.front();
                if (res.isPresent()) {
                    bw.write(res.get() + "\n");
                } else {
                    bw.write("error\n");
                }
            } else if (s[0].equals("back")) {
                Optional<Integer> res = deq.back();
                if (res.isPresent()) {
                    bw.write(res.get() + "\n");
                } else {
                    bw.write("error\n");
                }
            } else if (s[0].equals("size")) {
                bw.write(deq.size() + "\n");
            } else if (s[0].equals("clear")) {
                deq.clear();
                bw.write("ok\n");
            } else if (s[0].equals("exit")) {
                bw.write("bye");
                break;
            }
        }
        bw.close();
        br.close();
    }
}

class Deq {
    private Node front;
    private Node back;
    private int size;

    public void push_front(int n) {
        if (front == null && back == null) {
            front = new Node(n);
            back = front;
        } else {
            Node newNode = new Node(n);
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    public void push_back(int n) {
        if (front == null && back == null) {
            back = new Node(n);
            front = back;
        } else {
            Node newNode = new Node(n);
            back.next = newNode;
            newNode.prev = back;
            back = newNode;

        }
        size++;
    }

    public Optional<Integer> pop_front() {
        if (size != 0) size--;
        if (front != null) {
            Optional<Integer> res = Optional.of(front.val);
            if(front.next == null){
                front = null;
                back = null;
            } else {
                front = front.next;
                front.prev = null;
            }
            return res;
        } else return Optional.empty();
    }

    public Optional<Integer> pop_back() {
        if (size != 0) size--;
        if (front == back) {
            front = null;
            back = null;
            return Optional.empty();
        } else if (back != null) {
            Optional<Integer> res = Optional.of(back.val);
            if(back.prev == null){
                front = null;
                back = null;
            } else {
                back = back.prev;
                back.next = null;
            }
            return res;
        } else return Optional.empty();
    }

    public Optional<Integer> front() {
        if (front != null) return Optional.of(front.val);
        else return Optional.empty();
    }

    public Optional<Integer> back() {
        if (back != null) return Optional.of(back.val);
        else return Optional.empty();
    }

    public int size() {
        return size;
    }

    public void clear() {
        front = null;
        back = null;
        size = 0;
    }
}

class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
