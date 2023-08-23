package Programmers;

import java.util.*;

// TODO: 2023/08/18 42586번 스택/큐 기능개발 https://school.programmers.co.kr/learn/courses/30/lessons/42586
public class pgm_기능개발 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] solution = s.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
//        int[] solution = s.solution(new int[]{93,30,55}, new int[]{1,30,5});
        System.out.println(Arrays.toString(solution));

    }
    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> q = new LinkedList<>();
            List<Integer> answerList = new ArrayList<>();

            for (int i = 0; i < speeds.length; i++) {
                double remain = (100 - progresses[i]) / (double) speeds[i];
                int date = (int) Math.ceil(remain);

                if (!q.isEmpty() && q.peek() < date) {
                    answerList.add(q.size());
                    q.clear();
                }

                q.offer(date);
            }

            answerList.add(q.size());

            int[] answer = new int[answerList.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = answerList.get(i);
            }

            return answer;
        }
    }
//    static class Solution {
//        public int[] solution(int[] progresses, int[] speeds) {
//            ArrayList<Integer> answer = new ArrayList<>();
//            int idx = 0;
//            Queue<Integer> q = new LinkedList<>();
//            Queue<Integer> s = new LinkedList<>();
//            for (int i = 0; i < progresses.length; i++) {
//                q.add(progresses[i]);
//                s.add(speeds[i]);
//            }
//            while (!q.isEmpty()) {
//                boolean flag = false;
//                int cnt = 0;
//                int size = q.size();
//                for (int i = 0; i < size; i++) {
//                    if (q.peek() + s.peek() >= 100 && i == 0) {
//                        flag = true;
//                    }
//                    int x = q.poll();
//                    int y = s.poll();
//                    if (x + y < 100 || !flag) {
//                        q.offer(x + y);
//                        s.offer(y);
//                        flag = false;
//                        continue;
//                    }
//                    if (flag == true)
//                        cnt++;
//                }
//                if (cnt > 0)
//                    answer.add(cnt);
////            while (q.isEmpty()) {
////                int p = q.poll();
////                int sp = s.poll();
////                if (p + sp >= 100) {
////                    cnt++;
////                }
////                else{
////                    answer.add(cnt);
////                    cnt = 0;
////                    q.offer(p + sp);
////                    s.offer(sp);
////                }
////            }
//            }
//            return answer.stream().mapToInt(Integer::intValue).toArray();
//        }
//    }
}
