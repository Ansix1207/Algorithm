package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2023-06-12 10824번 "네 수" (브론즈3)
// TODO: 2023-06-12 !!성공!!
public class boj_10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        String n1 = stk.nextToken() + stk.nextToken();
        String n2 = stk.nextToken() + stk.nextToken();
        Long n3 = Long.parseLong(n1);
        Long n4 =Long.parseLong(n2);
        System.out.println(n3+n4);
    }

}
