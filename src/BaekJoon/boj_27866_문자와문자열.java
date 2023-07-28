package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2023/07/28 27866번 문자와 문자열 (브론즈 5) https://www.acmicpc.net/problem/27866
// TODO: 2023/07/28 성공~
public class boj_27866_문자와문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        System.out.println(s.charAt(n - 1));
    }
}
