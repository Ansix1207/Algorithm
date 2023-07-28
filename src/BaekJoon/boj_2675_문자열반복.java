package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2023/07/28 2675번 문자열 반복 (브론즈 2) https://www.acmicpc.net/problem/2675
// TODO: 2023/07/28 성공
public class boj_2675_문자열반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(stk.nextToken());
            String tk = stk.nextToken();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < tk.length(); j++) {
                String s = String.valueOf(tk.charAt(j));
                sb.append(s.repeat(l));
            }
            System.out.println(sb);
        }

    }
}
