import java.util.*;
class Solution {
        static boolean visit[];
        static int arr[][];
        int answer = -1;
        public int solution(int k, int[][] dungeons) {
            arr = dungeons;
            visit = new boolean[arr.length];
            dp(k, 0, 0);
            System.out.println(answer);
            return answer;
        }
        public void dp(int tk,int t_answer,int l){
            if (l == arr.length) {
                answer = Math.max(answer, t_answer);
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                if(!visit[i]){
                    visit[i] = true;
                    if(arr[i][0]<=tk){
                        //소모 피로도를 뺌
                        dp(tk-arr[i][1],t_answer +1,l+1);
                    }else{
                        dp(tk,t_answer,l+1);
                    }
                    visit[i] =false;
                }
            }
        }
    }