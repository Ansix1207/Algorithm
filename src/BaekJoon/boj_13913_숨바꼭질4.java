package BaekJoon;

import java.io.*;
import java.util.*;

import static java.lang.System.exit;

// TODO: 2023/07/07 13913번 숨바꼭질4 (골드4)  https://www.acmicpc.net/problem/13913
// TODO: 2023/07/08 46퍼에서 시간초과
public class boj_13913_숨바꼭질4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int MAX = 100_000;
    static int[] p = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        if (n == m) {
            bw.write(0 + "\n" + n);
            bw.flush();
            bw.close();
            exit(0);
        }
        bfs(n, m);
        bw.flush();
        bw.close();
    }

    public static class Node {
        int N;
        int CNT;

        public Node(int n, int m) {
            N = n;
            CNT = m;
        }
    }

    static void bfs(int n, int m) throws IOException {
        Queue<Node> q = new LinkedList();
        boolean[] visit = new boolean[MAX+1];
        Node start = new Node(n, 0);
        visit[n] = true;
        q.add(start);
        while (!q.isEmpty()) {
            Node target = q.poll();
            int now = target.N;
            int cnt = target.CNT;
            if (now == m) { //정답에 도달했으면?
                bw.write(cnt + "\n");
                Stack<Integer> stack = new Stack<>();
                int[] int_arr = new int[MAX+1];
                int size = 0;
                int idx = m;
                while (idx != n) {
//                    stack.add(idx);
                    int_arr[size] = idx;
                    idx = p[idx];
                    size++;
                }
                int_arr[size] = n;
//                size++;
                for (int i = size; i >= 0; i--) {
                    bw.write(int_arr[i] + " ");
                }
//                stack.add(n);
//                while (!stack.isEmpty()) {
//                    bw.write(stack.pop() + " ");
//                }
                return;
            }

            if ((now * 2 <= MAX) && (!visit[now * 2])) {//2배의 경우
                q.add(new Node(now * 2, cnt + 1));
                visit[now * 2] = true;
                p[now * 2] = now;
            }
            if (now + 1 <= MAX && !visit[now + 1]) { //+1 의 경우
                q.add(new Node(now + 1, cnt + 1));
                visit[now + 1] = true;
                p[now + 1] = now;
            }
            if (now - 1 >= 0 && !visit[now - 1]) {//-1의 경우
                q.add(new Node(now - 1, cnt + 1));
                visit[now - 1] = true;
                p[now - 1] = now;
            }
        }
    }
}
