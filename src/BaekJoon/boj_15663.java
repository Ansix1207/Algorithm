package BaekJoon;

import java.io.*;
import java.util.*;

// TODO: 2023/06/21 15663번 N과 M(9) (실버2)
// TODO: 2023/06/21 !!성공!!
public class boj_15663 {
    static int[] arr;
    static int[] sol;
    static int depth;
    public static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //N개의 자연수와 자연수 M
        //N개의 자연수 중에서 M 개를 고른 수열
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        sol = new int[n];
        visited = new boolean[n];
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        //주어진 N개의 자연수들을 담은 배열을 정렬한다.
        Arrays.sort(arr);
        dfs(n,m,0);
        bw.write(sb.toString());
        bw.flush();
    }
    static void dfs(int n,int m, int depth){
        if(m == depth){
            for (int i = 0; i < m; i++) {
                sb.append(sol[i]+" ");
            }
            sb.append("\n");
        }
        else{
            int before = -1;
            for (int i = 0; i < n; i++) {
                // 1  7  9  9  &&arr[i]!=before
                if(!visited[i] & arr[i]!=before)
                    visited[i]=true;
                    sol[depth]=arr[i];
                    before = arr[i];
                    dfs(n,m,depth+1);
                    visited[i]=false;
                }
            }
        }
    }
