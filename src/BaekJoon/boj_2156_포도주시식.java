package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO: 2023/08/04 2156번 포도주 시식 (실버1) https://www.acmicpc.net/problem/2156
// TODO: 2023/08/04 !!성공!!
public class boj_2156_포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (n < 3) {
            int answer  = 0;
            for(int i = 1 ; i<n+1;i++)answer += arr[i];
            System.out.println(answer);
            return;
        }
        dp[1] = arr[1];
        dp[2] = arr[1]+arr[2];
        //X를 기준으로 보면 O는 이전까지 완성된 경우의 수이다.
        // OOX 일 경우는 dp[i-1] 까지의 값이고
        // OXO일 경우는 dp[i-2]까지 값 + i-1은 아무것도 안더하고, arr[i]를 더해주면 되고
        //(O)XOO 일 경우는 dp[i-3]을 해준 값에 arr 개별값인 arr[i-1] + arr[i] 를 해주면 된다.
        // OOX -> dp[i-1], OXO -> dp[i-2]+arr[1], XOO -> dp[i-3] + arr[i-1] + arr[i]
        dp[3] = Math.max(dp[2], Math.max(dp[1]+arr[3],arr[2]+arr[3]));
        for (int i = 4; i < n+1; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }
        System.out.println(dp[n]);

        /**
         * 6   10 13 9   8 1
         * 6 + 10 +  9 + 8
         *
         * */
    }
}
