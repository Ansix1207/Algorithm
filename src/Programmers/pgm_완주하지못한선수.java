package Programmers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

// TODO: 2023/08/16 해시-완주하지못한선수 https://school.programmers.co.kr/learn/courses/30/parts/12077
// TODO: 2023/08/16
public class pgm_완주하지못한선수 {
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution().solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }

        static class Solution {
        public String solution(String[] participant, String[] completion) {
            HashMap<String, Integer> map = new HashMap<>();
            String answer = "";
            for (String s : participant) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            for (String s : completion) {
                if (map.get(s) == 1) {
                    map.remove(s);
                } else {
                    map.put(s, map.get(s) - 1);
                }
            }
            return map.keySet().toString().replace("[", "").replace("]", "");
        }
    }
}
