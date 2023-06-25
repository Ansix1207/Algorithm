package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: 2023/06/25 13023번 ABCDE (골드5)
// TODO: 2023/06/25 !!성공!!
/**
 * 인접리스트와 인접행렬로 풀 수 있는 문제인데. 인접리스트로 풀어보았다.
 * 오랜만에 인접리스트로 할려니까 순간 문법때문에 해맸음 ..
 * 그리고 fill을 사용해보려고 했는데 디버깅 하면서 보니 fill(list,new ArrayList()) 한 부분에서
 * 모두 같은 주소의 리스트를 들고있길래 당황했다.
 * 찾다보니 fill은 초기화할때 주로 사용하는데 ArrayList는 한번만 생성하고, 생성한 주소를 list에 채워주는
 * 기능을 하는것 같다. 따라서 동적으로 만들어서 넣을때는 for문에 넣어 초기화함이 바람직 할것같다.
 * list안에서 받아오는 value 들이 곧 이동할 곳이기 때문에 dfs로 idx 값으로 하여금 넘겨준다.
 * 계속 돌다가 다시 원점으로 돌아오는경우나, 갈곳이 없을때(이것도 인접리스트로 했기때문에 0으로 처리 굿)
 * depth가 4가 안됐으면 성공하지 못한것으로, 4가 되면 성공이다.
 * */
public class boj_13023_ABCDE {
    static ArrayList<Integer>[] list; // 연결 리스트
    static boolean[] visit; // 방문 여부
    static int result = 0; // 정답 여부
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        list = new ArrayList[n];
        //아래것에 대해 디버깅한 내용 공유
//        Arrays.fill(list, new ArrayList<Integer>());
        for(int i = 0; i < n ; i++) {
            list[i] = new ArrayList<Integer>();
        }
        visit = new boolean[n];

        //관게 입력(양방향)
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        //dfs 가즈아~
        for(int i = 0 ; i<n;i++){
            visit[i] = true;
            dfs(i, 0);
            visit[i] = false;
            //정답 있으면 바로 끝
            if (result == 1) {
                break;
            }
        }
        System.out.println(result);
    }

    //문제 해결 아이디어
    // 간선을 타면서 depth가 높아지다가 depth==m (친구관계) 의 수가 같아지면 끝! 없으면 실패
    static void dfs(int idx,int depth) {
        if (depth == 4) {
            result = 1;
            return;
        }
        //들어가서 1번노드의 이동경로에 있는 node를 체크한다.
        for(int i : list[idx]) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(i,depth + 1);
                visit[i] = false;
            }
        }
    }
}
