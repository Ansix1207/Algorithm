package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2023/08/03 11057번 오르막수 (실버1) https://www.acmicpc.net/problem/11057 
// TODO: 2023/08/03 !!성공!!
public class boj_11057_오르막수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        /**
         1  *  0   1       2       3          4               5   6   7   8   9
         2  *  0   11    12,22    13,23,33    14,24,34,44     15,25,35,45,55 .. 18,28,38,48,58,68,78,88  19,29,39,49,59,69,79,89,99
         3  *  0  111  112,122,222  [113, 123,223, 133,233,333]                           dp[1]119 dp[2] = dp[1] + dp[i
         4  *
         5  * */
        long[][] dp = new long[n][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                //1인 경우
                if (j == 0)
                    dp[i][j] = 1;
                else {
                // 2~9인 경우
                    dp[i][j] = (dp[i][j - 1]%10_007 + dp[i - 1][j]%10_007)%10_007;
                }
            }
        }


        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum%10_007+dp[n - 1][i]%10_007)%10_007;
        }
        System.out.println(sum);
    }
}
