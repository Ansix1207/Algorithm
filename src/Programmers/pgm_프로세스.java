package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pgm_프로세스 {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[]{2, 1, 3, 2}, 2);
        System.out.println("solution1 = " + solution1);
        int solution2 = solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        System.out.println("solution2 = " + solution2);
    }
    static class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1); // 내림차순 정렬
            for (int priority : priorities) {
                pq.offer(priority);
            }
            while (!pq.isEmpty()) {
                for (int i = 0; i < priorities.length; i++) {
                    // pq.peek() : 현재 가장 높은 우선순위
                    if (priorities[i] == pq.peek()) {
                        // 현재 가장 높은 우선순위가 location에 해당하면
                        if (i == location) {
                            return ++answer;
                        }
                        // 현재 가장 높은 우선순위가 location에 해당하지 않으면
                        pq.poll();
                        answer++;
                    }
                }
            }
            return answer;
        }
    }
}
