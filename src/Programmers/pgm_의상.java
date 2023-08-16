package Programmers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

// TODO: 2023/08/16 해시-의상 (레벨 2 ) https://school.programmers.co.kr/learn/courses/30/lessons/42578?language=java
// TODO: 2023/08/16 성공
public class pgm_의상 {
    public static void main(String[] args) throws IOException {
        int solution = Solution.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
        System.out.println(solution);

    }

    static class Solution {
        static public int solution(String[][] clothes) {
            HashMap<String, Integer> map = new HashMap<>();
            int answer = 1;
            for (int i = 0; i < clothes.length; i++) {
                if (!map.containsKey(clothes[i][1])) {
                    map.put(clothes[i][1], 1);
                } else {
                    map.put(clothes[i][1], map.get(clothes[i][1])+1);
                }
                }
            Set<String> keySet = map.keySet(); //의상종류.

            //옷3가지 & 모자 3가지 입는 방법은
            // 안입거나, 입거나, 한개만 입거나, 두개 다 입거나
            //각 옷의 종류의 수 + 1 끼리 곱하고 나서, 모든 옷을 안입는 경우의 수는 뺀다.
            for (String key : keySet) {
                answer *= map.get(key)+1;
            }

            return answer-1;
        }
    }
}
