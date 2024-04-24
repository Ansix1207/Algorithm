import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j<=n;j++){
                int v = Integer.parseInt(stk.nextToken());
                arr[i][j] = v+arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());
            int sum = arr[x2][y2]-arr[x1-1][y2]-arr[x2][y1-1]+arr[x1-1][y1-1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());

    }
}
