package Programmers;

import java.util.Stack;

public class pgm_올바른괄호 {
    class Solution {
        boolean solution(String s) {
            boolean answer = true;
            Stack<String> stk = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stk.push("(");
                }
                else{
                    if (stk.isEmpty()) {
                        return  false;
                    }
                    stk.pop();
                }
            }
            if (!stk.isEmpty()) {
                answer=false;
            }
            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("Hello Java");

            return answer;
        }
    }
}
