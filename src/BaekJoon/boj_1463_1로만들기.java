package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO: 2023/07/10 1463번 1로 만들기(실버3) https://www.acmicpc.net/problem/1463
// TODO: 2023/07/10

public class boj_1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        topDown(n, dp);
//        for (int i = 2; i < n + 1; i++) {
//            //우선 한칸씩 앞으로 가는건 +1 이동하는걸로 생각한다.
//            dp[i] = dp[i-1] + 1;
//            //그다음 2로 나눌 수 있는지확인, 이전 위치 i/2 의 이동값과 비교해서 최솟값을 최신화 한다.
//            if ( i %2 == 0 && dp[i] > dp[i/2] + 1) {
//                dp[i] = dp[i/2] + 1;
//            }
//            //그 다음 3으로 나눌 수 있는지 확인하며 이전의 숫자와 비교해서 최솟값을 최신화 한다.
//            if ( i % 3 == 0 && dp[i] > dp[i/3] + 1) {
//                dp[i] = dp[i/3]+1;
//            }
//        }
        System.out.println(dp[n]);
    }

    static int topDown(int x, int[] dp) {
        if (x == 1) {
            return 0;
        }
        if (x > 0) {
            int min = Integer.MAX_VALUE;
            min = Math.min(min, topDown(x - 1,dp));

            if (x % 3 == 0) {
                min = Math.min(min, topDown(x / 3,dp));
            }
            if (x % 2 == 0) {
                min = Math.min(min, topDown(x / 2, dp));
            }
            dp[x] = min + 1;
            return dp[x];
        }
        else {
            return dp[x];
        }
    }
}
