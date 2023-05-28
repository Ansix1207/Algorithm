package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//todo: 1874번 스택 수열 (실버2) https://www.acmicpc.net/problem/1874
//todo : 성공
public class boj_1874 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int k;
        int value = 1;
        for (int i = 1; i <= n; i++) {
            k = Integer.parseInt(br.readLine());
            while(true){
                if(value<=k){//들어간 값이 타겟 값보다 작을 경우 푸쉬
                    stack.push(value++);
                    sb.append("+\n");
                }
                else{//타겟 값보다 크면 팝
                    if(stack.peek()>=k){
                        stack.pop();
                        sb.append("-\n");
                        break;
                    }
                    else{
                        System.out.print("NO");
                        return;
                    }
                }
            }
        }
        System.out.print(sb.toString());
    }
}
