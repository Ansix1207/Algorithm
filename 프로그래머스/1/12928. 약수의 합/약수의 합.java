import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        Set<Integer> set = new HashSet();
        for(int i = 1 ; i <= n; i ++){
            if(n%i == 0){
                set.add(i);
                // set.add(n/i);
            }
        }
        for(int i:set){
            answer+=i;
        }
        return answer;
    }
}