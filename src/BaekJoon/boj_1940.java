package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//todo:주몽 (주몽의 명령) - https://www.acmicpc.net/problem/1940
//todo : 성공!!
public class boj_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 재료의 개수
        int m = Integer.parseInt(br.readLine()); // 타겟 넘버
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        // 2 7 4 1 5 3
        // 1 2 3 4 5 7
        int i  =0;
        int j = n-1;
        int count = 0;
        while (i < j) {
            int sum = arr[i]+arr[j];
            if (sum == m) {
                count++;
                i++; j--;
            } else if (sum > m) {
                j--;
            } else if (sum<m){
                i++;
            }
        }
        System.out.println(count);
    }
}
