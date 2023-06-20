package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// TODO: 2023/06/20 10819번 차이를 최대로 (실버2)
// TODO: 2023/06/20 !!성공!!
public class boj_10819 {
    static int arr[];
    static int sol[];
    static boolean visited[];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int idx = 0;
        arr = new int[n];
        sol = new int[n];
        visited = new boolean[n];
        while (stk.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, n);
        System.out.println(max);
    }
    static void dfs(int depth, int n){
        if(depth==n){
            int sum = 0;
            for (int i = 0; i < n-1; i++) {
                sum += Math.abs(sol[i]-sol[i+1]);
            }
            max = Math.max(max, sum);
        }
        else{
            for (int i = 0; i < n; i++) {
                if (!visited[i]&&sol[depth]!=arr[i]) {
                    visited[i]=true;
                    sol[depth]=arr[i];
                    dfs(depth + 1, n);
                    visited[i]=false;
                }
            }
        }
    }
}
