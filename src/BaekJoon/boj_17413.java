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
            if(c_arr[i] == '<' || tag){//꺽쇠를 만났을때
                while(!stack.isEmpty()){//스택이 비지 않았으면
                    System.out.print(stack.pop());//스택에 있는거 모두 출력
                }
                tag=true;//꺽쇠만난거 체크
                System.out.print(c_arr[i]);
                if (c_arr[i] == '>') {
                    tag=false;//태그 끝나면 tag=false
                }
            }
            else{//꺽쇠가 아닌 일반
                if(c_arr[i]==' '){//공백을 만나면 모두 팝
                    while(!stack.isEmpty()){//스택 안비었으ㅕㄴ
                        System.out.print(stack.pop());
                    }
                    System.out.print(' ');//출력 형식 맞추기
                }
                else{
                    stack.push(c_arr[i]);//스택에 넣기
                }
            }
        }

        while(!stack.isEmpty()){//맨 끝 처리
            System.out.print(stack.pop());
        }
    }
}
