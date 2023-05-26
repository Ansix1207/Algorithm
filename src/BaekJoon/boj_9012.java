package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//TODO:2023/05/24/괄호 https://www.acmicpc.net/problem/9012
/*
문제
괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
 한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
 일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다.
 그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다.
 예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” ,
 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다.

여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.
* */
public class boj_9012 {
    //방법1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Stack<String> st = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                String token = str.substring(j,j+1);
                if(token.equals("(")){
                    st.push(token);
                }
                else if(token.equals(")")){
                    if(st.isEmpty()||(st.pop().equals(")"))){
                        System.out.println("NO");
                        break;
                    }
                }
                if (j+1>=str.length()&&st.isEmpty()) {
                    System.out.println("YES");
                    break;
                }
                else if(j+1>=str.length()){
                    System.out.println("NO");
                    break;
                }
            }
        }
    }
    //방법 2
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        for (int i = 0; i < n; i++) {
//            String str = br.readLine();
//            Stack<String> st = new Stack<>();
//            int ct = 0;
//            for (int j = 0; j < str.length(); j++) {
//                String token = str.substring(j,j+1);
//                if(token.equals("(")) ct++;
//                else ct--;
//                if (ct<0) break;
//            }
//            if (ct!=0) {
//                System.out.println("NO");
//            }
//            else {
//                System.out.println("YES");
//            }
//        }
//    }
}
