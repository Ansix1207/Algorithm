package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2023/08/04 15988번 1,2,3더하기 (3) (실버2) https://www.acmicpc.net/problem/15988
// TODO: 2023/08/04 성공
public class boj_15988_123더하기3 {
    static long cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[1_000_001];
        dp[1] =1 ;
        dp[2] = 2;
        dp[3] = 4; //4 = 7, 5 = 13, 6=24, 7= 44, 8=81 (44+24+13)

            for (int i = 4; i <= 1_000_000; i++) {
                dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%1_000_000_009;
            }
        for (int tc = 0; tc < n ; tc++ ) {
            int target = Integer.parseInt(br.readLine());
            System.out.println(dp[target]);
        }

    }

    /**
     *  1 1 1 1 1 / only  1 v
     *
     *  1 1 1 2  / only 2 + 1 v
     *  1 1 2 1         v
     *  1 2 1 1     v
     *  2 1 1 1     v
     *
     *  1 2 2       v
     *  2 1 2       v
     *  2 2 1       v
     *
     *  1+1+3
     *  1+3+1       v
     *  3+1+1       v
     *
     *  2+3
     *  3+2         v
     *
     * 1 1 1 1 1
     *   1 1 2 1        5=  x+1+2
     *   1 2 1 1
     *   2 1 1 1
     *     2 2 1
     *     3 1 1
     *     1 3 1
     *
     *   1 1 1 2
     *   1 2 2
     *   2 1 2
     *   3 2
     *
     *     2 3
     *   1 1 3
     *
     *
     *
     * */
}
