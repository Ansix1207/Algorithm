package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

// TODO: 2023/07/06 1687번 숨바꼭질 실버1 https://www.acmicpc.net/problem/1697
// TODO: 2023/07/06 !!성공!!
public class boj_1697_숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        if (n == m) {
            System.out.println(0);
            exit(0);
        }
        bfs(n, m);
    }

    static void bfs(int n, int m) {
        Queue<int[]> q = new LinkedList();
        boolean[] visit = new boolean[100001];
        q.add(new int[]{n,0});
        while (!q.isEmpty()) {
            int[] target = q.poll();
            if (target[0] > 100000) {
                continue;
            }
            if (visit[target[0]]) {
                continue;
            }
            visit[target[0]] = true;
            if(target[0]<m) {
                if (target[0]*2==m){
                    System.out.println(target[1]+1);
                    exit(0);
                }
                q.offer(new int[]{target[0] * 2,target[1]+1});//순간이동 할때
            }
            if(target[0]<m){
                if (target[0]+1==m){
                    System.out.println(target[1]+1);
                    exit(0);
                }
                q.offer(new int[]{target[0]+1,target[1]+1});//순간이동 할때
            }
            if (target[0]>0) {
                if (target[0]-1==m){
                    System.out.println(target[1]+1);
                    exit(0);
                }
                q.offer(new int[]{target[0]-1,target[1]+1});//순간이동 할때            }
        }
    }
//    static void dfs(int n, int nextN, int m,int cnt){
//        if (nextN == m) {
//            System.out.println(cnt);
//            return;
//        }
//        if (nextN <= m) {
//            dfs(n,nextN*2,m,cnt+1);
//            dfs(n,nextN +1,m,cnt+1);
//            dfs(n,nextN-1,m,cnt+1);
//        } else {
//            return;
//        }
//    }
}}
