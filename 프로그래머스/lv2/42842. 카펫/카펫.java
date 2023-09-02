import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int i = 3; i  < sum ; i ++){
            int j = sum/i;
            if(sum%i==0 && j>=3){
                //긴쪽이 가로
                int hol = Math.max(i,j);
                int ver = Math.min(i,j);
                int center = (hol-2) * (ver-2);
                
                if(center == yellow){
                    answer[0] = hol;
                    answer[1] = ver;
                    return answer;
                }
            }
        }
        return answer;
    }
}