import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Long[] arr = new Long[n + 1];
        Long[] dp = new Long[n + 1];
        Arrays.fill(dp, 0L);
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(stk.nextToken());
        }
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i + 1]) {
                dp[i]+=1;
            }
            dp[i] += dp[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int f = Integer.parseInt(stk.nextToken());
            sb.append(dp[f-1] - dp[s - 1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
