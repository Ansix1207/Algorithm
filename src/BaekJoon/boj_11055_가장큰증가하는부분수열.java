package BaekJoon;

// TODO: 2023/08/08 11055번 가장 큰 증가하는 부분 수열 (실버2) https://www.acmicpc.net/problem/11055
// TODO: 2023/08/08 성공!! 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11055_가장큰증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i]=arr[i];
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j])
                    dp[i] = Math.max(dp[j]+arr[i] , dp[i]);
            }
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        System.out.println(max);
    }
}
