import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        triangle[1][0] += triangle[0][0];
        triangle[1][1] += triangle[0][0];
        System.out.print(triangle[1][0] +" ");
        System.out.println(triangle[1][1]);

        for(int i = 2 ; i < triangle.length;i++){
            for(int j = 0 ; j<triangle[i].length;j++){
                if(j==0){
                    triangle[i][j] += triangle[i-1][j];
                } else if(j==triangle[i].length-1){
                     triangle[i][j] += triangle[i-1][j-1];
                }else{
                    triangle[i][j] += triangle[i-1][j-1]<triangle[i-1][j] ? triangle[i-1][j] : triangle[i-1][j-1];
                }
                // System.out.print(triangle[i][j] +" ");
            }
            // System.out.println();
        }
        int h = triangle.length-1;
        for(int v :triangle[h]){
            if(answer<v)
                answer=v;
        }
        return answer;
    }
}