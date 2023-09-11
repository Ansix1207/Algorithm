import java.util.*;
class Solution {
public int solution(int x, int y, int n) {
    int[] dp = new int[y + 1];
    Arrays.fill(dp,10000);
    dp[x] = 0;
    for (int i = x; i < y + 1; i++) {
        //첫 시작부분이 아니고, 
        // if (i != x && dp[i] == 0) {
        //     dp[i] = -1;
        //     continue;
        // }
        if (i * 2 <= y) {
            dp[i * 2] = Math.min(dp[i] + 1, dp[i * 2]);
        }
        if (i * 3 <= y) {
            dp[i * 3] =  Math.min(dp[i] + 1, dp[i * 3]);
        }
        if (i + n <= y) {
            dp[i + n] = Math.min(dp[i] + 1, dp[i + n]);
        }
    }
    return dp[y]==10000?-1:dp[y];
}
}