package BaekJoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// TODO: 2023/06/01 17298번 오큰수 (골드4) https://www.acmicpc.net/problem/17298
// TODO: 2023/06/01 진행중
public class boj_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());//총 n개의 수
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine()); //n개의 숫자 나누기
        int [] arr = new int [n];
//        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0; i < n; i++) {
            //푸쉬
            arr[i] = Integer.parseInt(stk.nextToken());
//            stack.push(arr[i]);
        }
        for (int i = n-2; i>=0; i--) {
            if(i==n-2){//맨 오른쪽 숫자 강제로 넣음
                stack2.push(-1);
            }
            //반례 찾기
            if (arr[i] < arr[i + 1]) {
                stack2.push(arr[i+1]);
            }else if(arr[i]<stack2.peek()){
                stack2.push(stack2.peek());
            }
            else{
                stack2.push(-1);
            }
        }
        //출력
        while (!stack2.isEmpty()) {
                bw.append(stack2.pop() + " ");
        }
        bw.flush();
    }
}
