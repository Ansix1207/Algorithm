package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO: 2023/07/28 11654번 아스키코드 (브론즈 5) https://www.acmicpc.net/problem/11654
// TODO: 2023/07/28 성공
public class boj_11654_아스키코드 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            System.out.println(s.charAt(0)-0);
        }
}
