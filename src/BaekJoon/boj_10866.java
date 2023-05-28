package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//todo: 10866번 덱 (실버4) https://www.acmicpc.net/problem/10866
//todo: 성공
public class boj_10866 {
    static ArrayDeque<Integer> deque = new ArrayDeque<>();
    static void push_front(int x){
        deque.offerFirst(x);
    }
    static void push_back(int x){
        deque.offer(x);
    }

    static int pop_front() {
        if(deque.isEmpty()) return -1;
        else return deque.poll();
    }
    static int pop_back() {
        if(deque.isEmpty()) return -1;
        else return deque.pollLast();
    }
    static int size(){
        return deque.size();
    }
    static int empty(){
        if(deque.isEmpty()) return 1;
        return 0;
    }
    static int front(){
        if(deque.isEmpty()) return -1;
        return deque.peek();
    }
    static int back(){
        if(deque.isEmpty()) return -1;
        return deque.peekLast();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String option = stk.nextToken();
            if(option.equals("push_back")){
                push_back(Integer.parseInt(stk.nextToken()));
            }
            else if(option.equals("push_front")){
                push_front(Integer.parseInt(stk.nextToken()));
            }
            else if(option.equals("pop_front")){
                System.out.println(pop_front());
            }
            else if(option.equals("pop_back")){
                System.out.println(pop_back());
            }
            else if(option.equals("size")){
                System.out.println(size());
            }
            else if(option.equals("empty")) {
                System.out.println(empty());
            }
            else if(option.equals("front")) {
                System.out.println(front());
            }
            else if(option.equals("back")) {
                System.out.println(back());
            }
        }
    }
}
