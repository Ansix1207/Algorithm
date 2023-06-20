package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// TODO: 2023/06/19 10971번 외판원 순회 2(실버 2)
public class boj_10971 {
    static int[][] arr;
    static int[][] sol;
    static boolean[] visited;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        sol = new int[n][n];
        visited = new boolean[n];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while (j < n) {
                arr[i][j++] = Integer.parseInt(stk.nextToken());
            }
        }
//        dfs(0, 0, n, 0, 0);
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            back(i, i, 0, 0, n);
        }
        System.out.println("min = " + min);
    }
    // 0,0

    /**
     * (0,0) [0] (0,1)[10]  (1,0) (1,1) (1,2)
     */
    static void back(int start, int now, int sum, int depth, int n) {
        // i j 출발 -> j i 이면 도착, 마지막 w [j] [i] 더해준뒤에 min>sum 구하기
        if (depth == n - 1) {
            if (arr[now][start] != 0) {
                sum += arr[now][start];
                min = Math.min(sum, min);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            //0,0 제외 0,1 v[0,1]=T. back(0,1,sum,1)
            //            v[2]=T, 1,2
            if (!visited[i] && arr[now][i] != 0) {
                visited[i] = true;
//                sum = sum + arr[now][i];
                back(start, i, sum+arr[now][i], depth + 1, n);
                visited[i] = false;
            }
        }
    }

//    static void dfs(int start, int now, int sum) {
//        if (n == depth) {
//            sum = sum + arr[j][i];
//            if (sum < min) {
//                min = sum;
//            }
//        } else {
//            for (int k = 0; k < n; k++) {
//                if (arr[depth][k] != 0 && !visited[k]) {
//                    visited[k] = true;
//                    sum = sum + arr[depth][k];
//                    dfs(depth + 1, k, n, depth + 1, sum);
//                    visited[k] = false;
//                }
////                for (int t = 0; t < n; t ++){
////                    if (arr[k][t] != 0 && !visited[t]) {
////                        visited[t] = true;
////                        sum = sum + arr[k][t];
////                        dfs(k, t, n, depth + 1, sum);
////                        visited[t]=false;
////                    }
////                }
//            }
//        }
//    }
}
