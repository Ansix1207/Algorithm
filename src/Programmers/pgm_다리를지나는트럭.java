package Programmers;

import java.io.IOException;
import java.util.*;

public class pgm_다리를지나는트럭 {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int solution1 = solution.solution(2,10,new int[]{7,4,5,6});
    }
    static class Work{
        int truck_weight;
        int bl;

        public Work(int truck_weight, int bl) {
            this.truck_weight = truck_weight;
            this.bl = bl;
        }
    }
    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            Deque<Integer> q = new LinkedList<>();
            //큐가 비었을때( 다리를 건너는 트럭이 없을 때)
                //큐에 다음 트럭을 추가하고, 그 무게를 SUM에 더해주고 건너는 시간을 증가 시킨다.
            //큐가 비어있지 않을 때( 다리 위에 트럭이 있을 때)
                //1. 큐의 사이즈와 다리의 길이가 같을 때 (다리 위에 트럭이 다 올라가 있을때)
                    //큐의 사이즈와 다리의 길이가 같을 때는 가장 앞에 있는 트럭이 다리를 통과해 나갈 차례, 큐에서 처음 값을 빼고
                    //그만큼의 무게를 무게의 합에서 빼준다.
                //2. 다음 트럭이 최대 무게를 초과할 때
                    //다음 트럭이 최대 무게를 초과할 때는 트럭 무게 대신 0을 넣어주고 시간만 증가 시킨다.
                //3.다음 트럭이 최대 무게 이내일 때
                    //반대로 최대무게 이내는, 다음 트럭의 무게를 큐와 다리위 트럭 무게의 합에 더해주고 시간을 증가시킨다
            int sum = 0;
            for (int truck : truck_weights) {
                while(true){
                    //큐가 비면 ? 다음 트럭 삽입
                    if (q.isEmpty()) {
                        q.offer(truck);
                        sum+= truck;
                        answer++;
                        break;
                    }
                    //큐가 비어있지 않을때
                    else{
                        //큐의 사이즈와 다리의 길이가 같으면, 큐에서 처음 값을 빼고 무게 합 뺴주기
                        if (q.size() == bridge_length) {
                            sum -= q.poll();
                        }
                        //다음 트럭이 최대 무게를 초과하면?
                        else if(sum+truck>weight){
                            q.offer(0);
                            answer++;
                        }
                        //다음 트럭이 최대 무게 이내
                        else{
                            q.offer(truck);
                            sum += truck;
                            answer++;
                            break;
                        }
                    }
                }
            }
            //브릿지의 길이만큼 더해줘야함(100길이 짜리라고 했을때, 100칸짜리 배열이라고 생각해보자.
            //1 인덱스에 위치하고 100위치까지 간다해도 다리의 끝쪽일뿐 다리에서 완전히 건너와야 하기 때문에
            //다리의 길이만큼 더해줘야 마지막 차가 완전히 지나온 시간이다
            return answer +bridge_length;
        }
    }
}
