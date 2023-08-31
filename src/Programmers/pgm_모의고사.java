package Programmers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

// TODO: 2023-08-31(031) 프로그래머스 (완전탐색) 모의고사 https://school.programmers.co.kr/learn/courses/30/lessons/42840

public class pgm_모의고사 {
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution().solution(new int[]{1,2,3,4,5}));
    }
   static class Solution {
        static class person {
            public int id;
            public int idx = 0;
            public int sum = 0;
            public int[] arr;
            person(int [] a,int id){
                arr = a;
                this.id = id;
            }
        }
        public int[] solution(int[] answers) {
            ArrayList<Integer> answer = new ArrayList<>();
            person p1 = new person(new int[]{1,2,3,4,5},1);
            person p2 = new person(new int[]{2,1,2,3,2,4,2,5},2);
            person p3 = new person(new int[]{3,3,1,1,2,2,4,4,5,5},3);
            ArrayList<person> pl = new ArrayList<>();
            pl.add(p1);
            pl.add(p2);
            pl.add(p3);
            int max = -99;
            for (int i : answers) {
                for (person person : pl) {
                    if(person.idx >= person.arr.length){
                        person.idx = 0 ;
                    }
                    if(person.arr[person.idx++] == i){
                        person.sum++;
                        max = Math.max(person.sum, max);
                    }
                }
            }
            for (person person : pl) {
                if(person.sum == max){
                    answer.add(person.id);
                }
            }
            System.out.println(p1.sum);
            System.out.println(p2.sum);
            System.out.println(p3.sum);
            return answer.stream().mapToInt(i->i).toArray();
        }
    }
}
