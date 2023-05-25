package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//Todo: 2023/05/25 큐 https://www.acmicpc.net/problem/10845
class boj_que{
    private LinkedList<Integer> que = new LinkedList<>();
    int size = 0;
    void push(int x) {
        que.add(x);
        size++;
    }

    int pop() {
        if(size==0) return -1;

        else{
            size--;
            return que.removeFirst();
        }
    }
    int size(){
        return size;
    }
    int empty(){
        if(size==0)
            return 1;
        else
            return 0;
    }
    int front(){
        if(size==0) return -1;
        else{
            return que.peekFirst();
        }
    }
    int back(){
        if(size==0) return -1;
        else{
            return que.peekLast();
        }
    }

}
public class boj_10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boj_que que = new boj_que();
        int n = Integer.parseInt(br.readLine());
        for(int i =0;i<n;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String token = stk.nextToken();
            if(token.equals("push")){
                que.push(Integer.parseInt(stk.nextToken()));
            } else if (token.equals("front")) {
                System.out.println(que.front());
            } else if (token.equals("back")) {
                System.out.println(que.back());
            } else if (token.equals("size")) {
                System.out.println(que.size());
            } else if (token.equals("pop")) {
                System.out.println(que.pop());
            } else if (token.equals("empty")) {
                System.out.println(que.empty());
            }
        }
    }
}
