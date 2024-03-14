import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1,o2)->{return o1[1] - o2[1];});
        int max = routes[0][1]; //진출 지점에 카메라를 설치
        answer++;
        for(int[] r : routes){
            if(max < r[0]) //진입 지점이, 이전 카메라의 위치보다 크다면, 진출지점에 새로 설치한다.
            {
                max = r[1];
                answer++;
            }
        }
        return answer;
    }
}