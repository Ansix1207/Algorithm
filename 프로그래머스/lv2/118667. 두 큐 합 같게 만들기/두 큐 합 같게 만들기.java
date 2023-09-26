import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
            int answer = 0;

            Queue<Long> q1 = new ArrayDeque<>();
            Queue<Long> q2 = new ArrayDeque<>();
            long goal = -99;
            long sum1 = 0;
            for (long i : queue1) {
                sum1 += i;
                q1.offer(i);
            }

            long sum2 = 0;
            for (long i : queue2) {
                sum2 += i;
                q2.offer(i);
            }
            goal = (sum1 + sum2) / 2;

            if((sum1+sum2)%2 ==1){
                //둘이 더한값이 홀수이면 반으로 나눠도 같을 수 없음
                answer = -1;
                return answer;
            }
            while (sum1 != sum2) {
                if(answer>(queue1.length+queue2.length) * 4 ){
                    return -1;
                }
                if(sum1<sum2){
                    long val = q2.poll();
                    sum1+=val;
                    sum2 -= val;
                    q1.offer(val);
                }else{
                    //sum1, 즉 q1의 합이 더 클 경우
                    sum2 += q1.peek();
                    sum1 -= q1.peek();
                    q2.offer(q1.poll());
                }
            if (q2.isEmpty() || q1.isEmpty()) {
                    answer = -1;
                    return answer;
                }
                answer++;
            }
        return answer;
    }
}