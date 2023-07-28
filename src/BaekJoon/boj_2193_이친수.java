package BaekJoon;

// TODO: 2023/07/27 2193번 이친수 (실버 3) https://www.acmicpc.net/problem/2193

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2193_이친수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long dp[] = new long[n + 1];
        dp[1] = 1l;
        dp[2] = 1l;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        System.out.println(dp[n]);
    }
}
