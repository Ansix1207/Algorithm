package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//todo: 1158번 요세푸스 문제 https://www.acmicpc.net/problem/1158
//todo: 성공
public class boj_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        ArrayList<Integer> que = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            que.add(i);
        }
        int idx = 0;
        // 1 2 3 4 5 6 7
        /**     1 2 3. 4 5 6 7 //idx = 2 , quesize = 7 , 출력 3
         *      1 2 4, 5 6. 7 // idx = 4 ,quesize = 6 , 출력 6
         *      1 2. 4 5 7, // idx = 1 , quesize = 5 , 출력 2;
         *      1 4, 5 7. // idx = 3 , quesize = 4, 출력 7;
         *      1, 4 5. // idx = 2 , quesize = 3, 출력 5;
         *      1,. 4 // idx = 0, quesize = 2 , 출력 1;
         *      4. // idx = 0, que size = 1, 출력 4;
         *
         *      1- 인덱스의 이동은 k-1번 이동한다.
         *      2- 인덱스가 quesize를넘으면 idx = 0 으로 간다.
         * */
        for (int i = 0; i < n; i++) {
            idx = (idx+k-1)% que.size();
            if(i==0)System.out.print("<");
            if(i+1==n){
                System.out.print(que.remove(idx)+">");
                break;
            }
            System.out.print(que.remove(idx)+", ");
        }
    }
}
