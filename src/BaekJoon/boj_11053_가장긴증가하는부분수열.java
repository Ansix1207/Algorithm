package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2023/07/29 11053번 가장 긴 증가하는 부분 수열(실버2, DP) https://www.acmicpc.net/problem/11053
// TODO: 2023/07/29 성공
public class boj_11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int arr[] = new int[n + 1];
        int dp[] = new int[1000 + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            //처음들어가는 수에는 1로 초기화 한다. (자기 자신)
            dp[i]=1;
            for (int j = 1; j < i; j++) {
                //이전의 수 1번째 idx부터 비교하며 자신이 작을시 dp 값을 업데이트 한다.
                if (arr[i] > arr[j]) {
                    //자신보다작을 시에, 자신의 dp 값과 비교해서 최대값을 고르면
                    //그전에 구한 부분 수열들의 값들을 업데이트 시켜준다.
                    //LIS (Longest Increasing Subsequence) 최장 증가 부분 수열
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max  = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
}
