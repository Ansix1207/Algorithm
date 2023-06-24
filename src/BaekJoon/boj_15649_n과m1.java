package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// TODO: 2023/06/23 15649번 N과 M (1) (실버 3) 
// TODO: 2023/06/23 !!성공!!
public class boj_15649_n과m1 {
    static int n ;
    static int m;
    static boolean[]visit;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        visit = new boolean[n];
        back(0);
    }
    //1~n 까지 간다.
    // 만약 2가 현재 루트라면, 2를 제외한 모든노드를 출력한다.
    // 만약 2, 3 이 선택되었고 1과 4가 남아있다면 선택된것을 제외하고 하나씩 출력한다.

    static void back(int l){
        //우선 탈출 조건 m 은 출력할 개수 이다
        if (l == m) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            //만약 노드들에 방문하지 않았으면 dfs 실행한다.
            if (!visit[i]) {
                visit[i] = true;
                list.add(i+1);
                back(l + 1);
                visit[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}
