
package Programmers;

import java.io.IOException;
import java.util.Arrays;

// TODO: 2023-09-01(001) 프로그래머스 완전탐색-최소직사각형 https://school.programmers.co.kr/learn/courses/30/lessons/86491
// TODO: 2023-09-01(001) 해결~
public class pgm_최소직사각형 {
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution().solution(new int[][]{{60,50},{30,70},{60,30},{80,40}}));
    }

        static class Solution {
            public int solution(int[][] sizes) {
                int answer = 0;
                int mv = 0;
                int mh = 0;
                //가로에 모든 긴걸 둔다, 세로에 작은걸 둔다
                //max와 비교해서 넓힌다 끝~
                for (int[] item : sizes) {
                    int v = Math.max(item[0],item[1]);
                    int h = Math.min(item[0],item[1]);
                     mv = Math.max(v, mv);
                    mh = Math.max(v, mh);
                }
                return mv*mh;
            }
    }
}
