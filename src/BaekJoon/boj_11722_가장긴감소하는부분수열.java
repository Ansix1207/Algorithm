package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2023/08/10 11722번 가장 긴 감소하는 부분 수열 (실버 2) https://www.acmicpc.net/problem/11722
// TODO: 2023/08/10 성공
public class boj_11722_가장긴감소하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] arr = new int[n+1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        dp[1] = 1;
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            dp[i]=1;
            for (int j = 1; j < i; j++) {
                if(arr[i]<arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                /**
                 *  10  30  10  20  20  10
                 *1 1
                 *2 1
                 * */
            }
        }
        for (int i : dp) {
            result = Math.max(result, i);
        }
        System.out.println(result);
        }
}
