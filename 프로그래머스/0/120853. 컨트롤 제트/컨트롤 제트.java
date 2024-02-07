import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<String> dq = new ArrayDeque();
        for(String str:s.split(" ")){
            if(str.equals("Z")){
                if(!dq.isEmpty()){
                    dq.removeLast();
                }
            }else{
                dq.addLast(str);
            }
        }
        for(String str:dq){
            answer+=Integer.parseInt(str);
        }
        return answer;
    }
}