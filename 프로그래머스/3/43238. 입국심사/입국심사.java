import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        //모든 사람들이 가장 느리게 심사받는 worst case
        long right = times[times.length - 1] *(long)n;
        while(left <= right){
            long mid = (left + right) / 2;
            long complete = 0;
            for(int time:times){
                complete+=mid/time;
            }
            if(complete<n){
                left = mid+1;
            }else{
                answer=mid;
                right = mid-1;
            }
        }
        return answer;
    }
}