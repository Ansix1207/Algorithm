package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2023/07/11 11726번 2 x n 타일링 https://www.acmicpc.net/problem/11726
// TODO: 2023/07/11 ...? 정답 봄 수학 지식이네 이제 디피는 아이디어 그려보기 해봐야겠따
public class boj_11726_2xN타일링 {
    static int n;
    static int [][] arr;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[1000 + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }
        System.out.println(dp[n]);
    }

}
