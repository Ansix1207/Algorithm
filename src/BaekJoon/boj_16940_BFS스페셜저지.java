package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

// TODO: 2023/07/07 16940번 BFS 스페셜저지 (골드3) https://www.acmicpc.net/problem/16940
// TODO: 2023/07/07 처음 DFS로 조합 만들었으나 잘못 생각함, 깊이가 1이 처음이라고 할때, 2일때만 구하면 되는줄 알았는데
// TODO: 2023/07/07 아니었음. 그 아래도 bfs로 돌면 무수한 경우의 수가 나옴, 이 풀이는 레벨마다 bfs에 q.add 해주는걸 원리로
// TODO: 2023/07/07 더해주기전에 result는 순서에맞게 queue 에서 꺼내오고, temp 라는 순서는 안따지는 Set 에 넣어놓은 같은 레벨
// TODO: 2023/07/07 원소들이랑 비교한다. temp.contain(result.poll()) 하여 확인한다 있으면? 같은 레벨에 있는거지. 체크 다음 단계로
// TODO: 2023/07/07 속해있지 않아? 그럼 아예 다른 레벨, 아니면 아예 없는 원소 그럼 탈출. 틀린것이다.
public class boj_16940_BFS스페셜저지 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList(); //정점 저장리스트
    static Queue<Integer> result = new LinkedList<>();//순서 저장 큐
    static int n ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        //그래프 저장
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        int size = n;
        //입력되는 순서를 저장한다.
        for (int i = 0; i < size; i++) {
            result.add(Integer.parseInt(stk.nextToken()));
        }
        int first = result.poll();
        if (first != 1) {
            System.out.println(0);
            return;
        }else{
            if (bfs2(1)) {
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
        br.close();
    }
    static boolean bfs2(int start){
        //큐 하나 만들기
        Queue<Integer> q = new LinkedList<>();
        //같은 레벨 정점 저장용 셋 하나 만들기.
        //저장용 비짓 하나 만들기
        boolean[] visit = new boolean[n + 1];
        q.add(start);
        visit[start] = true;
        while (!q.isEmpty()) {
            HashSet<Integer> set = new HashSet<>();
            //뽑아서 비교해야함 result랑 저건 순서 저장용 리스트
            int now = q.poll();
            for (int v : list.get(now)) {
                if (!visit[v]) {
                    set.add(v);
                    visit[v] = true;
                }
            }
            if (!result.isEmpty()) {
                for (int i = 0; i < set.size(); i++) {
                    int res_cur = result.poll();
                    if (set.contains(res_cur)) {
//                        set.remove(res_cur);
                        q.add(res_cur);
                    }
                    else{
                        return false;
                    }
                }
            }
//            set.clear();
        }
        return true;
    }

    static boolean bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> temp = new HashSet<>(); //지역 정점 저장 HashSet
        boolean[] visit = new boolean[n + 1];
        visit[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : list.get(cur)) {
                if (!visit[next]) {
                    temp.add(next);
                    visit[next]= true;
                }
            }
            //HashSet에 입력되는 순서에 맞게 존재하는지 확인 및 순서에 맞게 BFS탐색 진행
            if (!result.isEmpty()) {
                for (int i = 0; i <  temp.size(); i++) {
                    //순서가 같아야하는 어레이리스트에서 값을 가져와서 지역 정점과 비교한다
                    int num = result.poll();
                    //같은 레벨에 속하는 정점이 있으면 정상처리. 큐에 넣고 진행한다.
                    if(temp.contains(num))
                        q.add(num);
                    else //같은 레벨에 속한 정점이 아니네? 그럼 틀린거지.
                        return false;
                }
            }
            temp.clear();
        }
        return true;


    }
}
