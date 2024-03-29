
package Programmers;

import java.io.IOException;
import java.util.Arrays;

// TODO: 2023/08/16 정렬-pgm_가장큰수 https://school.programmers.co.kr/learn/courses/30/lessons/42746
// TODO: 2023/08/16
public class pgm_가장큰수 {
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution().solution(new int[]{3,5,9,30,34}));
    }

        static class Solution {
            public String solution(int[] numbers) {
                String[] arr = new String[numbers.length];
                for (int i = 0; i < arr.length; i++) {
                    arr[i]= String.valueOf(numbers[i]);
                }
                //핵심은 아래 라인 (내림차순, 즉 큰 값들로 정렬되고 더하기만 하면 됨)
                //자바의 문자열 정렬 방식은 아래와 같음.
                //"abc".compareTo("abcde") == -2 [기준값에 비교대상이 포함되어있을경우 문자열의 길이 차이값을 리턴]
                //"abc".compareTo("cde") == -2 [compareTo는 같은 위치의 문자만 비교, 첫번째 문자부터 순서대로 비교해서 다를경우
                // 아스키 값을 기준으로 비교 처리를 한다. 첫번째 위치에서 비교가 실패했기때문에(a != c)  a=97 / c=99 이기때문에 -2값이 리턴]
                //https://mine-it-record.tistory.com/133
                Arrays.sort(arr,(o1,o2)->((o2+o1).compareTo(o1+o2)));

                if (arr[0].equals("0")) {
                    return "0";
                }
                StringBuilder answer = new StringBuilder();

                for (int i = 0; i < arr.length; i++) {
                    answer.append(arr[i]);
                }
                return answer.toString();
            }
    }
}
