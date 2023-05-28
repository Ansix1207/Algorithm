package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//todo:단어 뒤집기2 (실버3) https://www.acmicpc.net/problem/17413
public class boj_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Character> stack = new LinkedList<Character>();
        char[] c_arr = br.readLine().toCharArray();
        boolean tag = false;
        for (int i = 0; i < c_arr.length; i++) {
            if(c_arr[i] == '<' || tag){
                while(!stack.isEmpty()){
                    System.out.print(stack.pop());
                }
                tag=true;
                System.out.print(c_arr[i]);
                if (c_arr[i] == '>') {
                    tag=false;
                }
            }
            else{
                if(c_arr[i]==' '){
                    while(!stack.isEmpty()){
                        System.out.print(stack.pop());
                    }
                    System.out.print(' ');
                }
                else{
                    stack.push(c_arr[i]);
                }
            }
        }

        while(!stack.isEmpty()){//맨 끝 처리
            System.out.print(stack.pop());
        }
    }
}
