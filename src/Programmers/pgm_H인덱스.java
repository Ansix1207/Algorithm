package Programmers;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

// TODO: 2023-08-26(026) 정렬-h인덱스  https://school.programmers.co.kr/learn/courses/30/lessons/42747
public class pgm_H인덱스 {
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution().solution(new int[]{9,7,6,2,1}));
    }

        static class Solution {
            public int solution(int[] citations) {
                int answer = 0;
                Arrays.sort(citations);
                // 0 1 3 5 6
                for (int i = 0; i < citations.length; i++) {
                    int h = citations.length - i;
                    //인용된 논문의 수가 5개로 시작.
                    //citations[i] (i=0) -> 0으로 시작
                    //i=0 c[0] 0개 이상 인용된 논문은? h=5개 ok [answer = 5] h
                    //i=1, c[1] 1개 이상 인용된 논문은? h=4개 ok [answer = 4] 1>=1
                    //i=2, c[2] 3개 이상 인용된 논문은? h=3개 ok 3>=3
                    if(citations[i]>=h){
                        answer=h;
                        break;
                    }
                }
                // for(int i = answer/citations.length ;
                return answer;
            }
    }
}
