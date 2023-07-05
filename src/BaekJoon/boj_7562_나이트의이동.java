package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// TODO: 2023/07/05 7562번 나이트의 이동  https://www.acmicpc.net/problem/7562
// TODO: 2023/07/05 !! 성공 !!
public class boj_7562_나이트의이동 {
    static int[][] map;
    static int tc, tx, ty;
    static int n, m, l;
    static boolean[][] visited;
//    static int[] dx = {-1, 1, 0, 0}; //x방향배열-상하
//    static int[] dy = {0, 0, -1, 1}; //y방향배열-좌우

    static int[] dx = {1,-1, -2,-2, 1,-1, 2,2}; //x방향배열-상하
    static int[] dy = {-2,-2, -1,1, 2,2, 1,-1}; //y방향배열-좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        for (int k = 0; k < tc; k++) {
            l = Integer.parseInt(br.readLine());
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            stk = new StringTokenizer(br.readLine());
            tx = Integer.parseInt(stk.nextToken());
            ty = Integer.parseInt(stk.nextToken());
            map = new int[l][l];
            visited = new boolean[l][l];
            if(x==tx&&y==ty){
                System.out.println(0);

            }else{
                //하 0,0으로 해놓고 왜 틀렸나 했네 하.. 실수하지 말자
                visited[x][y] = true;
                bfs(x, y, 0);
            }
        }
    }

    static void bfs(int sx, int sy, int level) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy, level});
        int fin = 0;
        while (!q.isEmpty()) {
            int now[] = q.poll();
            int nx = now[0];
            int ny = now[1];
            int nlevel = now[2];
            if (nx == tx && ny == ty) {
                fin = nlevel;
                break;
            }
            for (int i = 0; i < dx.length; i++) {
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= l || nextY >= l)
                    continue;
                if(visited[nextX][nextY])
                    continue;
                q.add(new int[]{nextX, nextY, nlevel + 1});
                visited[nextX][nextY] = true;
            }
        }
        System.out.println(fin);
    }
}
