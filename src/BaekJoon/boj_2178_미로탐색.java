package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// TODO: 2023/07/04 2178번 미로탐색
// TODO: 2023/07/04 !! 성공 !!
public class boj_2178_미로탐색 {
    static int[][] map;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; //x방향배열-상하
    static int[] dy = {0, 0, -1, 1}; //y방향배열-좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j =0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs2(0, 0);
        System.out.println(map[n-1][m-1]);
    }

    static void bfs2(int sx, int sy) {
        Queue<int[]> q = new LinkedList();
        q.add(new int[] {sx,sy});
        while (!q.isEmpty()) {
            int now[] = q.poll();
            int nx = now[0];
            int ny = now[1];
            for (int i = 0; i < 4; i++) {
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    // nx ny의 범위가 인덱스를 넘어가는지 체크해서 넘어가면 지나감
                    continue;
                }
                if (visited[nextX][nextY] || map[nextX][nextY] == 0) {
                    //방문을 했나? 했으면 지나감, 1이 아니야? 그럼 지나감
                    continue;
                }
                q.add(new int[]{nextX,nextY});
                map[nextX][nextY] = map[nx][ny] + 1;
                visited[nextX][nextY]=true;
            }
        }
    }
}
