package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: 2023/08/10 1932번 정수삼각형 (실버1) https://www.acmicpc.net/problem/1932 
// TODO: 2023/08/10 !!성공!! 한번에 성공! 
public class boj_1932_정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], -1);
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int count = stk.countTokens();
            for (int j = 0; j < count; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if(j==0){
                    dp[i][j]=dp[i-1][j] + arr[i][j];
                }
                else if(j==i){
                    dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[n - 1][i], max);
        }
        System.out.println(max);
    }
}
