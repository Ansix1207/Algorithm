package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: 2023/06/25 14889번 스타트와링크 (실버2)  https://www.acmicpc.net/problem/14889
/**
 * 인원수가 n/2 로 딱 떨어진다는건 6명중에서 3명만 고르면 나머지는 상대팀이라는 것이다.
 * 인원수가 4명이면 팀당 2명일때는 1,2 / 2,1 을 더하는건 이해가 갔는데
 * 팀당 3명일떄는 어떻게..? 이게 뭐지 생각했다가 풀이들을 보면서 이해해싿.
 *
 * 우선 visit 배열에 만약 1,2,3,4,5,6 중에 1,3,6번과 2,4,5번이 팀이 된다고 해보자
 * 136 245번 의 조합을 고르는것은 앞서 했던 백트래킹을 이용해 구할 수 있다.
 *  탈출조건문때 팀이 완성(depth == n/2) 가 되었을때 min을 계산함.
 *  풀이를 보다보니 1,3 / 3,1   3,6 / 6,3  1,6 / 6,1 을 더한것이 능력치 계산법이었음.
 *  2중 for문으로 i,j 와 j,1 를 확인함. 둘이 같은 F 이거나 t일경우를 구해주고.
 *  이 풀이에서는 true 일경우 start 팀으로 정하고 더해주었음. false 일경우는 start-link 이니
 *  sum - board[i][j] 를 빼준다.
 *  이걸 전부 반복하면 MIN 을 구할  수 있다...........
 *  최적화 하는걸 봤는데 수학 지식 0라서  어렵다 ㅎ..
 * */
public class boj_14889_스타트와링크 {
    static int board[][];
    static int n;
    static int MIN,MAX;
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];
        visit =new boolean[n+1];
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 1;  j < n + 1; j++) {
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        MIN = Integer.MAX_VALUE;
        makeCombination(n/2,1);
        System.out.println(MIN);
        // 1 2 3 4 5 6
        // 1 3 6번 (스타트 팀)    , 2번 4번 5번 (링크팀)
        // T F T F F T
        //체크는 1,3 1,6 3,6   -  2,4 2,5 4,5
        // (1 + 1 + 3 ) -  (2 + 2 + 4)
        // 5 - 8
    }
    private static void makeCombination(int choose,int startidx) {
        if (choose == 0) {
            System.out.println(Arrays.toString(visit));
            int sum = 0;
            for (int r = 1; r < n + 1; r++) {
                for (int c = 1; c < n + 1; c++) {
                    //r==c 인 경우는 불필요.
                    if (visit[r] == visit[c]) {
                        if(visit[r]){//true 이면 스타트 팀
                            sum += board[r][c]; //true 만 골라서 더해줌
                        }else{
                            sum -= board[r][c];
                        }
                    }
                }
            }
            System.out.println("MIN = " + MIN  + " this sum =  " + sum);
            System.out.println("=====================");
            MIN = Math.min(MIN, Math.abs(sum));
            return;
        }
        for (int i = startidx; i < n + 1; i++) {
            visit[i] = true;
            makeCombination(choose-1, i + 1);
            visit[i] = false;
        }
    }
}
