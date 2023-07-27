package BaekJoon;


// TODO: 2023/07/27 1912번 연속합 (실버2) https://www.acmicpc.net/problem/1912
// TODO: 2023/07/27 !!성공!! 힌트안보고 처음으로 자체 해결~

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1912_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
        /**
         * 주어진 수열에서 연속된 몇개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합...
         * 수는 한 개 이상 선택해야함.
         * */


    }
}
