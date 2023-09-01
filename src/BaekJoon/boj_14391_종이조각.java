package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14391_종이조각 {
    static int N, M;
    static int[][] p;
    static boolean[][] visit;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        p = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++)
                p[i][j] = input.charAt(j) - '0';
        }
        /////// 위의 코드에서 string 으로 전달받은 숫자를 charat 사용한뒤에 '0'을 빼줘서 int 형으로 초기화 시킴.
        DFS(0, 0, 0);
        System.out.println(answer);
    }

    static void DFS(int depth, int num, int sum) {
        //DFS의 매개변수는 depth, num sum 이다.
        //depth를 이용해 종료 시점을 정하고, 접근할 행, 열의 위치를 구한다.
        //nums에는 종이를 자른 값을 저장한다. 한칸씩 더 자를때마다 행,열 위치를 구한다.
        //sum에는 종이를 그만 자르고자 할때, num 값을 누적하여 더한다. 이때 sum에 더해준 num은 0으로 초기화 해야함.
        if (depth == N * M) {
            answer = Math.max(sum, answer);
            return;
        }
        //N 은 row를 의미
        //M은 column 을 의미
        //만약 N=4 M=3 이면
        /** N=4 M=3
         *
         *  0   0   1
         *  0   1   0
         *  1   1   1
         *  1   0   0
         *
         * depth가 0 / 3 = 0  ||   1/3 = 0  ||  2/3 = 0 ||  3/3 = 1
         * 즉 column 크기만큼 넘어가면 row index를 계산함
         *
         *  0 % 3 = 0 || 1 % 3 = 1 || 2 % 3 = 2  || 3 % 3 = 0 ...
         *  column 크기만큼 넘어가면 column index 를 계산함.
         * */
        int r = depth / M;
        int c = depth % M;
        //매개변수로 전달받은 depth를 통해 배열의 행과 열을 구한다.
        //구간 배열의 위치를 이미 방문했다면, 아무것도 진행하지 않고 다음 DFS를 호출한다.
        if (visit[r][c]) {
            DFS(depth + 1, num, sum);
        } else {

            /***
             *  종이를 자르는 경우는 아래의 세 가지 경우가 존재한다.
             *  1) 자기 자신만 자르는 경우
             *  2) 세로로 한칸 포함해서 자르는 경우
             *  3) 가로로 한칸 포함해서 자르는 경우
             */
            //해당 위치를 방문하지 않았으면 방문처리 한다.
            visit[r][c] = true;
            //여기에서는 문자열붙이기 -> Integer.parseInt 안하고 *10씩 해서 옆으로 미는듯?
            num = num * 10 + p[r][c];
            DFS(depth + 1, 0, sum + num);
            /** 위의 경우에는 num에 자기 자신만 포함한뒤에 sum에 더해주는 작업을 함으로 1) 에 해당한다.*/

            int i, temp = num;
            for (i = r + 1; i < N; i++) {
                if (visit[i][c])
                    break;

                visit[i][c] = true;
                temp = temp * 10 + p[i][c];
                DFS(depth + 1, 0, sum + temp);
            }

            for (int j = r + 1; j < i; j++)
                visit[j][c] = false;
            /** 2)에 해당한다, 위의 경우에는 1칸씩 하는 경우가 모두끝난 뒤에 맨 오른쪽 아래-> 왼쪽으로 visited가 해제되는데
             *  한칸 위가 비었을경우에만 한칸 아래 인덱스를 참조해서 엮은뒤에 sum값을 추출하고, 자른 만큼만 다시 초기화한다.
             * */

            temp = num;
            for (i = c + 1; i < M; i++) {
                if (visit[r][i])
                    break;
                visit[r][i] = true;
                temp = temp * 10 + p[r][i];
//                DFS(depth + i - c + 1, 0, sum + temp);
                DFS(depth + 1, 0, sum + temp);
                //결국 depth + c+ 1 -c + 1 ==> depth +2 인데 틀렸는지 모르겠음
                // 제출 해봤는데 +1 이 정답처리 됨 오예
            }

            for (int j = c + 1; j < i; j++)
                visit[r][j] = false;

            visit[r][c] = false;
        }
    }
}
