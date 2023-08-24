package Programmers;

import java.util.PriorityQueue;

// TODO: 2023/08/24 42628번 이중우선순위큐(레벨3) [힙]  https://school.programmers.co.kr/learn/courses/30/lessons/42628
// TODO: 2023/08/24 성공!! 
public class pgm_이중우선순위큐 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        public int[] solution(String[] operations) {
            int[] answer = {};
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int i = 0; i < operations.length; i++) {
                String[] s = operations[i].split(" ");
                String op = s[0];
                int num = Integer.parseInt(s[1]);
                if (op.equals("I")) {
                    pq.add(num);
                    pq2.add(num);
                } else {
                    if (!pq2.isEmpty() && !pq.isEmpty()) {
                        //명령어가 d인 경우
                        if (num == 1) {
                            //최대값 삭제
                            //pq2가 최대값이 맨 앞(내림차순)
                            Integer poll = pq2.poll();
                            pq.remove(poll);
                        } else if (num == -1) {
                            Integer poll = pq.poll();
                            pq2.remove(poll);
                        }
                    }
                }
            }
            if (pq.size() <= 0) {
                return new int[]{0, 0};
            } else if (pq.size() == 1) {
                return new int[]{pq.peek(), pq.peek()};
            } else
                return new int[]{pq2.peek(), pq.peek()};
        }
    }
}
