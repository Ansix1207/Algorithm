package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2023/07/28 1152번 단어의개수(브론즈2) https://www.acmicpc.net/problem/1152 
// TODO: 2023/07/28 성공 
public class boj_1152_단어의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        System.out.println(stk.countTokens());
    }
}
