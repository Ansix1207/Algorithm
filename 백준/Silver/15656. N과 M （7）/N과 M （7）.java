import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: 2023/06/20 15656번 N과 M (7) (실버 3)
// TODO: 2023/06/20
public class Main {
    static int[] arr;
    static int[] result;
    static int n,m;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        arr = new int[n];
        result = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        bw.flush();
    }
    static void dfs(int depth) throws IOException {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(result[i]+" ");
            }
            bw.write("\n");
            return;
        }
        else{
            for (int i = 0; i < n; i++) {
                    result[depth] = arr[i];
                    dfs(depth+1);
            }
        }
    }
}
