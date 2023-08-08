package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// TODO: 2023/08/08 9465번 스티커 (실버1) https://www.acmicpc.net/problem/9465
// TODO: 2023/08/08 !!이해 함!!
public class boj_9565_스티커 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp(n));
        }
    }

    /**
     * 1번째에 0,0을 골랐다면 1,1 , 0,3을 고르는 경우의 수
     * 마치 홀짝처럼 한칸씪 띄워서 가는 경우
     *   o   x   o
     *   x   o   x
     *
     * 또 다른 한가지 방법은
     *
     * 1번째에 0,0을 고르지 않고, 1,0을 고른 경우.
     *
     *  x   x    o
     *  o   x    x
     *
     *  또는
     *  o   x   o
     *  x   o   x
     *
     *  (0,3)의 입장에서 생각하면 그전에 모두 더해져서 dp 값에 누적되는데.
     *  두가지 경우의 수 중에서
     *  Max[(1,2) , (1,1)] 중에 하나만 고르면 된다.
     *
     *  그림에서는 o만 가지고 했는데, 사실 x에 위치한것도 같은 원리로
     *  사용하며, 맨 마지막에 땠을때에 경우의 수를 체크하는것.
     *
     * */
    public static int dp(int n) throws IOException {
        int[][] dp = new int[2][n + 1];
        int[][] arr = new int[2][n + 1];
        // initialize
        for (int j = 0; j < 2; j++) {
            String[] inputs = br.readLine().split(" ");
            for (int k = 1; k <= n; k++) {
                arr[j][k] = Integer.parseInt(inputs[k - 1]);
            }
        }
        dp[0][1] = arr[0][1];
        dp[1][1] = arr[1][1];
        for (int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
            dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
        }
        return Math.max(dp[0][n], dp[1][n]);
    }
}
