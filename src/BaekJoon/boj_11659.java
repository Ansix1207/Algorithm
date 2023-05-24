package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2023/05/24 : 구간 합 구하기 4  https://www.acmicpc.net/problem/11659
public class boj_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[] arr = new int[n+1];
        stk = new StringTokenizer(br.readLine());
        //합배열 공식  : s_arr[i] = arr[i] + s_arr[i-1]
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(stk.nextToken()) + arr[i-1];
        }
        //구간합 구하기 공식 : 입력이(i,j) -> s_arr[j] - s_arr[i-1]
        for (int j = 0; j < m; j++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            System.out.println(arr[y]-arr[x-1]);
        }
    }

}
