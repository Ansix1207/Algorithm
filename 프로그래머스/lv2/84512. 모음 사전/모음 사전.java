import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
class Solution {
        String[] str = new String[]{"A","E","I","O","U"};
        Set<String> set = new HashSet<>();
        public int solution(String word) {
            int answer = 0;
            dp("", 0);
            List<String> collect = set.stream().sorted().collect(Collectors.toList());
            answer = IntStream.range(0, set.size())
                    .filter(i -> collect.get(i).equals(word))
                    .findFirst().orElse(-1);
            return answer+1;
        }
        public void dp(String word, int l){
            if (l == str.length) {
                return;
            }
            for (int i = 0; i < str.length; i++) {
                String value = String.valueOf(new StringBuilder(word).append(str[i]));
                set.add(value);
                dp(value,l+1);
            }
        }
    }