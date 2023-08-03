package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2023/08/03 1699번 제곱수의합 (실버2) https://www.acmicpc.net/problem/1699
// TODO: 2023/08/03 성공 
public class boj_1699_제곱수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        //제곱수들을 미리 1로 초기화 해놓는다.
        for (int i = 1; i*i < n + 1; i++) {
            dp[i*i] = i;
        }

        for (int i = 1; i < n + 1; i++) {
//            System.out.print("i = " + i + " / ");
            dp[i] = i;
            for (int j = 1 ;j*j <= i; j++) {
                //최적화 버전 참고 링크 : https://velog.io/@kimmjieun/%EB%B0%B1%EC%A4%80-1699%EB%B2%88-%EC%A0%9C%EA%B3%B1%EC%88%98%EC%9D%98-%ED%95%A9-Java-%EC%9E%90%EB%B0%94
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                //18 j=1 -> dp[18-1] + 1
                //18 j=2 -> dp[18-4] -> dp[16] + 1
                //18 j=3 -> dp[18-9] -> dp[9] + 1
                //18 j=4 -> dp[18-16] -> dp[2] + 1

                //dp[9] = dp[9-1] +1
                //dp

//                if (dp[i] > dp[i - j * j] + 1) {
//                    dp[i] = dp[i - j * j] + 1;
//                }
//                if ((j*j )> i) {
//                    continue;
//                }
//                int num = i;
//                int cnt = 0;
//                //j가 2야. 그럼 i가 4일땐 2^2 나누면 몫은 1
//                cnt = num/(j*j) + (dp[num%(j*j)]);
//                dp[i] = Math.min(dp[i], cnt);
////                System.out.print(cnt+" ");
            }
        }
        System.out.println(dp[n]);

        /**
         *  1        2          3   4   5   6   7   8   9   10
         * 1 = 1^2
         * 2 = 1^2  + 1^2
         *
         * 3 = 1 + 1 + 1;
         *  4는 두가지 방법
         * 4 =  2^2, 1+1+1+1
         * 5도 두가지 방법
         * 5 =  2^2 + 1 , 1+1+1+1+1
         *
         * 6 = 2^2 +1+1, 1+1+1+1+1+1
         *
         * 7 = 2^2 + 1+1+1, 1+1+1+1+1+1+1
         *
         * 8 = 2^2 + 2^2, 2^2 + 1+1+1+1,  1+1+1+1 1+1+1+1+
         *
         * 9 = 3^3
         * 10 = 2^2 + 2^2 + 1+ 1, 3^2 + 1, 1^2 +...
         * 11 = 2^2 + 2^2 + 1+1+1 <- dp[10] + 1 ,
         * 16 = 4^2
         *
         *
         * */
    }
}
