package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// TODO: 2023/08/23 프로그래머스 42626번 더 맵게 (힙[Heap]) https://school.programmers.co.kr/learn/courses/30/lessons/42626 
// TODO: 2023/08/23 성공! 
public class pgm_더맵게 {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int solution1 = solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println("solution1 = " + solution1);
    }

    static class Solution {
        //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int answer = 0;
            for (Integer i : scoville) {
                pq.add(i);
            }
            while (true) {
                if (pq.size() == 1 && pq.peek() < K) {
                    return -1;
                }
                if (pq.peek() >= K)
                    break;
                int first = pq.poll();
                int second = pq.poll() * 2;
                answer++;
                pq.add(first + second);
            }
            return answer;
        }
    }
}
