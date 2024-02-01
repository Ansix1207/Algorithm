import java.util.*;

class Solution {
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