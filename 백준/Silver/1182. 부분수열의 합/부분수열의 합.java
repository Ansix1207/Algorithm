import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int[] arr;
    static int cnt = 0;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        s = Integer.parseInt(line[1]);
        arr = new int[n];
        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(line[i]);
        dfs(0, 0);
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int sum) {
        if (depth == n) {
//            for (Integer num : list)
//                System.out.print(num + " ");
//            System.out.println();
            return;
        }
        if (sum + arr[depth] == s)
            cnt++;
//        list.add(arr[depth]);
        dfs(depth + 1, sum + arr[depth]);
//        list.remove(list.size() - 1);
        dfs(depth + 1, sum);
    }
}
