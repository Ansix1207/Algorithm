package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.exit;

// TODO: 2023/07/06 16929번 Two Dots https://www.acmicpc.net/problem/16929
// TODO: 2023/07/06 !!성공!!
public class boj_16929_TwoDots {
    static int n,m;
    static char map[][];
    static boolean visit[][];
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0, 0, 1, -1};
    static int tx,ty;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
         n = Integer.parseInt(stk.nextToken());
         m = Integer.parseInt(stk.nextToken());
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = (s.charAt(j));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit = new boolean[n][m];
                tx = i; ty=j;
                if(dfs(i, j,-1,-1,map[i][j],1)){
                    System.out.println("Yes");
                    exit(0);
                }
            }
        }
        System.out.println("No");
    }

    static boolean dfs(int startX, int startY,int ox,int oy, char alp,int cnt){
//        System.out.println("nextX = " + startX);
//        System.out.println("nextY = " + startY);
//        System.out.println("map[nextX][nextY] = " + map[startX][startY]);
        if (visit[startX][startY] == true && cnt >=4) {
            return true;
        }
        visit[startX][startY] = true;
        for (int i = 0; i < dx.length; i++) {
            int nextX = startX + dx[i];
            int nextY = startY + dy[i];
            if(nextX<0 || nextY<0 || nextX>=n|| nextY>=m)
                continue;
            if(nextX==ox && nextY == oy)
                continue;
            if ((alp == map[nextX][nextY])) {
                //방문하지 않았고 지금거랑 다음거랑 값이 같으면 들어감
//                visit[nextX][nextY] = true;
                if(dfs(nextX, nextY,startX,startY,map[nextX][nextY],cnt+1)){
                    return true;
                }
            }
        }
        return false;
    }
}
