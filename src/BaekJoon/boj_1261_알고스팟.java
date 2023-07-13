package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// TODO: 2023/07/13 1261번 알고스팟 (골드4) https://www.acmicpc.net/problem/1261
public class boj_1261_알고스팟 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] arr;
    static boolean[][] visit;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        arr = new int[m+ 1][n + 1];
        visit = new boolean[m + 1][n + 1];
        System.out.println(1<1);
        System.out.println(1<=1);
        System.out.println(1<2);
        System.out.println(1<0);
        System.out.println(0<1);
        for (int i = 1; i < m + 1; i++) {
            String str = br.readLine();
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = str.charAt(j-1) - '0';
            }
        }
        System.out.println(bfs(1,1));

//        for (int i = 1; i < m + 1; i++) {
//            for (int j = 1; j < n + 1; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
    }

    static int bfs(int sx, int sy) {
        Deque<int[]> dq = new ArrayDeque();
        dq.add(new int[]{sx, sy,0});
        arr[sx][sy] = -1;
        visit[sx][sy] = true;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int cx = cur[0];
            int cy = cur[1];
            int w = cur[2];
            if (cx == m && cy == n) {
                return w;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nw = w+1;
                if(nx<1 || nx>m || ny<1 || ny>n) continue;
                if(visit[nx][ny] || arr[nx][ny]==-1) continue;
                if (arr[nx][ny] == 0) {
                    dq.addFirst(new int[]{nx,ny,w});
                    visit[nx][ny] = true;
                    continue;
                }
                dq.addLast(new int[]{nx, ny,nw});
                visit[nx][ny] = true;
            }
        }
        return 0;
    }
}
