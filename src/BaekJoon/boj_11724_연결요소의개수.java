package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// TODO: 2023/06/27 11724번 연결 요소의 개수 https://www.acmicpc.net/problem/11724
// TODO: 2023/06/27 !!성공!!
public class boj_11724_연결요소의개수 {
    static ArrayList<Integer>[] list;
    static int n, m;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        //노드 생성
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < m + 1; i++) {
            //간선 부여
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if(!visit[i]){
                count++;
                bfs(i);
            }
        }
        System.out.println(count);

        /**
         *           1
         *        /  ㅣ
         *       2 --5
         *
         *       3--4---6
         *
         * */
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList();
        q.add(start);
        visit[start] = true;
        while (!q.isEmpty()) {
            //큐가 비지 않았으면
            int idx = q.poll();
//            System.out.print(idx + " ");
            for (int value : list[idx]) {
                if (!visit[value]) {
                    visit[value] = true;
                    q.add(value);
                }
            }
        }
    }
}
