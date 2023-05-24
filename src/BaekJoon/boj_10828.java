package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// TODO: 2023/05/24 : 스택     https://www.acmicpc.net/problem/10828
//정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
//명령은 총 다섯 가지이다.
//push X: 정수 X를 스택에 넣는 연산이다.
//pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 스택에 들어있는 정수의 개수를 출력한다.
//empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
//top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
class Stack{
    ArrayList<Integer> list = new ArrayList<>();
    int size = 0;
    Stack() {
    }
    void push(int x) {
        size++;
        list.add(x);
    }

    int pop() {
        if (size>0){
            return list.remove(size---1);
        }
        return -1;
    }
    int size(){
        return size;
    }
    int empty(){
        if (size <= 0) {
            return 1;
        }
        else
            return 0;
    }
    int top(){
        if(size>0){
            return list.get(size-1);
        }
        else{
            return -1;
        }
    }
}

public class boj_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        Stack stack = new Stack();

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            String str= stk.nextToken();
            if(str.equals("push")){
                stack.push(Integer.parseInt(stk.nextToken()));
            }
            else if(str.equals("top")){
                System.out.println(stack.top());
            }
            else if(str.equals("size")){
                System.out.println(stack.size());
            }
            else if(str.equals("empty")){
                System.out.println(stack.empty());
            }
            else if(str.equals("pop")){
                System.out.println(stack.pop());
            }
        }
    }
}
