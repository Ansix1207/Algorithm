package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO: 2023/06/16 10974번 모든 순열 (실버 3)
public class boj_10974 {
    static int[] arr;
    static int[] solution;
    static boolean[] visited;
    static int depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        solution = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        dfs(0, n);
    }

    static void dfs(int depth, int n) {
        if (depth == n) {//마지막에 닿으면 답 출력
            for (int i = 0; i < n; i++) {
                System.out.print(solution[i] + " ");
            }
            System.out.print("\r\n");
            return;
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {//방문 안했으면
                    visited[i] = true;
                    solution[depth] = i+1;
                    dfs(depth + 1, n);
                    visited[i] = false;
                }
            }
        }
    }
}
