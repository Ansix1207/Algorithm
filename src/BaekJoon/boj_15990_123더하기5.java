package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15990_123더하기5 {
    static final int VALUE = 1_000_000_009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[100_001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1; //2+1
        dp[3][2] = 1; //1+2
        dp[3][3] = 1; //3
        for (int i = 4; i <= 100_000; i++) {
            //i는 현재 구하고싶은 수, j는 끝나는수 예를들어서 7은 6+1, 5+2, 4+3 으로 만들어질 수 있음.
            // 123을 통해서 구하는거니까..
            dp[i][1] = (dp[i-1][2] + dp[i-1][3])%VALUE; //이친구는 X + 끝자리 1 로 만들어질때.
            dp[i][2] = (dp[i-2][1] + dp[i-2][3])%VALUE; // 이친구는 X+ 끝자리 2로 만들어질때.
            dp[i][3] = (dp[i-3][1] + dp[i-3][2])%VALUE; //이친구는 x + 끝자리 3으로 만들어질때.
            // 중복되면 안되니까 1 2or3 (1은 들어오면 안되기때문에 2,와 3의 값들을 더해서 값을 구한다.)
        }

        for (int i = 0; i < n; i++) {
            int tc = Integer.parseInt(br.readLine());
            System.out.println((dp[tc][1]+dp[tc][2]+dp[tc][3])%VALUE);
        }
    }
}
