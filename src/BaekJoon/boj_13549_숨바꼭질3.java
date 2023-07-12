package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.exit;

// TODO: 2023/07/11 13549번 숨바꼭질3 https://www.acmicpc.net/problem/13549
// TODO: 2023/07/11 !!성공!!
/**
 * 0-1 BFS 에 대해서 알아봐야함.
 * 순서를 *2, -1, +1 로 했더니 정답 이었다. *2 , +1, -1 로 하면 45%? 쯤에서 틀림
 * 간선간의 가중치가 0인 경우 deque 를 이용하는데 front에 넣고, 1인 경우 back 에 넣는다.
 * 이렇게 하면 가장 최적의 해, 가장 최적의 시간 복잡도를 얻을 수 있다.
 * [반례] ⬇️
 * 9 13
 * + - 순서인 경우 4, ( 9->10->11->12->13)
 * - + 순서인 경우 3이 나옵니다. (9->8->7->14->13)
 *
 *
 * */
public class boj_13549_숨바꼭질3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        if (n == m||n<0||n>=100000+1) {
            System.out.println(0);
            exit(0);
        }
        if (m < 0 || m >= 100000 + 1) {
            System.out.println(0);
            exit(0);
        }
        bfs(n, m);
    }

    static void bfs(int n, int m) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[] visit = new boolean[100001];
        q.add(new int[]{n, 0});
        while (!q.isEmpty()) {
            int[] target = q.poll();
            if (target[0] > 100000) {
                continue;
            }
            if (visit[target[0]]) {
                continue;
            }
            if (target[0] == m) {
                System.out.println(target[1]);
                return;
            }
            visit[target[0]] = true;
            if (target[0] < m) {
//                q.addFirst(new int[]{target[0]*2, target[1]});
                q.offer(new int[]{target[0] * 2, target[1]});//순간이동 할때
            }
            if (target[0] < m) {
                q.offer(new int[]{target[0] + 1, target[1] + 1});//순간이동 할때
            }
            if (target[0] > 0) {
                q.offer(new int[]{target[0] - 1, target[1] + 1});//순간이동 할때            }
            }


        }
    }
}
