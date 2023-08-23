package Programmers;

import java.util.*;

// TODO: 2023/08/18 42584번 스택/큐 주식가격 https://school.programmers.co.kr/learn/courses/30/lessons/42584
public class pgm_주식가격 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] solution = s.solution(new int[]{95, 90, 99, 99, 80, 99});
//        int[] solution = s.solution(new int[]{93,30,55}, new int[]{1,30,5});
        System.out.println(Arrays.toString(solution));

    }
    static class Solution {
        public int[] solution(int[] prices) {
            int[] ans = new int[prices.length];
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    ans[i]++;
                    if(prices[i]>prices[j])
                        break;
                }
            }
            return ans;
        }
    }
}
