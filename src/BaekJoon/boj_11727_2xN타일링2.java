package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO: 2023/07/20 2xN 타일링2 https://www.acmicpc.net/problem/11727 
// TODO: 2023/07/20  
public class boj_11727_2xN타일링2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 1000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }
        System.out.println(dp[n]);

    }
}
