package BaekJoon;

import java.io.*;
import java.util.Stack;

//todo:1406번 에디터 https://www.acmicpc.net/problem/1406
//todo:성공
public class boj_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
//        LinkedList<Character> text = new LinkedList<>();
        Stack<Character> stack_l = new Stack<>();
        Stack<Character> stack_r = new Stack<>();
        for(char c : br.readLine().toCharArray()){
            stack_l.push(c);
        }
//        int cursor = stack_l.size(); //커서 맨 오른쪽 인덱스 값으로 초기화
        int n = Integer.parseInt(br.readLine()); //둘째 줄, 명령어 수 입력
        for (int i = 0; i < n; i++) {
            String[] token = br.readLine().split(" ");
            if (token[0].equals("L")) {//커서를 왼쪽으로 한칸 옮김(맨 앞이면 무시)
                if(stack_l.isEmpty()){//맨앞이면 무시
                    continue;
                }
                else { // 아니면
                    stack_r.push(stack_l.pop());
                }
            } else if (token[0].equals("D")) {//커서를 오른쪽으로 한칸 옮김(맨 오른쪽이면 무시)
                if(stack_r.isEmpty()) continue;
                stack_l.push(stack_r.pop());
            } else if (token[0].equals("B")) {//커서 왼쪽에 있는 문자를 삭제함 (맨 앞이면 무시)
                //삭제로 인해 커서는 한칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로
                if(stack_l.isEmpty()) continue;
                stack_l.pop();
            } else{ //" P " 일떄 문자를 커서 왼쪽에 추가함
                stack_l.push(token[1].charAt(0));
            }
        }
        while (!stack_l.isEmpty()) {
            stack_r.push(stack_l.pop());
        }
        while (!stack_r.isEmpty()) {
            bw.append(stack_r.pop());
        }
        bw.flush();
        bw.close();
    }
}
