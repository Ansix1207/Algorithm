package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

// TODO: 2023/06/13 1107번 리모컨 (골드5)
// TODO: 2023/06/13 !!나중에 다시 풀기!!
public class boj_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         * 리모컨은 0~9와 +, - 버튼이 있음.
         * '+' 누르면 현재 채널에서 +1된 채널로 이동
         * '-' 누르면 현재 채널에서 -1된 채널로 이동
         *  0 에서 '-' 누르면 채널 변경 X
         *
         *  이동하려고 하는 채널은 N이고, N으로 이동하기 위해서 최소 몇번 눌러야 하는가
         *  지금 보고있는 채널은 100 번이다.
         *
         *  첫째줄에 채널 N
         *  둘째줄에 고장난 버튼의 개수
         *  셋째 줄에는 고장난 버튼, 같은 버튼 존재 X
         *
         * */
        int n = Integer.parseInt(br.readLine());
        String sn = String.valueOf(n);
        int cnt = 0;//몇번 눌렀는지
        int cur = 100;
        int[] btn = new int[10];
        for (int i = 0; i < 10; i++) {
            btn[i]=i;
        }
        StringTokenizer stk = new StringTokenizer(br.readLine());
        while(stk.hasMoreTokens()){
            btn[Integer.parseInt(stk.nextToken())] = 0;
        }
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for (int j = 0; j < len; j++) {
                if (btn[str.charAt(j) - '0'] == 0) {
                    isBreak=true;
                    break;
                }
            }
            if (!isBreak) {
                int min = Math.abs(n-i) + len;//i를 누른 후 target 까지 이동하는 횟수
                cur = Math.min(min, cur);
            }
        }
        System.out.println(cur);
    }
}
