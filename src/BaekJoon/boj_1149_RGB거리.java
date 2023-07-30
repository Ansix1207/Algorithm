package BaekJoon;

// TODO: 2023/07/30 1149번 RGB거리 (실버1) https://www.acmicpc.net/problem/1149
// TODO: 2023/07/30 !!성공!!
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int [n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 1; j < 4; j++) {
                dp[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        for (int i = 2; i < n + 1; i++) {
            //문제에서 i번째는 i-1 과 같은 색상이면 안된다고 했음.
            //따라서 i번재는 i-1과 다른 색상인것들 둘 골라서 최소값으로 업데이트 시켜서 bottom-up 방식으로 해결
            dp[i][1] += Math.min(dp[i-1][2], dp[i-1][3]);
            dp[i][2] += Math.min(dp[i-1][1], dp[i-1][3]);
            dp[i][3] += Math.min(dp[i-1][1], dp[i-1][2]);
        }

        System.out.println(Math.min(dp[n][1],Math.min(dp[n][2],dp[n][3])));
    }
}
