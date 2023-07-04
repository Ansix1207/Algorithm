package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// TODO: 2023/07/04 7076 토마토
// TODO: 2023/07/04 !성공!
public class boj_7576_토마토 {
    static int[][] map;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; //x방향배열-상하
    static int[] dy = {0, 0, -1, 1}; //y방향배열-좌우
    static Queue<int[]> q = new LinkedList();
    static int cnt = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j] == 1) {
                    //출발점(1) 이 여러개인 경우가 있어 처음부터 넣어줌 큐에.
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    //맨 마지막 bfs 한바퀴 돌고 0있는지 체크
                    // 하나라도 0이 있어? 틀렸다.
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(cnt);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            //큐에 들어가있는거 꺼냄
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            cnt = Math.max(map[nowX][nowY] - 1, cnt);
            //cnt 이랑 비교해서 숫자 세는데 -1을 해준 이유는 배열 안의 값들을 쓰기 때문
            //1로 시작하고 그 다음날짜는 그전 값 + 1 씩 더해주면서 증가하기 떄문에
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                //왼쪽 오른쪽 위 아래 체크
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
                    continue;
                if (visited[nextX][nextY] || map[nextX][nextY] == -1) {
                    //-1 이면 건너뛰고, 방문했어도 건너 뛰고
                    continue;
                }

                q.add(new int[]{nextX, nextY});
                map[nextX][nextY] = map[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}
